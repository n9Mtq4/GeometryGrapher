package com.n9mtq4.math.lib;

import com.n9mtq4.math.lib.render.Display;

import javax.swing.*;

/**
 * Created by Will on 9/3/14.
 */
public class GraphWindow {
	
	private String title;
	private Display display;
	
	public GraphWindow(String title, Display display1) {
		
		this.display = display1;
		this.title = title;
		gui();
		
	}
	
	private void gui() {
		
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(display);
		
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		display.start();
		
	}
	
	public Display getDisplay() {
		return display;
	}
	
}
