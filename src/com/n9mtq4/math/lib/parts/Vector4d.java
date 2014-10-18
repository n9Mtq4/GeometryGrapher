package com.n9mtq4.math.lib.parts;

import java.awt.*;

/**
 * Created by Will on 10/17/14.
 */
public class Vector4d {
	
	private double x;
	private double y;
	private double x1;
	private double y1;
	String label;
	Color color;
	private boolean showOnGraph;
	private boolean showLabel;
	
	public Vector4d(double x, double y, double x1, double y1, String label, Color color, boolean showOnGraph, boolean showLabel) {
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
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
