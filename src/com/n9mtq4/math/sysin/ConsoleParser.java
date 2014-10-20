package com.n9mtq4.math.sysin;

import com.n9mtq4.math.lib.parts.Vector4d;

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
		
		if (text.contains(" ")) {
			
			String[] fields = text.split(" ");
			
			if (fields.length == 1) {
				
			}else if (fields.length == 2) {
				
				if (fields[0].equals("new")) {
					
					if (fields[1].equals("vectorBuilder")) {
//						TODO: gui for vector
					}
					
				}
				
			}else if (fields.length == 3) {
				
			}else if (fields.length == 4) {
				
			}else if (fields.length == 5) {
				
			}else if (fields.length == 9) {
				
				if (fields[0].equals("add")) {
					
					if (fields[1].equals("vector")) {
						
						try {
							
							double x1 = Double.parseDouble(fields[2]);
							double y1 = Double.parseDouble(fields[3]);
							double x2 = Double.parseDouble(fields[4]);
							double y2 = Double.parseDouble(fields[5]);
							int r = Integer.parseInt(fields[6]);
							int g = Integer.parseInt(fields[7]);
							int b = Integer.parseInt(fields[8]);
							
							parent.getParent().partManager.vector4d.add(new Vector4d(x1, y1, x2, y2, "", new Color(r, g, b), true, false));
							
						}catch (NumberFormatException e) {
							parent.print("[ERROR]: ", Color.RED);
							parent.println(e.toString());
						}
						
					}
					
				}else if (fields[0].equals("delete")) {
					
				}else if (fields[0].equals("edit")) {
					
				}
				
			}
			
		}
		
	}
	
}
