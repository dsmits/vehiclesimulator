package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.VehicleEnvironment;

public class VehicleEnvironmentTest {
	
	VehicleEnvironment environment;

	@Before
	public void setUp() throws Exception {
		environment = new VehicleEnvironment();
	}

	@Test
	public void testVehicleIsAdded() {
		
		int sizeBefore = environment.getStates().size();
		
		environment.addVehicle("CAR");
		
		int sizeAfter = environment.getStates().size();
		int difference = sizeAfter - sizeBefore;
		
		assertNotEquals("After adding vehicle, states should not be empty.", 0, sizeAfter);
		assertEquals("After adding vehicle, there should be one vehicle more.", 1, difference);
		
	}

}
