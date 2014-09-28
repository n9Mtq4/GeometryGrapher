package com.n9mtq4.math.lib.parts.manager;

import com.n9mtq4.math.lib.TextAreaWindow;
import com.n9mtq4.math.lib.parts.PartManager;
import com.n9mtq4.math.lib.parts.Point2d;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Will on 9/10/14.
 */
public class NewPoint2d {
	
//	private JList parentList;
	private PartManager parent;
	private JFrame frame;
	private JTextField[] fields;
	private String defaultx;
	private String defaulty;
	
	public NewPoint2d(PartManager parent, boolean invokeLater) {
		
		this.parent = parent;
		this.defaultx = "";
		this.defaulty = "";
		if (!invokeLater) {
			gui();
		}
		
	}
	
	public void invoke() {
		gui();
	}
	
	public NewPoint2d(PartManager parent) {
		
//		this.parentList = parentList;
		this.parent = parent;
		this.defaultx = "";
		this.defaulty = "";
		gui();
		
	}
	
	private void gui() {
		
		frame = new JFrame("Add a point");
		fields = new JTextField[6];
		JPanel panel = new JPanel(new GridLayout(7, 1));
		JScrollPane scroll = new JScrollPane(panel);
		JButton ok = new JButton("Add");
		JPanel[] panels = new JPanel[2];
		
		fields[0] = new JTextField(defaultx); //x
		fields[1] = new JTextField(defaulty); //y
		fields[2] = new JTextField(); //label
		fields[3] = new JTextField(); //r
		fields[4] = new JTextField(); //g
		fields[5] = new JTextField(); //b
		
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
		
		panel.add(ok);
		
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
		
	}
	
	public void onButtonPress(ActionEvent e) {
		
		try {
			
			double x = Double.parseDouble(fields[0].getText());
			double y = Double.parseDouble(fields[1].getText());
			String label = fields[2].getText();
			int r = Integer.parseInt(fields[3].getText());
			int g = Integer.parseInt(fields[4].getText());
			int b = Integer.parseInt(fields[5].getText());
			
			for (Point2d p : parent.point2d) {
				if (p.getLabel().equalsIgnoreCase(label)) {
					new TextAreaWindow("Error", "A point with this label\nalready exists", null);
					return;
				}
			}
			
			parent.point2d.add(new Point2d(x, y, label, new Color(r, g, b), true, true));
			
		}catch (NumberFormatException e1) {
			System.out.println("error");
		}
		
	}

	public PartManager getParent() {
		return parent;
	}

	public void setParent(PartManager parent) {
		this.parent = parent;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField[] getFields() {
		return fields;
	}

	public void setFields(JTextField[] fields) {
		this.fields = fields;
	}

	public String getDefaultx() {
		return defaultx;
	}

	public void setDefaultx(String defaultx) {
		this.defaultx = defaultx;
	}

	public String getDefaulty() {
		return defaulty;
	}

	public void setDefaulty(String defaulty) {
		this.defaulty = defaulty;
	}
}
