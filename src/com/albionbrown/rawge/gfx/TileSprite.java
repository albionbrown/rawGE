package com.albionbrown.rawge.gfx;

import com.albionbrown.rawge.Input;

public abstract class TileSprite extends Sprite {
	
	private int tileStartX, tileStartY;
	
	public TileSprite()
	{
		super();
		
		tileStartX = 0;
		tileStartY = 0;
	}
	
	public TileSprite(String id, Image image, int width, int height, int x, int y, Input input)
	{
		super();
		
		this.id = id;
		this.image = image;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.input = input;
	}

	protected int getTileStartX() {
		return tileStartX;
	}

	protected void setTileStartX(int tileStartX) {
		this.tileStartX = tileStartX;
	}

	protected int getTileStartY() {
		return tileStartY;
	}

	protected void setTileStartY(int tileStartY) {
		this.tileStartY = tileStartY;
	}
}
