package com.n9mtq4.math.lib.render;

import com.n9mtq4.math.lib.Game;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Will on 9/4/14.
 */
public class Display2D extends Display {
	
	private int newX = 0;
	private int oldX = 0;
	private int newY = 0;
	private int oldY = 0;
	
	public Display2D(Dimension d) {
		super(d);
	}
	
	@Override
	public void initScreen() {
		
		setScreen(new Screen2D(getWIDTH(), getHEIGHT()));
		setGame(new Game(getScreen().getView()));
		
	}
	
	@Override
	public void tick() {
		
/*		newX = getInputHandler().mouseX;
		newY = getInputHandler().mouseY;
		getInputHandler().mouseX = 0;
		getInputHandler().mouseX = 0;
		
		int d1 = oldX - newX;
		int d2 = oldY - newY;
		
		getScreen().getView().centerx -= d1;
		getScreen().getView().centery -= d2;
		
		oldX = newX;
		oldY = newY;*/
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
		g.drawString(getMx() + ", " + getMy(), 0, 60);
		g.drawString((Math.floor(getMxa() * 100) / 100) + ", " + (Math.floor(getMya() * 100) / 100), 0, 90);
		getScreen().render(g, getGame());
		g.dispose();
		bs.show();
		
	}
	
	public static Dimension getDimension(int width) {
		return new Dimension((width / 9) * 16, width);
	}
	
}
