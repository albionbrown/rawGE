package com.albionbrown.rawge.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Image {

	private int w, h;
	private int[] p;
	BufferedImage image;
	
	public Image(String path)
	{
		loadImageResource(getClass().getResourceAsStream(path));
		initialiseImage();
	}
	
	public Image(InputStream path)
	{
		loadImageResource(path);
		initialiseImage();
	}
	
	private void loadImageResource(InputStream path)
	{
		try {
			image = ImageIO.read(path);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initialiseImage()
	{
		w = image.getWidth();
		h = image.getHeight();
		// Reads all the pixel data into a 1D array
		p = image.getRGB(0, 0, w, h, null, 0, w);
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int[] getP() {
		return p;
	}

	public void setP(int[] p) {
		this.p = p;
	}
}
