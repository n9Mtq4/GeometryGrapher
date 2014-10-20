package com.n9mtq4.math.lib.parts;

import java.awt.*;

/**
 * Created by Will on 9/18/14.
 */
public class Arc2d {
	
	private double x;
	private double y;
	private double size;
	private double angle1;
	private double angle2;
	private String label;
	private Color color;
	private boolean showOnGraph;
	private boolean showLabel;
	
	public Arc2d(double x, double y, double size, double angle1, double angle2, String label, Color color, boolean showOnGraph, boolean showLabel) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.angle1 = angle1;
		this.angle2 = angle2;
		this.label = label;
		this.color = color;
		this.showOnGraph = showOnGraph;
		this.showLabel = showLabel;
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

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getAngle1() {
		return angle1;
	}

	public void setAngle1(double angle1) {
		this.angle1 = angle1;
	}

	public double getAngle2() {
		return angle2;
	}

	public void setAngle2(double angle2) {
		this.angle2 = angle2;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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

	public boolean isShowLabel() {
		return showLabel;
	}

	public void setShowLabel(boolean showLabel) {
		this.showLabel = showLabel;
	}
}
