package main;

/**
 * Factory for instantiating vehicles. At the moment there is only one vehicle
 * available with type "ROOMBA".
 *
 */
public class VehicleFactory {

	
	/**
	 * Instantiates a new vehicle. At the moment the only vehicle type available is "ROOMBA".
	 * 
	 * 
	 * @param vehicleType A string indicating the vehicle type. Possible value(s): "ROOMBA".
	 * @param vEnvironment The environment instance that is instantiating this vehicle. 
	 * @return The instantiated Vehicle.
	 */
	public Vehicle getVehicle(String vehicleType, VehicleEnvironment vEnvironment) {

		if (vehicleType.equalsIgnoreCase("ROOMBA")) {
			return new VehicleImpl(vEnvironment);
		}

		return null;

	}

}
