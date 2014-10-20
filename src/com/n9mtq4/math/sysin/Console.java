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
	private NTextArea area;
	private JTextField field;
	private JScrollPane scrollArea;
	
	public Console(Display parent) {
		
		this.parent = parent;
		parser = new ConsoleParser(this);
		gui();
		
	}
	
	private void gui() {
		
		frame = new JFrame("Console");
		
		area = new NTextArea();
		area.setUserEditable(false);
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
		
		field.requestFocus();
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
	public void println(String text) {
		
		print(text + "\n");
		
	}
	
	public void println(String text, Color color) {
		
		print(text + "\n", color);
		
	}
	
	public void print(String text) {
		
		area.append(text, Color.BLACK);
		
	}
	
	public void print(String text, Color color) {
		
		area.append(text, color);
		
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
	
	public NTextArea getArea() {
		return area;
	}
	
	public void setArea(NTextArea area) {
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
