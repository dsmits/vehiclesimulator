package main;

/**
 * Interface for simulated vehicles.
 */
public interface Vehicle{
	
	/**
	 * Changes the movement of the Vehicle by modifying the velocity in x and y direction.
	 * @param velocity
	 */
	public void steer(Vector2 velocity);

	/**
	 * Returns the current location and velocities of the vehicle.
	 * @return VehicleState indicating current location and velocities in x and y direction.
	 */
	public VehicleState getState();
	
	
	/**
	 * Returns the unique identifier of this vehicle instance.
	 * @return The unique identifier of this vehicle
	 */
	public String getUID();
	
}