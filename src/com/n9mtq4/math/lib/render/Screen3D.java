package com.n9mtq4.math.lib.render;

import com.n9mtq4.math.lib.Game;

import java.awt.*;

/**
 * Created by Will on 9/3/14.
 */
public class Screen3D extends Screen {
	
	private RenderView3D view;
	
	public Screen3D(int width, int height) {
		
		super(width, height);
		
		view = new RenderView3D(width, height);
		
	}
	
	public void render(Graphics g, Game game) {
		
		for (int i = 0; i < (width * height); i++) {
			
			pixels[i] = RenderView3D.convertColor(new Color(255, 255, 255));
			
		}
		
		view.coordplane(g, game);
		
		draw(view, 0, 0);
		
	}
	
}
