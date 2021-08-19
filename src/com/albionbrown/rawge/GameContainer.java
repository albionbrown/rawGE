package com.albionbrown.rawge;

import java.awt.event.MouseEvent;

import com.albionbrown.rawge.gfx.*;
import com.albionbrown.rawge.frame.*;

// Tutorial from https://www.youtube.com/watch?v=4iPEjFUZNsw&list=PL7dwpoQd3a8j6C9p5LqHzYFSkii6iWPZF

// runnable means it can be run as a thread
public class GameContainer implements Runnable
{

	private Thread   thread;
	private Window   window;
	private Renderer renderer;
	private Input    input;
//	private SpriteManager spriteManager;
	private FrameData frameData;
	
	private boolean running = false;
	private final double UPDATE_CAP = 1.0/144.0;
	
	private int width = 320, height = 240;
	private float scale = 4f;
	private String title = "Version 1.0";
	
	private Controller gameController;
	
	public GameContainer()
	{

	}
	
	public GameContainer(String gameTitle, int width, int height, Controller gameController)
	{
		this.title = gameTitle;
		this.width = width;
		this.height = height;
		this.gameController = gameController;
	}
	
	public void initialise()
	{
		window = new Window(this);
		renderer = new Renderer(this);
		input = new Input(this);
//		spriteManager = new SpriteManager(renderer);
		frameData = new FrameData();
	}
	
	public void start()
	{	
		thread = new Thread(this);
		// .run is the main thread, .start() makes a side-thread
		thread.run();
	}
	
	public void stop()
	{
		
		
	}
	
	public void run()
	{
		
		this.running = true;
		
		boolean render = false;
		
		double firstTime = 0.0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double passedTime = 0;
		double unprocessedTime = 0;
		
		double frameTime = 0;
		
		// How many fames have passed
		int frames = 0;
		
		// How many frames per second
		int FPS = 0;
		
		while (this.running) {
			
			render = false;
			
			firstTime = System.nanoTime() / 1000000000.0;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;
			
			unprocessedTime += passedTime;
			frameTime += passedTime;
			
			/* Tutorial says this code is needed for when the FPS drops 
			 * unexpectedly, we still want the unrendered changes in
			 * that time to still take effect.
			 */
			while (unprocessedTime >= UPDATE_CAP) {
				
				unprocessedTime -= UPDATE_CAP;

				// Only render the screen if there's been an update
				render = true;
				
				// Sets the previous frame's data
				FrameData.shift();
				
				this.gameController.update(this);
				
				// Get the current input
				this.input.update();
				// Make all changes to sprites
//				this.spriteManager.updateAllSprites();
				
				if (frameTime >= 1.0) {
					
					frameTime = 0;
					FPS = frames;
					frames = 0;
					System.out.println("FPS: " + FPS);
				}
			}
			
			if (render) {
				renderer.clear();
				
				this.gameController.render(this.renderer);
//				spriteManager.renderAllSprites();
				// Render
				window.update();
				frames++;
			}
			else {
				try {
					Thread.sleep(1);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		this.dispose();
	}
	
	public void dispose()
	{
		
	}
	
	/**
	 * The programme entry point
	 * @param args
	 */
	public static void main(String args[])
	{
		GameContainer gc = new GameContainer();
		gc.initialise();
		Image image = new Image(GameContainer.getSystemPath() + "\\assets\\img\\rawGE_test.png");
//		Sprite sprite = new Sprite("ID1", image, 380, 287, 0, 0);
//		gc.spriteManager.addSprite(sprite);
		gc.start();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Window getWindow() {
		return window;
	}

//	public SpriteManager getSpriteManager() {
//		return spriteManager;
//	}


	public FrameData getFrameData() {
		return frameData;
	}

	public static String getSystemPath() {
		return System.getProperty("user.dir");
	}

	public Input getInput() {
		return input;
	}

	public Renderer getRenderer() {
		return renderer;
	}
}
