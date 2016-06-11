package main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author djura
 *
 *         Class VehicleEnvironment keeps track of the instantiated vehicles and
 *         defines the boundaries.
 */
public class VehicleEnvironment {

	public static final double DEFAULT_WIDTH = 500;
	public static final double DEFAULT_HEIGHT = 500;

	public double width;
	public double height;

	public static final String DEFAULT_VEHICLE = "ROOMBA";

	private HashMap<String, Vehicle> vehicleMap;

	private VehicleFactory vFactory;

	public VehicleEnvironment() {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);

	}

	public VehicleEnvironment(double width, double height) {
		this.width = width;
		this.height = height;

		vFactory = new VehicleFactory();
		vehicleMap = new HashMap<String, Vehicle>();

	}

	public Vehicle addVehicle(String vehicleType) {

		Vehicle newVehicle = vFactory.getVehicle(DEFAULT_VEHICLE, this);

		vehicleMap.put(newVehicle.getUID(), newVehicle);

		return newVehicle;

	}

	public Vehicle getVehicle(String uid) {
		return vehicleMap.get(uid);

	}

	public HashMap<String, VehicleState> getStates() {

		HashMap<String, VehicleState> states = new HashMap<String, VehicleState>();

		for (Vehicle vehicle : vehicleMap.values()) {
			states.put(vehicle.getUID(), vehicle.getState());
		}

		return states;

	}

}