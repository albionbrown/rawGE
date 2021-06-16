package com.albionbrown.rawge.tests.tilesprite;

import java.awt.event.KeyEvent;

import com.albionbrown.rawge.Input;
import com.albionbrown.rawge.Renderer;
import com.albionbrown.rawge.gfx.Image;
import com.albionbrown.rawge.gfx.ImageTile;
import com.albionbrown.rawge.gfx.TileSprite;

public class AnimatedSprite extends TileSprite {
	
	public AnimatedSprite(String id, Image image, int width, int height, int x, int y, Input input)
	{
		super(id, image, width, height, x, y, input);
	}
	
	public void update()
	{
		
		if (this.input.isKey(KeyEvent.VK_SPACE)) {
			this.setTileStartX(32);
			this.setTileStartY(0);
		}
		else {
			this.setTileStartX(0);
		}
//		this.x = this.input.getMouseX();
//		this.y = this.input.getMouseY();
	}
	
	public void render(Renderer r)
	{
		r.drawImageTile((ImageTile)this.getImage(), this.getX(), this.getY(), this.getTileStartX(), this.getTileStartY());
	}
}
