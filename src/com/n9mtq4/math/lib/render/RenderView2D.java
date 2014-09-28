package com.n9mtq4.math.lib.render;

import com.n9mtq4.math.lib.Game;
import com.n9mtq4.math.lib.Main;
import com.n9mtq4.math.lib.parts.LineSegment2d;
import com.n9mtq4.math.lib.parts.Point2d;

import java.awt.*;

/**
 * Created by Will on 9/4/14.
 */
public class RenderView2D extends Render {
	
	private int height;
	private int width;
	public int centerx;
	public int centery;
	
	public RenderView2D(int width, int height) {
		super(height, width);
		this.height = height;
		this.width = width;
		this.centerx = (width) / 2;
		this.centery = (height) / 2;
	}
	
	public void clear() {
		
		for (int i = 0; i < (width * height); i++) {
			
			pixels[i] = RenderView3D.convertColor(new Color(255, 255, 255));
			
		}
		
	}
	
	public void coordplane(Graphics graphics, Game game) {
		
		if (graphics == null) return;
		
		Color b = graphics.getColor();
		graphics.setColor(new Color(0, 0, 0));
		
//		y
		graphics.drawLine(centerx, centery, centerx, 0);
		graphics.drawLine(centerx, centery, centerx, height);
//		x
		graphics.drawLine(centerx, centery, width, centery);
		graphics.drawLine(centerx, centery, 0, centery);
		
//		markers for x
		for (int x = -centerx + 1; x < (width / 2) + ((width / 2) - centerx); x++) {
//			every pixel on x axis
			
			if (x % game.getScale() == 0) {
//				if multiple of game.getScale()
				
				int x1 = centerx + x;
				
//				backup
				Font bf = graphics.getFont();
				Color bc = graphics.getColor();
				
				graphics.setColor(new Color(0, 0, 0));
				graphics.setFont(new Font("Verdana", Font.BOLD, 8));
//				draw a line
				graphics.drawLine(x1, centery - 8, x1, centery + 8);
//				draw number
				int num = x / game.getScale();
				graphics.drawString(String.valueOf(num), x1 - 4, centery + 22);
				
//				restore
				graphics.setFont(bf);
				graphics.setColor(bc);
				
			}
			
		}
		
//		markers for y
//		x < (width / 2) + ((width / 2) - centerx)
		for (int y = -((width / 2) + ((width / 2) - centery)) + 1; y < centery; y++) {
//			every pixel on y axis
			
			if (y % game.getScale() == 0) {
//				if multiple of game.getScale()
				
				int y1 = centery - y;
				
//				backup
				Font bf = graphics.getFont();
				Color bc = graphics.getColor();
				
				graphics.setColor(new Color(0, 0, 0));
				graphics.setFont(new Font("Verdana", Font.BOLD, 8));
//				draw a line
				graphics.drawLine(centerx - 8, y1, centerx + 8, y1);
//				draw number
				int num = y / game.getScale();
				graphics.drawString(String.valueOf(num), centerx + 10, y1);
				
//				restore
				graphics.setFont(bf);
				graphics.setColor(bc);
				
			}
			
		}
		graphics.setColor(b);
		
	}
	
	public void points(Graphics g, Game game) {
		
		for (Point2d p : Main.getWindow().getDisplay().partManager.point2d) {
			
			if (p.isShowOnGraph()) {
				String l = p.isShowLabel() ? p.getLabel() : "";
				putPoint(g, game, p.getX(), p.getY(), p.getColor(), l);
			}
			
		}
		
	}
	
	public void arcs(Graphics g, Game game) {
		
		
		
	}
	
	public void lines(Graphics g, Game game) {
		
		for (LineSegment2d l : Main.getWindow().getDisplay().partManager.lineSegment2d) {
			
			if (l.isShowOnGraph()) {
				putLineSegment(g, game, l.getX(), l.getY(), l.getX1(), l.getY1(), l.getColor());
			}
			
		}
		
	}
	
	public void putArc(Graphics g, Game game, double x, double y, double distance, int angle1, int angle2, Color color) {
		
		Color bc = g.getColor();
		g.setColor(color);
		
		int x1 = (int) (centerx + (x * game.getScale()));
		int y1 = (int) (centery - (y * game.getScale()));
		int distance1 = (int) (distance * game.getScale());
		
		g.drawArc(x1, y1, distance1, distance1, angle1, angle2);
		g.setColor(bc);
		
	}
	
	public void putLineSegment(Graphics g, Game game, double x, double y, double x1, double y1, Color color) {
		
		int x2 = (int) (x * game.getScale());
		int y2 = (int) (y * game.getScale());
		int x3 = (int) (x1 * game.getScale());
		int y3 = (int) (y1 * game.getScale());
		
		Color bc = g.getColor();
		g.setColor(color);
		
		g.drawLine(centerx + x2, centery - y2, centerx + x3, centery - y3);
		
		g.setColor(bc);
		
	}
	
	public void putPoint(Graphics g, Game game, double x, double y, Color color, String label) {
		
//		convert double into specific x,y using game.getScale();
//		use previous code to render 5x5 square
		
		int x1 = (int) (x * game.getScale());
		int y1 = (int) (y * game.getScale());
		
//		1x1 is too small, put pixels in 5x5
		for (int y2 = y1 -  2; y2 <= y1 + 2; y2++) {
			for (int x2 = x1 - 2; x2 <= x1 + 2; x2++) {
				int x3 = centerx + x2;
				int y3 = centery - y2;
				if ((x3 > 0 && x3 < width) && (y3 > 0 && y3 < height)) {
					putpixel(x3, y3, convertColor(color));
				}
				
			}
		}
		
		Font bf = g.getFont();
		Color bc = g.getColor();
		
		g.setFont(new Font("Verdana", Font.BOLD, 12));
		g.setColor(color);
		
		g.drawString(label, (centerx + x1) + 8, (centery - y1) - 8);
		
		g.setFont(bf);
		g.setColor(bc);
		
	}
	
	public void putpixel(int x, int y, int color) {
		
		try {
			pixels[x + y * width] = color;
		}catch (ArrayIndexOutOfBoundsException e) {
		}
		
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
