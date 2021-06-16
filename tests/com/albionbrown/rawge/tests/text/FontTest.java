package com.albionbrown.rawge.tests.text;

import com.albionbrown.rawge.Controller;
import com.albionbrown.rawge.GameContainer;
import com.albionbrown.rawge.Renderer;
import com.albionbrown.rawge.gfx.Font;

public class FontTest implements Controller {
	
	private Font font;
	
	public FontTest()
	{
		font = new Font("/test_img/font_test.png");
	}

	public static void main(String[] args)
	{
		FontTest fontTest = new FontTest();
		GameContainer gc = new GameContainer("image Test", 320, 240, fontTest);
		gc.initialise();
		gc.start();
	}
	
	@Override
	public void update(GameContainer gc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Renderer r) {
		// TODO Auto-generated method stub
		r.drawText("Success!", font, 0, 0, 0xffffffff);
	}
}
