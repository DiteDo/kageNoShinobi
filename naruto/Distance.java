package com.ditedo.kagenoshinobi.naruto;

public class Distance {
	/** Calculate distance between two points with positive's coordinates */
	public static double calc(Position a, Position b) {
		double ax = a.getX();
		double ay = a.getY();
		double bx = b.getX();
		double by = b.getY();
		return (ax - bx) * (ax - bx) + (ay - by) * (ay - by);
	}
}