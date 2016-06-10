package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.VehicleImpl;
import main.Vehicle;
import main.VehicleState;

public class VehicleTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testInitialStateisAllZeros() {
		Vehicle v = new VehicleImpl();
		
		VehicleState s = v.getState();
		
		VehicleState expectedState = new VehicleState(0, 0, 0, 0, 0);
		
		assertEquals("Initial vehicle state should have all zeros.", expectedState, s);
		
	}

	@Test
	public void testCarMoves() throws InterruptedException{
		Vehicle v = new VehicleImpl();
		
		v.steer(1);
		v.setSpeed(0.001);
		
		Thread.sleep(1000);
		
		System.out.println(v.getState());
		
		Thread.sleep(1000);
		
		System.out.println(v.getState());
		
		
		
		
		
		
	}
	
	
	
}
