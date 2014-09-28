package com.n9mtq4.math.lib.parts.manager;

import com.n9mtq4.math.lib.parts.PartManager;
import com.n9mtq4.math.lib.parts.Point2d;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Will on 9/11/14.
 */
public class EditPoint2d {
	
	private PartManager parent;
	private Point2d point;
	private JFrame frame;
	private JTextField[] fields;
	
	public EditPoint2d(PartManager partManager, Point2d point) {
		this.parent = partManager;
		this.point = point;
		gui();
	}
	
	public void gui() {
		
		frame = new JFrame("Edit point");
		fields = new JTextField[6];
		JPanel panel = new JPanel(new GridLayout(7, 1));
		JScrollPane scroll = new JScrollPane(panel);
		JButton ok = new JButton("Edit");
		JButton delete = new JButton("Delete");
		JPanel[] panels = new JPanel[2];
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		
		fields[0] = new JTextField(String.valueOf(point.getX())); //x
		fields[1] = new JTextField(String.valueOf(point.getY())); //y
		fields[2] = new JTextField(point.getLabel()); //label
		fields[3] = new JTextField(String.valueOf(point.getColor().getRed())); //r
		fields[4] = new JTextField(String.valueOf(point.getColor().getGreen())); //g
		fields[5] = new JTextField(String.valueOf(point.getColor().getBlue())); //b
		
		panel.add(new JLabel("Label"));
		panel.add(fields[2]);
		panel.add(new JLabel("X, Y"));
		panels[0] = new JPanel(new GridLayout(1, 2));
		panels[0].add(fields[0]);
		panels[0].add(fields[1]);
		panel.add(panels[0]);
		panel.add(new JLabel("R, G, B"));
		panels[1] = new JPanel(new GridLayout(1, 3));
		panels[1].add(fields[3]);
		panels[1].add(fields[4]);
		panels[1].add(fields[5]);
		panel.add(panels[1]);
		
		buttonPanel.add(delete);
		buttonPanel.add(ok);
		panel.add(buttonPanel);
		
		frame.add(scroll);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setSize(300, 240);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				onButtonPress(actionEvent);
			}
		});
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				onButtonPress(actionEvent);
			}
		});
		
	}
	
	public void onButtonPress(ActionEvent e) {
		
		String text = ((JButton) e.getSource()).getText();
		if (text.equalsIgnoreCase("edit")) {
			try {
				
				double x = Double.parseDouble(fields[0].getText());
				double y = Double.parseDouble(fields[1].getText());
				String label = fields[2].getText();
				int r = Integer.parseInt(fields[3].getText());
				int g = Integer.parseInt(fields[4].getText());
				int b = Integer.parseInt(fields[5].getText());
				
				point.setX(x);
				point.setY(y);
				point.setLabel(label);
				point.setColor(new Color(r, g, b));
				
			}catch (NumberFormatException e1) {
				System.out.println("error");
			}
		}else if (text.equalsIgnoreCase("delete")) {
			parent.point2d.remove(point);
		}
		
	}
	
}
