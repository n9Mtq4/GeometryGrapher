package com.n9mtq4.math.lib;

import com.n9mtq4.console.lib.Console;
import com.n9mtq4.math.lib.render.Display;
import com.n9mtq4.math.lib.render.Display2D;
import com.n9mtq4.math.lib.render.Display3D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Will on 9/4/14.
 */
public class ChooseWindow {
	
	private GraphWindow instance;
	
	private JFrame frame;
	private JButton d3;
	private JButton d2;
	private JPanel panel;
	
	public ChooseWindow() {
		
		Display d = new Display2D(new Dimension(Display.DEFAULT_WIDTH, Display.DEFAULT_WIDTH));
		if (instance == null) instance = new GraphWindow("2D Window", d);
		Main.setWindow(instance);
		Main.setConsole(new Console());
		Main.getConsole().getFrame().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Main.getConsole().redirectStdoutOn(true);
//		gui();
		
	}
	
	private void gui() {
		
		frame = new JFrame("Choose your window");
		
		d2 = new JButton("2D");
		d3 = new JButton("3D");
		panel = new JPanel(new GridLayout(2, 1));
		
		panel.add(d2);
		panel.add(d3);
		
		frame.add(panel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		listener(new JButton[]{d2, d3});
		
	}
	
	private void onButtonPress(ActionEvent e) {
		
		JButton source = (JButton) e.getSource();
		
		if (source.getText().equalsIgnoreCase("2d")) {
			
			Display d = new Display2D(new Dimension(Display.DEFAULT_WIDTH, Display.DEFAULT_WIDTH));
			if (instance == null) instance = new GraphWindow("2D Window", d);
			
		}else if (source.getText().equalsIgnoreCase("3d")) {
			
			Display d = new Display3D(new Dimension(Display.DEFAULT_WIDTH, Display.DEFAULT_WIDTH));
			if (instance == null) instance = new GraphWindow("3D Window", d);
//			TODO: new ControlPanel3d
			
		}else {
			
			System.out.println("Error");
			
		}
		
		Main.setWindow(instance);
		frame.dispose();
		
	}
	
	private void listener(JButton[] c) {
		
		for (JButton c1 : c) {
			
			c1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					onButtonPress(actionEvent);
				}
			});
			
		}
		
	}
	
	public GraphWindow getInstance() {
		return instance;
	}
	
}
