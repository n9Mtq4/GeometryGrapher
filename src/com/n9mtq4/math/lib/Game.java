package com.n9mtq4.math.lib;

import com.n9mtq4.math.lib.render.RenderView2D;

/**
 * Created by Will on 9/3/14.
 */
public class Game {
	
	private int xoff;
	private int yoff;
	private long tick;
	private int scale;
	private RenderView2D view;
	
	public Game(RenderView2D view) {
		
		xoff = 0;
		yoff = 0;
		tick = 0;
		scale = 20;
		this.view = view;
		
	}
	
	public void tick() {
		
		if (scale <= 5) {
			scale = 5;
		}
		tick++;
		
	}

	public int getXoff() {
		return xoff;
	}

	public void setXoff(int xoff) {
		this.xoff = xoff;
	}

	public int getYoff() {
		return yoff;
	}

	public void setYoff(int yoff) {
		this.yoff = yoff;
	}

	public long getTick() {
		return tick;
	}

	public void setTick(long tick) {
		this.tick = tick;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}
}
