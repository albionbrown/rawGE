package com.albionbrown.rawge.tests.image;

import com.albionbrown.rawge.Controller;
import com.albionbrown.rawge.GameContainer;
import com.albionbrown.rawge.Input;
import com.albionbrown.rawge.Renderer;
import com.albionbrown.rawge.gfx.Image;

public class ImageTest implements Controller {

	public Picture imageSprite;
	public Picture imageSprite2;
	public static Input input;
	
	public static void main(String args[])
	{
		ImageTest imageTest = new ImageTest();
		GameContainer gc = new GameContainer("image Test", 320, 240, imageTest);
		gc.initialise();
		Image image = new Image("/test_img/rawGE_test.png");

//		Image image = new com.albionbrown.rawge.gfx.Image(GameContainer.getSystemPath() + "\\assets\\test_img\\rawGE_test.png");
		
		input = gc.getInput();
		imageTest.imageSprite = new Picture("ID1", image, 200, 100, 0, 0, input);
		imageTest.instanceImageLoad();
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
		r.drawImage(this.imageSprite.getImage(), imageSprite.getX(), imageSprite.getY());
		r.drawImage(this.imageSprite2.getImage(), imageSprite2.getX(), imageSprite2.getY());
	}
	
	public void instanceImageLoad()
	{
		Image image2 = new Image(getClass().getResourceAsStream("/test_img/rawGE_test2.png"));
		imageSprite2 = new Picture("ID2", image2, 200, 100, 200, 100, input);
	}
}
