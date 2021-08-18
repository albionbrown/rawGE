package com.albionbrown.rawge.gfx;

import java.util.HashSet;

public abstract class InteractableSprite extends Sprite implements Interactable {

	private HashSet<Interactable> interactables;
	
	public HashSet<Interactable> getInteractables()
	{
		return this.interactables;
	}
	
	public void addInteractable(Interactable interactable)
	{
		this.interactables.add(interactable);
	}
	
	public boolean isTouching(Sprite sprite)
	{

		if ((this.getX() <= sprite.getX()) 
				&& (sprite.getX() <= (this.getX() + this.getWidth()))) {
			// Top left
			if ((this.getY() <= sprite.getY()) 
					&& (sprite.getY() <= (this.getY() + this.getHeight()))) {
				return true;
			}
			// Bottom left
			else if ((this.getY() <= (sprite.getY() + sprite.getHeight())) 
					&& ((sprite.getY() + sprite.getHeight()) <= (this.getY() + this.getHeight()))) {
				return true;
			}
		}

		else if (((sprite.getX() + sprite.getWidth()) >= this.getX()) 
				&& ((this.getX() + this.getWidth()) >= (sprite.getX() + sprite.getWidth()))) {
			// Bottom right
			if ((this.getY() <= sprite.getY()) 
					&& (sprite.getY() <= (this.getY() + this.getHeight()))) {
				return true;
			}
			// Top right
			else if ((this.getY() <= (sprite.getY() + sprite.getHeight())) 
					&& ((sprite.getY() + sprite.getHeight()) <= (this.getY() + this.getHeight()))) {
				return true;
			}
		}
		return false;
	}
}
