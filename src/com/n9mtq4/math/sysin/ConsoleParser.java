package com.n9mtq4.math.sysin;

import com.n9mtq4.math.sysin.modules.ConsoleModule;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Will on 10/19/14.
 */
public class ConsoleParser {
	
	private Console parent;
	private ArrayList<ConsoleModule> modules;
	
	public ConsoleParser(Console parent) {
		this.parent = parent;
		modules = new ArrayList<ConsoleModule>();
		initModules();
	}
	
	public void push(String text) {
		
		parent.print("[INPUT]: ", Color.BLUE);
		parent.println(text);
		for (ConsoleModule m : modules) {
			if (m.push(text)) {
				break;
			}
		}
		
	}
	
	private void initModules() {
		
//		modules.add(new Open(parent));
		
	}
	
}
