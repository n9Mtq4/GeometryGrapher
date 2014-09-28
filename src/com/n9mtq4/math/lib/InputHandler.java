package com.n9mtq4.math.lib;

import com.n9mtq4.math.lib.parts.Point2d;
import com.n9mtq4.math.lib.render.Display;

import java.awt.event.*;

/**
 * Created by Will on 9/10/14.
 */
public class InputHandler implements KeyListener, MouseWheelListener, MouseListener, MouseMotionListener {
	
	private Display display;
	public int mouseX;
	public int mouseY;
	public boolean drag;
	
	public InputHandler(Display parent) {
		
		this.display = parent;
		this.drag = false;
		
	}
	
	@Override
	public void keyTyped(KeyEvent keyEvent) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent keyEvent) {
		
		int code = keyEvent.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			display.getScreen().getView().centery += 10;
		}else if (code == KeyEvent.VK_DOWN) {
			display.getScreen().getView().centery -= 10;
		}else if (code == KeyEvent.VK_LEFT) {
			display.getScreen().getView().centerx += 10;
		}else if (code == KeyEvent.VK_RIGHT) {
			display.getScreen().getView().centerx -= 10;
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent keyEvent) {
		
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
		
		int move = mouseWheelEvent.getWheelRotation();
		
		display.getGame().setScale(display.getGame().getScale() - move);
		
	}

	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		
		if (mouseEvent.isPopupTrigger()) {
//			right click
			Point2d point2d = null;
			boolean onPoint = false;
			for (Point2d p : display.partManager.point2d) {
				double x = p.getX();
				double y = p.getY();
				int x1 = (int) (display.getScreen().getView().centerx + (x * display.getGame().getScale()));
				int y1 = (int) (display.getScreen().getView().centery - (y * display.getGame().getScale()));
				for (int y2 = y1 - 2; y2 <= y1 + 2; y2++) {
					for (int x2 = x1 - 2; x2 <= x1 + 2; x2++) {
						if (mouseEvent.getX() == x2 && mouseEvent.getY() == y2) {
							onPoint = true;
						}
					}
				}
				if (onPoint) {
					
					System.out.println(p.getLabel());
					display.partManager.editPoint2d(p);
					break;
				}
				
			}
			
			if (!onPoint) {
				
				double x = ((double) (mouseEvent.getX() - display.getScreen().getView().centerx)) / display.getGame().getScale();
				double y = (-((double) (mouseEvent.getY() - display.getScreen().getView().centery))) / display.getGame().getScale();
				
				System.out.println(Math.floor(x * 100) / 100 + ", " + Math.floor(y * 100) / 100);
				display.partManager.newPoint2d(String.valueOf(Math.floor(x * 100) / 100), String.valueOf(Math.floor(y * 100) / 100));
				
			}
			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {
//		drag = false;
	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseExited(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseDragged(MouseEvent mouseEvent) {
		
	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent) {
		
		double x = ((double) (mouseEvent.getX() - display.getScreen().getView().centerx)) / display.getGame().getScale();
		double y = (-((double) (mouseEvent.getY() - display.getScreen().getView().centery))) / display.getGame().getScale();
		display.setMx(mouseEvent.getX());
		display.setMy(mouseEvent.getY());
		display.setMxa(x);
		display.setMya(y);
		
	}
	
}
