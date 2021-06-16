package com.albionbrown.rawge;

import java.util.HashMap;
import java.util.Set;

import com.albionbrown.rawge.gfx.Sprite;

public class SpriteManager {

	Renderer renderer;
	HashMap<String, Sprite> sprites;
	
	public SpriteManager(Renderer renderer)
	{
		this.sprites = new HashMap<String, Sprite>();
		this.renderer = renderer;
	}
	
	public SpriteManager getSpriteManager()
	{
		return this;
	}
	
	public void addSprite(Sprite sprite)
	{
		this.sprites.put(sprite.getId(), sprite);
	}
	
	public void removeSprite(String id)
	{
		this.sprites.remove(id);
	}
	
	public void renderAllSprites()
	{
		Set<String> spriteKeys = this.sprites.keySet();
		
		for (String id: spriteKeys) {
			Sprite sprite = this.sprites.get(id);
			this.renderSprite(sprite);
		}
	}
	
	public void renderSprite(Sprite sprite)
	{
		if (sprite.isRender()) {
			sprite.render(renderer);
		}
//		this.renderer.drawImage(sprite.getImage(), sprite.getX(), sprite.getY());
	}
	
	public void updateAllSprites()
	{
		Set<String> spriteKeys = this.sprites.keySet();
		
		for (String id: spriteKeys) {
			Sprite sprite = this.sprites.get(id);
			sprite.update();
		}
	}
}
