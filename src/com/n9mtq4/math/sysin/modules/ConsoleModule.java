package com.n9mtq4.math.sysin.modules;

import com.n9mtq4.math.sysin.Console;

/**
 * Created by Will on 10/20/14.
 */
public abstract class ConsoleModule {
	
	private Console parent;
	
	public ConsoleModule(Console parent) {
		this.parent = parent;
	}
	
	public boolean push(String text) {
		
		init(text);
		return process(text);
		
	}
	
	private void init(String text) {
		
	}
	
	public abstract boolean process(String text);
	
}
