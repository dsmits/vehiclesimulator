package main;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import org.json.JSONObject;

//TODO: Considering switching to a websocket implementation for this
public class VehicleStatusHandler implements HttpHandler {
	
	// How often an update is sent to the client
	public static final long updateRate = 1000;
	
	VehicleEnvironment vEnvironment;
	
	
	public VehicleStatusHandler(VehicleEnvironment vEnvironment){
		this.vEnvironment = vEnvironment;
	}

	@Override
	public void handle(HttpExchange he) throws IOException {
		HashMap<String, VehicleState> statusMap = vEnvironment.getStates();
		
		String jsonString = vehicleStatesToJSON(statusMap).toString();
		he.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
		
		he.sendResponseHeaders(200, jsonString.getBytes().length);
		OutputStream os = he.getResponseBody();
		os.write(jsonString.getBytes());
		he.close();
		
	}
	

	
	private JSONObject vehicleStatesToJSON(HashMap<String, VehicleState> vStates){
		
		HashMap<String, HashMap<String, String>> mappedState = new HashMap<String, HashMap<String, String>>();
		
		for(String id : vStates.keySet()){
			VehicleState state = vStates.get(id);
			
			mappedState.put(id, state.toMap());
			
		}
		
		return new JSONObject(mappedState);
		
		
	}
	
//	public static void main(String[] args){
//	VehicleEnvironment vEnvironment = new VehicleEnvironment();
//	vEnvironment.addVehicle("CAR");
//	vEnvironment.addVehicle("CAR");
//	
//	
//	JSONObject jsonState = vehicleStatesToJSON(vEnvironment.getStates());
//	System.out.println(jsonState.toString());
//}

}
