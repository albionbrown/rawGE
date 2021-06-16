package com.albionbrown.rawge.tests.image;

import com.albionbrown.rawge.Controller;
import com.albionbrown.rawge.GameContainer;
import com.albionbrown.rawge.Input;
import com.albionbrown.rawge.Renderer;
import com.albionbrown.rawge.gfx.Image;

public class ImageTest implements Controller {

	public Picture imageSprite;
	
	public static void main(String args[])
	{
		ImageTest imageTest = new ImageTest();
		GameContainer gc = new GameContainer("image Test", 320, 240, imageTest);
		gc.initialise();
		Image image = new Image("/test_img/rawGE_test.png");
//		Image image = new com.albionbrown.rawge.gfx.Image(GameContainer.getSystemPath() + "\\assets\\test_img\\rawGE_test.png");
		
		Input input = gc.getInput();
		imageTest.imageSprite = new Picture("ID1", image, 380, 287, 0, 0, input);
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
		r.drawImage(this.imageSprite.getImage(), 0, 0);
	}
}
