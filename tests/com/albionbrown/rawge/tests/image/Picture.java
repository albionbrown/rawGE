package com.albionbrown.rawge.tests.image;

import com.albionbrown.rawge.Input;
import com.albionbrown.rawge.Renderer;
import com.albionbrown.rawge.gfx.Image;
import com.albionbrown.rawge.gfx.Sprite;

public class Picture extends Sprite {

	public Picture (String id, Image image, int width, int height, int x, int y, Input input)
	{
		this.id = id;
		this.image = image;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public void update()
	{
		this.x = this.getInput().getMouseX();
		this.y = this.getInput().getMouseY();
	}
	
	public void render(Renderer r)
	{
		r.drawImage(this.getImage(), this.getX(), this.getY());
	}
}
