package com.n9mtq4.math.lib.render;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Will on 9/3/14.
 */
public class Display3D extends Display implements Runnable {
	
	public Display3D(Dimension d) {
		super(d);
	}
	
	@Override
	public void initScreen() {
		
//		setScreen(new Screen3D(getWIDTH(), getHEIGHT()));
		
	}
	
	@Override
	public void tick() {
		
//		game.tick(input.getKey());
		getGame().tick();
		
	}
	
	@Override
	public void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			
			createBufferStrategy(3);
			return;
			
		}
		
		for (int i = 0; i < getWIDTH() * getHEIGHT(); i++) {
			
			pixels[i] = getScreen().pixels[i];
			
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(getImg(), 0, 0, getHEIGHT(), getHEIGHT(), null);
		g.setColor(new Color(255, 255, 0));
		g.setFont(new Font("Verdana", Font.BOLD, 24));
		g.drawString(String.valueOf(getFps()), 0, 30);
		getScreen().render(g, getGame());
		g.dispose();
		bs.show();
		
	}
	
	public static Dimension getDimension(int width) {
		return new Dimension((width / 9) * 16, width);
	}
	
}
