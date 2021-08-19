package com.albionbrown.rawge.gfx;

import com.albionbrown.rawge.Renderer;

public class DialogBox extends Font 
{

	private boolean render;
	private String text;
	
	private int x, y, width, height;
	
	private int backgroundColour;
	private int backgroundOpacity;
	
	public DialogBox()
	{
		this.render = false;
	}

	public boolean isRender() {
		return render;
	}

	public void setRender(boolean render) {
		this.render = render;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void render(Renderer r) {
		
		if (!this.render)
			return;
		
		// Render background for dialog
		r.drawSquare(backgroundColour, backgroundOpacity, x, y, width, height);
		
		// Render text
		r.drawText(this.text, this, this.x, this.y, 0xffffffff);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getBackgroundColour() {
		return backgroundColour;
	}

	public void setBackgroundColour(int backgroundColour) {
		this.backgroundColour = backgroundColour;
	}

	public int getBackgroundOpacity() {
		return backgroundOpacity;
	}

	public void setBackgroundOpacity(int backgroundOpacity) {
		this.backgroundOpacity = backgroundOpacity;
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
}
