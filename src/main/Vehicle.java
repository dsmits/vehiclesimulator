package main;



public interface Vehicle{
	
	public void steer(Vector2 velocity);
	
	//public void setSpeed(double speed);

	public VehicleState getState();
	
	public String getUID();
	
}