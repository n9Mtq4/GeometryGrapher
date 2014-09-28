package com.n9mtq4.math.lib.render;

import com.n9mtq4.math.lib.Game;
import com.n9mtq4.math.lib.InputHandler;
import com.n9mtq4.math.lib.parts.PartManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Created by Will on 9/3/14.
 */
public class Display extends Canvas implements Runnable {
	
	public PartManager partManager;
	
	public static int DEFAULT_WIDTH = 600;
	
	private int WIDTH;
	private int HEIGHT;
	
	private Thread thread;
	private boolean running = false;
	
	private Screen2D screen;
	private Game game;
	private InputHandler inputHandler;
	
	private BufferedImage img;
	public int[] pixels;
	private int fps = 0;
	private int mx = 0;
	private int my = 0;
	private double mxa = 0;
	private double mya = 0;
	
	public Display(Dimension d) {
		
		this.WIDTH = (int) d.getWidth();
		this.HEIGHT = (int) d.getHeight();
		
		partManager = new PartManager();
//		TODO: remove
		partManager.managerAll();
		inputHandler = new InputHandler(this);
		addKeyListener(inputHandler);
		addMouseWheelListener(inputHandler);
		addMouseListener(inputHandler);
		addMouseMotionListener(inputHandler);
		
		this.setSize(new Dimension(WIDTH, HEIGHT));
		initScreen();
//		Dimension size = new Dimension(WIDTH, HEIGHT);
//		game = new Game();
		img = new BufferedImage(WIDTH , HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		
	}
	
	public void initScreen() {
		
	}
	
	public void start() {
		
		if (running) return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public void stop() {
		
		if (!running) return;
		running = false;
		System.out.println("closing");
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	public void run() {
		
		int frames = 0;
		double unprocessedSeconds = 0;
		long previousTime = System.nanoTime();
		double secondsPerTick = 1 / 60.0;
		int tickCount = 0;
		boolean ticked = false;
		
		while (running) {
			
//			game loop
			long currentTime = System.nanoTime();
			long passedTime = currentTime - previousTime;
			previousTime = currentTime;
			unprocessedSeconds += passedTime / 1000000000.0;
			
			while (unprocessedSeconds > secondsPerTick) {
				
				tick();
				unprocessedSeconds -= secondsPerTick;
				ticked = true;
				tickCount++;
				if (tickCount % 60 == 0) {
					
					System.out.println(frames + " fps");
					previousTime += 1000;
					fps = frames;
					frames = 0;
					
				}
				
			}
			
			if (ticked) {
				
			}
				render();
				frames++;
				ticked = false;
				
			}
			
			render();
			frames++;
		
	}
	
	public void tick() {
		
	}
	
	public void render() {
		
	}
	
	public static Dimension getDimension(int width) {
		return new Dimension((width / 9) * 16, width);
	}

	public static int getDEFAULT_WIDTH() {
		return DEFAULT_WIDTH;
	}

	public static void setDEFAULT_WIDTH(int DEFAULT_WIDTH) {
		Display.DEFAULT_WIDTH = DEFAULT_WIDTH;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(int WIDTH) {
		this.WIDTH = WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int HEIGHT) {
		this.HEIGHT = HEIGHT;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public Screen2D getScreen() {
		return screen;
	}

	public void setScreen(Screen2D screen) {
		this.screen = screen;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public int[] getPixels() {
		return pixels;
	}

	public void setPixels(int[] pixels) {
		this.pixels = pixels;
	}

	public int getFps() {
		return fps;
	}

	public void setFps(int fps) {
		this.fps = fps;
	}

	public PartManager getPartManager() {
		return partManager;
	}

	public void setPartManager(PartManager partManager) {
		this.partManager = partManager;
	}

	public InputHandler getInputHandler() {
		return inputHandler;
	}

	public void setInputHandler(InputHandler inputHandler) {
		this.inputHandler = inputHandler;
	}

	public int getMx() {
		return mx;
	}

	public void setMx(int mx) {
		this.mx = mx;
	}

	public int getMy() {
		return my;
	}

	public void setMy(int my) {
		this.my = my;
	}

	public double getMxa() {
		return mxa;
	}

	public void setMxa(double mxa) {
		this.mxa = mxa;
	}

	public double getMya() {
		return mya;
	}

	public void setMya(double mya) {
		this.mya = mya;
	}
}
