package main;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class VehicleAddHandler implements HttpHandler {	
	VehicleEnvironment vEnvironment;



	public VehicleAddHandler(VehicleEnvironment vEnvironment){
		this.vEnvironment = vEnvironment;
	}
	
	

	@Override
	public void handle(HttpExchange he) throws IOException {
		vEnvironment.addVehicle("CAR");
	}

}
