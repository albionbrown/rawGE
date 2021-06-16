package com.albionbrown.rawge.gfx;

import com.albionbrown.rawge.Input;
import com.albionbrown.rawge.Renderer;

public abstract class Sprite {

	protected String id;
	protected Image image;
	protected int width, height, x, y;
	protected Input input;
	protected boolean render = false;
	
	public Sprite(String id, Image image, int width, int height, int x, int y, Input input)
	{
		this.id = id;
		this.image = image;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public Sprite() {
		
	}

	public Sprite(Input input)
	{
		this.input = input;
	}

	public String getId() {
		return this.id;
	}
	
	protected void setId(String id) {
		this.id = id;
	}

	public Image getImage() {
		return this.image;
	}

	public int getWidth() {
		return this.width;
	}
	
	protected void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}
	
	protected void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public abstract void update();

	protected Input getInput() {
		return this.input;
	}
	
	public void setInput(Input input) {
		this.input = input;
	}
	
	public abstract void render(Renderer r);

	public boolean isRender() {
		return render;
	}

	public  void setRender(boolean render) {
		this.render = render;
	}
}
