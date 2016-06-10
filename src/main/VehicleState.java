package main;

import java.util.HashMap;

public class VehicleState {
	
	public double x;
	public double y;
	
	public double orientation;
	
	public double rotation;
	public double speed;
	
	public VehicleState(){
		this(0, 0, 0, 0, 0);
	}
	
	public VehicleState(Vector2 location, double orientation, double rotation, double speed){
		this(location.x, location.y, orientation, rotation, speed);
	}
	
	public VehicleState(double x, double y, double orientation, double rotation, double speed){
		this.x = x;
		this.y = y;
		this.orientation = orientation;
		this.rotation = rotation;
		this.speed = speed;
		
	}
	
	@Override
	public boolean equals(Object o){
		
		if(o.getClass() == VehicleState.class){
			VehicleState v = (VehicleState) o;		
			return v.orientation == orientation && v.rotation == rotation && v.speed == speed && v.x == x && v.y == y;
			
		} else{
			return false;
		}
	}

	@Override
	public String toString() {
		return "VehicleState [x=" + x + ", y=" + y + ", orientation=" + orientation + ", rotation=" + rotation
				+ ", speed=" + speed + "]";
	}
	
	public HashMap<String, String> toMap(){
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("x", String.valueOf(x));
		map.put("y", String.valueOf(y));
		map.put("orientation", String.valueOf(orientation));
		map.put("rotation", String.valueOf(rotation));
		map.put("speed ", String.valueOf(speed));
		
		return map;
	}


}
