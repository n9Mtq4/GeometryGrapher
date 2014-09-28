package com.n9mtq4.math.lib.parts;

import java.awt.*;

/**
 * Created by Will on 9/4/14.
 */
public class LineSegment2d {
	
	private double x;
	private double y;
	private double x1;
	private double y1;
	private Color color;
	private boolean showOnGraph;
	
	public LineSegment2d(double x, double y, double x1, double y1, Color color, boolean showOnGraph) {
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.color = color;
		this.showOnGraph = showOnGraph;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isShowOnGraph() {
		return showOnGraph;
	}

	public void setShowOnGraph(boolean showOnGraph) {
		this.showOnGraph = showOnGraph;
	}
}
