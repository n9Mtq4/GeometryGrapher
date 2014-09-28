package com.n9mtq4.math.lib.render;

import com.n9mtq4.math.lib.Game;

import java.awt.*;

/**
 * Created by Will on 9/3/14.
 */
public class RenderView3D extends Render {
	
	private int height;
	private int width;
	private int centerx;
	private int centery;
	private int lineLength;
	
	public RenderView3D(int width, int height) {
		super(height, width);
		this.height = height;
		this.width = width;
		this.centerx = (width) / 2;
		this.centery = (height) / 2;
		this.lineLength = (height - 30) / 2;
	}
	
	public void coordplane(Graphics graphics, Game game) {
		
		if (graphics == null) return;
		
		Color b = graphics.getColor();
		graphics.setColor(new Color(0, 0, 0));
		
//		y
		graphics.drawLine(centerx, centery, centerx, centery - (lineLength));
		graphics.drawLine(centerx, centery, centerx, centery + (lineLength));
//		x
		graphics.drawLine(centerx, centery, (int) ((centerx - (lineLength))), centery);
		graphics.drawLine(centerx, centery, (int) ((centerx + (lineLength))), centery);
//		z
		graphics.drawLine(centerx, centery, centerx - (lineLength - 50), centery + (lineLength - 50));
		graphics.drawLine(centerx, centery, centerx + (lineLength - 50), centery - (lineLength - 50));
		
		graphics.setColor(b);
		
	}
	
	public void putpixel(int x, int y, int color) {
		
		pixels[x + y * width] = color;
		
	}
	
	public static int convertColor(Color c) {
		
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		
		return r << 16 | g << 8 | b;
		
	}
	
	public static int convertColor(int r, int g, int b) {
		
		return r << 16 | g << 8 | b;
		
	}
	
}
