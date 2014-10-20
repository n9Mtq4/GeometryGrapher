package com.n9mtq4.math.sysin;

import java.awt.*;
/**
 * Created by Will on 10/19/14.
 */
public class ConsoleParser {
	
	private Console parent;
	
	public ConsoleParser(Console parent) {
		this.parent = parent;
	}
	
	public void push(String text) {
		
		parent.print("[INPUT]: ", Color.BLUE);
		parent.println(text);
		
							parent.print("[ERROR]: ", Color.RED);
							parent.println(e.toString());
		
	}
	
}
