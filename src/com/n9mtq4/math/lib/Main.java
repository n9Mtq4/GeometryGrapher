package com.n9mtq4.math.lib;

/**
 * Created by Will on 9/3/14.
 */
public class Main {
	
	private static ChooseWindow instance;
	private static GraphWindow window;
	
	public static void main(String[] args) {
		
		if (instance == null) {
			
			instance = new ChooseWindow();
			
		}
		
	}
	
	public static ChooseWindow getInstance() {
		return instance;
	}
	
	public static void setInstance(ChooseWindow instance) {
		Main.instance = instance;
	}
	
	public static GraphWindow getWindow() {
		return window;
	}
	
	public static void setWindow(GraphWindow window) {
		Main.window = window;
	}
	
}
