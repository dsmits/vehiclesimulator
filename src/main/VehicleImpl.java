package main;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.rmi.server.UID;

/**
 * Simulated vehicle. This implementation only computes new locations when the
 * state is requested or the moving direction is updated.
 */
public class VehicleImpl implements Vehicle {

	public static final double DEFAULT_X = 10;
	public static final double DEFAULT_Y = 10;
	public static final double MAX_SPEED = 0.05;

	private String uid;

	private Vector2 velocity;

	private long lastOperationTime;

	private Vector2 lastLocation;

	private VehicleEnvironment vEnvironment;

	public VehicleImpl(VehicleEnvironment vEnvironment) {
		this(new Vector2(DEFAULT_X, DEFAULT_Y), new Vector2(), vEnvironment);

	}

	/**
	 * Instantiates a new Vehicle.
	 * 
	 * @param location
	 *            Initial location
	 * @param velocity
	 *            Initial velocity
	 * @param vEnvironment
	 *            The VehicleEnvironment this vehicle is instantiated in.
	 */
	public VehicleImpl(Vector2 location, Vector2 velocity, VehicleEnvironment vEnvironment) {
		this.velocity = velocity;
		this.lastLocation = location;

		this.vEnvironment = vEnvironment;

		lastOperationTime = System.currentTimeMillis();

		uid = new UID().toString();

		// Making a UID that is also GET request friendly
		try {
			uid = URLEncoder.encode(uid, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see main.Vehicle#steer(main.Vector2)
	 */
	@Override
	public synchronized void steer(Vector2 newVelocity) {
		sync();
		velocity = newVelocity;

	}

	/**
	 * Computes the new locations of the vehicles. Locations are exclusively
	 * updated when the state is requested or the movement is modified through
	 * steer().
	 */
	private synchronized void sync() {
		long currentTime = System.currentTimeMillis();

		long timeDifference = currentTime - lastOperationTime;

		double newLocationX = lastLocation.x + velocity.x * MAX_SPEED * timeDifference;
		double newLocationY = lastLocation.y + velocity.y * MAX_SPEED * timeDifference;

		if (newLocationX <= vEnvironment.width && newLocationX > 0) {
			lastLocation.x = newLocationX;
		}
		if (newLocationY <= vEnvironment.height && newLocationY > 0) {
			lastLocation.y = newLocationY;
		}

		lastOperationTime = currentTime;

	}

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