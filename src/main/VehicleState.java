package main;

import java.util.HashMap;

/**
 * Class VehicleState holds all information about a vehicles current state.
 *
 */
public class VehicleState {

	/**
	 * Current x location
	 */
	public double x;
	
	/**
	 * Current y location
	 */
	public double y;

	/**
	 * Current velocity on x axis
	 */
	public double velocityX;
	
	/**
	 * Current velocity on y axis
	 */
	public double velocityY;

	public VehicleState() {
		this(0, 0, 0, 0);
	}

	public VehicleState(double x, double y, double velocityX, double velocityY) {
		this.x = x;
		this.y = y;
		this.velocityX = velocityX;
		this.velocityY = velocityY;

	}

	@Override
	public boolean equals(Object o) {

		if (o.getClass() == VehicleState.class) {
			VehicleState v = (VehicleState) o;
			return v.x == x && v.y == y && v.velocityX == velocityX && v.velocityY == velocityY;

		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "VehicleState [x=" + x + ", y=" + y + ", velocityX=" + velocityX + ", velocityY=" + velocityY + "]";
	}

	public HashMap<String, String> toMap() {
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("x", String.valueOf(x));
		map.put("y", String.valueOf(y));
		map.put("velocityX", String.valueOf(velocityX));
		map.put("velocityY", String.valueOf(velocityY));

		return map;
	}

}
