package com.n9mtq4.math.lib.parts;

/**
 * Created by Will on 10/17/14.
 */
public class Point2db {
	
	public double x;
	public double y;
	
	public Point2db(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public static Point2db rotatePoint(Point2db around, Point2db old, double angle) {
		
		double s = Math.sin(angle);
		double c = Math.cos(angle);
		old.x -= around.x;
		old.y -= around.y;
		double xnew = old.x * c - old.y * s;
		double ynew = old.x * s + old.y * c;
		old.x = xnew + around.x;
		old.y = ynew + around.y;
		return old;
		
	}
	
}
