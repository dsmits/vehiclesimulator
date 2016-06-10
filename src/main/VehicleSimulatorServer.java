package main;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class VehicleSimulatorServer {
	
	public static final int PORT = 8000;
	
	public static void main(String[] args) throws Exception{
		
		VehicleEnvironment vEnvironment = new VehicleEnvironment();
		
		
		
		HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
		System.out.println("Server started at " + PORT);
		
		server.createContext("/", new RootHandler());
		server.createContext("/vehiclestatus", new VehicleStatusHandler(vEnvironment));
		server.createContext("/vehicleoperate", new VehicleOperateHandler(vEnvironment));
		server.createContext("/vehicleadd", new VehicleAddHandler(vEnvironment));
		
		server.setExecutor(null);
		server.start();
		
		// For testing
		//Vehicle v = vEnvironment.addVehicle("CAR");
		//v.setSpeed(0.001);
		//v.steer(0.5);
		
		
	}

}

