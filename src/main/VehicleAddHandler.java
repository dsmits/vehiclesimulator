package main;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * @author djura HttpHandler for processing vehicleadd requests.
 */
public class VehicleAddHandler implements HttpHandler {
	VehicleEnvironment vEnvironment;

	public VehicleAddHandler(VehicleEnvironment vEnvironment) {
		this.vEnvironment = vEnvironment;
	}

	@Override
	public void handle(HttpExchange he) throws IOException {
		Vehicle v = vEnvironment.addVehicle("ROOMBA");

		String uid = v.getUID();

		// Not very safe, but enables users to access server opening
		// simulatorClient.html from their file browser
		he.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
		he.sendResponseHeaders(200, uid.getBytes().length);

		OutputStream os = he.getResponseBody();
		os.write(uid.getBytes());
		he.close();

	}

}
