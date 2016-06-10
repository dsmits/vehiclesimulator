package main;

import java.util.HashMap;

public class VehicleState {
	
	public double x;
	public double y;
	
	public double velocityX;
	public double velocityY;
	
	public VehicleState(){
		this(0, 0, 0, 0);
	}
	
	public VehicleState(double x, double y, double velocityX, double velocityY){
		this.x = x;
		this.y = y;
		this.velocityX = x;
		this.velocityY = y;
		
	}
//	public VehicleState(){
//		this(0, 0, 0, 0, 0);
//	}
//	
//	public VehicleState(Vector2 location, double orientation, double rotation, double speed){
//		this(location.x, location.y, orientation, rotation, speed);
//	}
//	
//	public VehicleState(double x, double y, double orientation, double rotation, double speed){
//		this.x = x;
//		this.y = y;
//		this.orientation = orientation;
//		this.rotation = rotation;
//		this.speed = speed;
//		
//	}
	
	@Override
	public boolean equals(Object o){
		
		if(o.getClass() == VehicleState.class){
			VehicleState v = (VehicleState) o;		
			return v.x == x && v.y == y && v.velocityX == velocityX && v.velocityY == velocityY;
			
		} else{
			return false;
		}
	}

	@Override
	public String toString() {
		return "VehicleState [x=" + x + ", y=" + y + ", velocityX=" + velocityX + ", velocityY=" + velocityY + "]";
	}
	
	public HashMap<String, String> toMap(){
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("x", String.valueOf(x));
		map.put("y", String.valueOf(y));
		map.put("velocityX", String.valueOf(velocityX));
		map.put("velocityY", String.valueOf(velocityY));
		
		return map;
	}


}
