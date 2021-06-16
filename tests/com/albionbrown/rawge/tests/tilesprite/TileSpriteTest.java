package com.albionbrown.rawge.tests.tilesprite;

import com.albionbrown.rawge.Controller;
import com.albionbrown.rawge.GameContainer;
import com.albionbrown.rawge.Input;
import com.albionbrown.rawge.Renderer;
import com.albionbrown.rawge.gfx.ImageTile;

public class TileSpriteTest implements Controller {
	
	public AnimatedSprite imageSprite;

	public static void main(String[] args)
	{
		TileSpriteTest tileSpriteTest = new TileSpriteTest();
		GameContainer gc = new GameContainer("TileSprite Test", 320, 240, tileSpriteTest);
		gc.initialise();
		ImageTile image = new ImageTile("/test_img/TileSpriteTest.png", 32, 32);
		
		Input input = gc.getInput();
		tileSpriteTest.imageSprite = new AnimatedSprite("ID1", image, 416, 256, 0, 0, input);
//		gc.getSpriteManager().addSprite(imageSprite);
		gc.start();
	}

	@Override
	public void update(GameContainer gc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Renderer r) {
		// TODO Auto-generated method stub
		r.drawImageTile((ImageTile)this.imageSprite.getImage(), 0, 0, 0, 0);
	}
}

