package com.albionbrown.rawge.tests.text;

import com.albionbrown.rawge.Controller;
import com.albionbrown.rawge.GameContainer;
import com.albionbrown.rawge.Renderer;
import com.albionbrown.rawge.gfx.DialogBox;
import com.albionbrown.rawge.gfx.Image;

public class DialogBoxTest implements Controller {
	
	public DialogBox dialogBox;
	public DialogBox dialogBox2;
	public Image image;
	private Image background;

	public DialogBoxTest()
	{
		dialogBox = new DialogBox(DialogBox.Mode.SOLID);	
		dialogBox2 = new DialogBox(DialogBox.Mode.FADE);	
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
		r.drawImage(this.background, 10, 10);
		dialogBox.render(r);
		dialogBox2.render(r);
	}
	
	public void init()
	{
		
		background = new Image("/test_img/rawGE_test.png");
		image = new Image(getClass().getResourceAsStream("/test_img/font_test.png"));
		
		dialogBox.setFontImage(image);
		dialogBox.setNumberOfCharacters(59);
		dialogBox.readImageCharacters();
		dialogBox.setRender(true);
		dialogBox.setX(110);
		dialogBox.setY(230);
		dialogBox.setWidth(100);
		dialogBox.setHeight(6);
		dialogBox.setText("This is a solid dialog box!");
		dialogBox.setBackgroundColour(0x000);
		
		dialogBox2.setFontImage(image);
		dialogBox2.setNumberOfCharacters(59);
		dialogBox2.readImageCharacters();
		dialogBox2.setRender(true);
		dialogBox2.setX(110);
		dialogBox2.setY(220);
		dialogBox2.setWidth(100);
		dialogBox2.setHeight(6);
		dialogBox2.setText("This is a faded dialog box!");
		dialogBox2.setBackgroundOpacity(100);
	}
}
