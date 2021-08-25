package com.albionbrown.rawge;

import java.awt.image.DataBufferInt;
import java.awt.Color;

import com.albionbrown.rawge.gfx.Font;
import com.albionbrown.rawge.gfx.Image;
import com.albionbrown.rawge.gfx.ImageTile;

public class Renderer {

	// Pixel width and pixel height
	private int pW, pH;
	// The pixels!
	private int[] p;
	private GameContainer gc;
	private int alphaColour = 0xffff00ff;
	
	private int defaultColour;
	
	public Renderer(GameContainer gc)
	{
		this.gc = gc;
		pW = gc.getWidth();
		pH = gc.getHeight();
		
		defaultColour = 0x000;
		
		// Get the pixel data that is rendered in Window.update()
		p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
	}
	
	public void clear()
	{
		for (int i = 0; i < p.length; i++) {
			p[i] = defaultColour;
		}
	}
	
	public void setPixel(int x, int y, int value)
	{
		/*
		 *  Check if the pixel is out of bounds or is a colour that
		 *  should not be rendered
		 */
		if (x < 0 || x >= pW || y < 0 || y >= pH || value == alphaColour) {
			return;
		}
		
		/*
		 *  Image pixel data is in 1D array. This is how
		 *  to set value of 2D image in 1D array
		 */
		p[x + y * pW] = value; 
	}
	
	/**
	 * Renders text using the Font class
	 * @param text The test to be rendered
	 * @param font The font class to use
	 * @param offX X coordinate
	 * @param offY Y coordinate
	 * @param colour The colour to omit rendering
	 */
	public void drawText(String text, Font font, int offX, int offY, int colour)
	{
		text = text.toUpperCase();
		int offset = 0;
		
		for (int i = 0; i < text.length(); i++) {
			
			int unicode = text.codePointAt(i) - 32;
			
			for (int y = 0; y < font.getFontImage().getH(); y++) {
				for (int x = 0; x < font.getWidths()[unicode]; x++) {
					// If the pixel is white (part of the character)
					if (font.getFontImage().getP()[(x + font.getOffsets()[unicode]) + y * font.getFontImage().getW()] == 0xffffffff) {
						setPixel(x + offX + offset, y + offY, colour);
					}
				}
			}
			
			offset += font.getWidths()[unicode];
		}
	}
	
	public void drawImage(Image image, int offX, int offY) 
	{
		if (offX < -image.getW()) return;
		if (offY < -image.getH()) return;
		
		int newX = 0;
		int newY = 0;
		int newW = image.getW();
		int newH = image.getH();
		
		if (newW + offX > pW) {
			newW -= newW + offX - pW;
		}
		
		if (newH + offY > pH) {
			newH -= newH - pW;
		}
		
		for (int y = 0; y < image.getH(); y++) {
			for (int x = 0; x < image.getW(); x++) {
				setPixel(x + offX, y + offY, image.getP()[x + y * image.getW()]);
			}
		}
	}
	
	/**
	 * 
	 * @param imageTile The whole image to be used
	 * @param offX The X coordinate for the image to be printed to the screen
	 * @param offY The Y coordinate for the image to be printed to the screen
	 * @param tileX The X coordinate inside the image to start drawing from
	 * @param tileY The Y coordinate inside the image to start drawing from
	 */
	public void drawImageTile(ImageTile imageTile, int offX, int offY, int tileX, int tileY)
	{
		
		if (offX < -imageTile.getTileW()) return;
		if (offY < -imageTile.getTileH()) return;
		
		int newX = 0;
		int newY = 0;
		int newW = imageTile.getTileW();
		int newH = imageTile.getTileH();
		
		if (newW + offX > pW) {
			newW -= newW + offX - pW;
		}
		
		if (newH + offY > pH) {
			newH -= newH - pW;
		}
		
		for (int y = 0; y < imageTile.getTileH(); y++) {
			for (int x = 0; x < imageTile.getTileW(); x++) {
				setPixel(x + offX, y + offY, 
						imageTile.getP()[(x + tileX * imageTile.getTileW()) + (y + tileY * imageTile.getTileH()) * imageTile.getW()]);
			}
		}
	}
	
	/**
	 * Draws a square
	 * @param backgroundColour
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawSquare(int backgroundColour, int offX, int offY, int width, int height) 
	{
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				
				int currentColour = p[x + y * pW];
				setPixel(x + offX, y + offY, backgroundColour);
			}
		}
	}
	
	/**
	 * Changes the darkness/brightness of a pixel's colour
	 * within a certain dimension
	 * @param backgroundOpacity
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void changeBrightnessinSquare(int change, int offX, int offY, int width, int height) 
	{
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				
				Color colour = new Color(p[x + y * pW]);
				int newColour = 0;
				
				int red = (colour.getRed() + change) >= 0 ? (colour.getRed() + change) : 0;
				int green = (colour.getGreen() + change) >= 0 ? (colour.getGreen() + change) : 0;
				int blue = (colour.getBlue() + change) >= 0 ? (colour.getBlue() + change) : 0;
				
				newColour = (newColour << 8) | red;
				newColour = (newColour << 8) | green;
				newColour = (newColour << 8) | blue;
				
				setPixel(x + offX, y + offY, newColour);
			}
		}
	}


	public int getAlphaColour() {
		return alphaColour;
	}

	public void setAlphaColour(int alphaColour) {
		this.alphaColour = alphaColour;
	}

	public int getDefaultColour() {
		return defaultColour;
	}

	public void setDefaultColour(int defaultColour) {
		this.defaultColour = defaultColour;
	}
}
