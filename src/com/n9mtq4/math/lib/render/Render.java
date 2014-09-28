package com.n9mtq4.math.lib.render;

/**
 * Created by Will on 9/3/14.
 */
public class Render {
	
	public final int width;
	public final int height;
	public int[] pixels;
	
	public Render(int width, int height) {
		
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
		
	}
	
	public void draw(Render render, int xOffs, int yOffs) {
		
		for (int y = 0; y < render.height; y++) {
			
			int yPix = y + yOffs;
			if ((yPix < 0) || (yPix >= height)) {
				
				continue;
				
			}
			
			for (int x = 0; x < render.width; x++) {
				
				int xPix = x + xOffs;
				if ((xPix < 0) || (xPix >= width)) {
					
					continue;
					
				}
				
				int pColor = render.pixels[x + y * render.width];
				if (pColor > 0) {
					
					pixels[xPix + yPix * width] = pColor;
					
				}
				
			}
			
		}
		
	}
	
}
