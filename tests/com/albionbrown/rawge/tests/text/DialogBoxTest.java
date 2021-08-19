package com.albionbrown.rawge.tests.text;

import com.albionbrown.rawge.Controller;
import com.albionbrown.rawge.GameContainer;
import com.albionbrown.rawge.Renderer;
import com.albionbrown.rawge.gfx.DialogBox;
import com.albionbrown.rawge.gfx.Image;

public class DialogBoxTest implements Controller {
	
	public DialogBox dialogBox;
	public Image image;

	public DialogBoxTest()
	{
		dialogBox = new DialogBox();	
	}
	
	public static void main(String[] args)
	{
		DialogBoxTest dialogBoxTest = new DialogBoxTest();
		GameContainer gc = new GameContainer("image Test", 320, 240, dialogBoxTest);
		
		dialogBoxTest.init();
		
		gc.initialise();
		
		Renderer r = gc.getRenderer();
		r.setDefaultColour(0xfff);
		
		gc.start();
	}
	
	@Override
	public void update(GameContainer gc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Renderer r) {
		// TODO Auto-generated method stub
		dialogBox.render(r);
	}
	
	public void init()
	{
		image = new Image(getClass().getResourceAsStream("/test_img/font_test.png"));
		dialogBox.setFontImage(image);
		dialogBox.setNumberOfCharacters(59);
		dialogBox.readImageCharacters();
		dialogBox.setRender(true);
		dialogBox.setX(110);
		dialogBox.setY(230);
		dialogBox.setWidth(100);
		dialogBox.setHeight(6);
		dialogBox.setText("This is a dialog box!");
		dialogBox.setBackgroundColour(0x000);
		dialogBox.setBackgroundOpacity(0);
	}
}
