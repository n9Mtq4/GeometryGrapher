package com.n9mtq4.math.lib.parts;

import java.awt.*;

/**
 * Created by Will on 9/4/14.
 */
public class Point2d {
	
	private double x;
	private double y;
	private String label;
	private Color color;
	private boolean showOnGraph;
	private boolean showLabel;
	
	public Point2d(double x, double y, String label, Color color, boolean showOnGraph, boolean showLabel) {
		this.x = x;
		this.y = y;
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
