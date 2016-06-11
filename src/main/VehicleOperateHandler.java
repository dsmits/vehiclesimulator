package main;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 *
 * VehicleOperateHandler handles requests to change the movement of a vehicle.
 * There are three required parameters: uid, rotation and speed.
 */
public class VehicleOperateHandler implements HttpHandler {
	
	VehicleEnvironment vEnvironment;
	
	
	
	public VehicleOperateHandler(VehicleEnvironment vEnvironment){
		this.vEnvironment = vEnvironment;
	}

	@Override
	public void handle(HttpExchange he) throws IOException {
		URI requestedURI = he.getRequestURI();
		String query = requestedURI.getRawQuery();
		HashMap<String, Object> params = parseQuery(query);
		
		// Parameters should be UID, velocityx and velocityy		
		Vehicle vehicle = vEnvironment.getVehicle((String)params.get("uid"));
				
		vehicle.steer(new Vector2((Double)params.get("velocityx"), (Double)params.get("velocityy")));
		
		String response = "success";
		
		he.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
		he.sendResponseHeaders(200, response.getBytes().length);
		
		OutputStream os = he.getResponseBody();
		os.write(response.getBytes());
		he.close();

	}
	
	
	private HashMap<String, Object> parseQuery(String params){
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		
		String[] split = params.split("&");
		
		for(String param : split){
			String[] splitParam = param.split("=");
			String paramName = splitParam[0];
			
			Object paramValue;
			
			if(paramName.equals("uid")){
				// Value remains String
				paramValue = splitParam[1];
				paramMap.put(paramName, paramValue);
			}else if(paramName.equals("velocityx") || paramName.equals("velocityy")){
				// Value is converted to double
				paramValue = Double.parseDouble(splitParam[1]);
				paramMap.put(paramName, paramValue);
			}
			
		}
		
		return paramMap;
		
	}

}
