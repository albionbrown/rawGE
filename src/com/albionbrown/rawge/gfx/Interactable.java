package com.albionbrown.rawge.gfx;

public interface Interactable {

	public boolean isTouching(Sprite sprite);
	
	public void contactCallback();
	
	public void noContactCallback();
}
