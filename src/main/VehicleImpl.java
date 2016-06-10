package main;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.rmi.server.UID;

import javax.swing.UIDefaults;

// TODO: Make thread safe
public class VehicleImpl implements Vehicle{
	
	//public static final double STEERING_SENSITIVITY = 1;
	//public static final double VEHICLE_LENGTH = 10;
	//public static final double MAX_STEERING_ROTATION = Math.PI/4;
	
	private String uid;
	
	private Vector2 velocity;
	
	
	private long lastOperationTime;
	
	private Vector2 lastLocation;
	
	private VehicleEnvironment vEnvironment;
	
	
	public VehicleImpl(){
		this(new Vector2(), new Vector2());
		
	}
	
	public VehicleImpl(Vector2 location, Vector2 velocity){
		this.velocity = velocity;
		this.lastLocation = location;
		
		this.vEnvironment = vEnvironment;
		
		lastOperationTime = System.currentTimeMillis();
		
		uid = new UID().toString();
		
		//Making a UID that is also GET request friendly
		try {
			uid = URLEncoder.encode(uid, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	@Override
	public synchronized void steer(Vector2 newVelocity) {
		sync();
		velocity = newVelocity;
		
	}

//	@Override
//	public synchronized void setSpeed(double speed) {
//		sync();
//		this.speed = speed;
//		
//	}
	
	private synchronized void sync(){
		long currentTime = System.currentTimeMillis();
		
		long timeDifference = currentTime - lastOperationTime;
		
		lastLocation.x += velocity.x * timeDifference;
		lastLocation.y += velocity.y * timeDifference;
		
//		if(lastLocation.x > vEnvironment.width){
//			lastLocation.x = 0;
//		}
//		if(lastLocation.y > vEnvironment.height){
//			lastLocation.y = 0;
//		}
//		if(lastLocation.x < 0){
//			lastLocation.x  = vEnvironment.width - 1;
//		}
//		if(lastLocation.y < 0){
//			lastLocation.y = vEnvironment.height - 1;
//		}
		
		
	}
	
//	private synchronized void sync(){
//		long currentTime = System.currentTimeMillis();
//		
//		long timeDifference = currentTime - lastOperationTime;
//		
//		double newX;
//		double newY;
//		
//		double newOrientation;
//		
//		// Special case when steering is 0
//		if(rotation == 0){			
//			newX = lastLocation.x + speed * Math.cos(lastOrientation + (Math.PI/2));
//			newY = lastLocation.y + speed * Math.sin(lastOrientation + (Math.PI/2));
//			
//			newOrientation = lastOrientation;
//
//		}else{
//			// First compute radius of the driving circle (caused by steering)
//			double radius = VEHICLE_LENGTH/Math.sin(rotation * MAX_STEERING_ROTATION);
//			double circumference = 2.0 * Math.PI * radius;
//			double distance = speed * (double)timeDifference;
//			double angle = (distance/circumference) * 2.0 * Math.PI;
//			
//			// With a speed of one the car should drive a complete circle in 5 seconds
//			//double angle = speed * timeDifference * (2.0 * Math.PI / 10000.0);
//			
//			
//			double circleCentreX = lastLocation.x - radius * Math.cos(lastOrientation);
//			double circleCentreY = lastLocation.y - radius * Math.sin(lastOrientation);
//			
//			
//			newX = circleCentreX + (radius * Math.cos(lastOrientation + angle));
//			newY = circleCentreY + (radius * Math.sin(lastOrientation + angle));
//			
//			newOrientation = (lastOrientation + angle) % (2 * Math.PI);
//			
//			
//		}
//		
//		// Compute new location		
//		
//		lastLocation.x = newX;
//		lastLocation.y = newY;
//		lastOrientation = newOrientation;
//		
//		
//	}

	@Override
	public VehicleState getState() {
		sync();
		
		return new VehicleState(lastLocation.x, lastLocation.y, velocity.x, velocity.y);
	}

	@Override
	public String getUID() {
		return uid;
	}
	
}