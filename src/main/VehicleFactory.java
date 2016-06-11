package main;

public class VehicleFactory {
	
	public Vehicle getVehicle(String vehicleType, VehicleEnvironment vEnvironment){
		
		if(vehicleType.equalsIgnoreCase("ROOMBA")){
			return new VehicleImpl(vEnvironment);
		}			
			
		return null;
		
	}

}
