package com.n9mtq4.math.sysin;

import com.n9mtq4.math.lib.render.Display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Will on 10/19/14.
 */
public class Console {
	
	private Display parent;
	private ConsoleParser parser;
	private JFrame frame;
	private JTextArea area;
	private JTextField field;
	private JScrollPane scrollArea;
	
	public Console(Display parent) {
		
		this.parent = parent;
		if (parser == null) {
			parser = new ConsoleParser(this);
		}
		gui();
		
	}
	
	private void gui() {
		
		frame = new JFrame("Console");
		
		area = new JTextArea();
		field = new JTextField();
		scrollArea = new JScrollPane(area);
		scrollArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		frame.add(scrollArea, BorderLayout.CENTER);
		frame.add(field, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(360, 240);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		field.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				onFieldEnter(actionEvent);
			}
		});
		
	}
	
	private void onFieldEnter(ActionEvent e) {
		
		JTextField source = (JTextField) e.getSource();
		String text = source.getText();
		System.out.println(text);
		parser.push(text);
		
	}
	
	public Display getParent() {
		return parent;
	}
	
	public void setParent(Display parent) {
		this.parent = parent;
	}
	
	public ConsoleParser getParser() {
		return parser;
	}
	
	public void setParser(ConsoleParser parser) {
		this.parser = parser;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public JTextArea getArea() {
		return area;
	}
	
	public void setArea(JTextArea area) {
		this.area = area;
	}
	
	public JTextField getField() {
		return field;
	}
	
	public void setField(JTextField field) {
		this.field = field;
	}
	
	public JScrollPane getScrollArea() {
		return scrollArea;
	}
	
	public void setScrollArea(JScrollPane scrollArea) {
		this.scrollArea = scrollArea;
	}
	
}
