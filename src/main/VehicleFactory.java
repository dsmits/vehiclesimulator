package main;

public class VehicleFactory {
	
	public Vehicle getVehicle(String vehicleType){
		
		if(vehicleType.equalsIgnoreCase("CAR")){
			return new VehicleImpl();
		}			
			
		return null;
		
	}

}
