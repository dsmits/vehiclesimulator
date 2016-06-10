package main;



public interface Vehicle{
	
	public void steer(double degrees);
	
	public void setSpeed(double speed);

	public VehicleState getState();
	
	public String getUID();
	
}