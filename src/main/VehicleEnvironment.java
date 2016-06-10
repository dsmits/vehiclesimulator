package main;

import java.util.ArrayList;
import java.util.HashMap;


// TODO: Make thread safe
public class VehicleEnvironment{
	
	public static final double DEFAULT_WIDTH = 100;
	public static final double DEFAULT_HEIGHT = 100;
	
	public static final String DEFAULT_VEHICLE = "CAR";
	
	
	private HashMap<String, Vehicle> vehicleMap;
	
	private VehicleFactory vFactory;
	
	public VehicleEnvironment(){
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
	}
	
	public VehicleEnvironment(double width, double height){
		
		vFactory = new VehicleFactory();
		vehicleMap = new HashMap<String, Vehicle>(); 
		
	}
	
	public Vehicle addVehicle(String vehicleType){
		
		Vehicle newVehicle = vFactory.getVehicle(DEFAULT_VEHICLE);
		
		vehicleMap.put(newVehicle.getUID(), newVehicle);
		
		return newVehicle;
		
		
		
		
	}
	
	public Vehicle getVehicle(String uid){
		return vehicleMap.get(uid);
		
	}
	
	public HashMap<String, VehicleState> getStates(){
		
		HashMap<String, VehicleState> states = new HashMap<String, VehicleState>();
		
		for(Vehicle vehicle : vehicleMap.values()){
			states.put(vehicle.getUID(), vehicle.getState());
		}
		
		return states;
		
	}
	
}