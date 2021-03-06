package main;

/**
 * Convenience class for storing 2d coordinates.
 *
 */
public class Vector2 {
	
	public double x;
	public double y;
	
	public Vector2(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public Vector2(){
		this(0, 0);
	}

}
