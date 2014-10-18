package com.n9mtq4.math.lib.render;

import com.n9mtq4.math.lib.Game;

import java.awt.*;

/**
 * Created by Will on 9/4/14.
 */
public class Screen2D extends Screen {
	
	private RenderView2D view;
	
	public Screen2D(int width, int height) {
		super(width, height);
		
		view = new RenderView2D(width, height);
		
	}
	
	@Override
	public void render(Graphics g, Game game) {
		
		for (int i = 0; i < width * height; i++) {
			pixels[i] = RenderView2D.convertColor(255, 255, 255);
		}
		
		try {
			view.clear();
			view.coordplane(g, game);
			view.lines(g, game);
			view.points(g, game);
			view.vectors(g, game);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		draw(view, 0, 0);
		
	}

	public RenderView2D getView() {
		return view;
	}
}
