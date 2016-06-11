package main;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

/**
 *         VehicleSimulatorServer instantiates a VehicleEnvironment and listens
 *         for requests on status updates and operating the vehicles over HTTP.
 *         <p>
 *         There are several context paths that can be called:
 *         "http://[servername]/": The root context just returns a string
 *         indicating you are requesting the Vehicle Simulation Server.
 *         <p>
 *         "http://[servername]/vehiclestatus": When requesting the
 *         vehiclestatus context a JSON string will be returned listing the
 *         locations and velocities of all vehicles in the simulator.
 *         <p>
 *         "http://[servername]:8000/vehicleoperate?uid=[UID]&velocityx=[VELOCITYX]&velocityy=[VELOCITYY]":
 *         This URL is to operate the vehicle by specifying the velocities in X
 *         and Y direction. The specified velocities are relative, the resulting
 *         velocities are dependent on the vehicle.
           <p>
 *         "http://[servername]/vehicleadd:
 *         Instantiates another vehicle.
 * 
 */
public class VehicleSimulatorServer {

	public static final int DEFAULT_PORT = 8000;

	public static void main(String[] args) throws Exception {

		int port = DEFAULT_PORT;

		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		}

		VehicleEnvironment vEnvironment = new VehicleEnvironment();

		HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
		System.out.println("Server started at " + port);

		server.createContext("/", new RootHandler());
		server.createContext("/vehiclestatus", new VehicleStatusHandler(vEnvironment));
		server.createContext("/vehicleoperate", new VehicleOperateHandler(vEnvironment));
		server.createContext("/vehicleadd", new VehicleAddHandler(vEnvironment));

		server.setExecutor(null);
		server.start();

	}

}
