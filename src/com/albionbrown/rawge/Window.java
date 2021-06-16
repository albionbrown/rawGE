package com.albionbrown.rawge;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Window {
	
	private JFrame frame;
	private BufferedImage image;
	private Canvas canvas;
	private BufferStrategy bufferStrategy;
	private Graphics graphics;
	
	public Window(GameContainer gc)
	{
		
		image = new BufferedImage(gc.getWidth(), gc.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		canvas = new Canvas();
		Dimension s = new Dimension((int) (gc.getWidth() * gc.getScale()), (int) (gc.getHeight() * gc.getScale()));
		canvas.setPreferredSize(s);
		canvas.setMaximumSize(s);
		canvas.setMinimumSize(s);
		
		frame = new JFrame(gc.getTitle());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		// Make the canvas in the centre of the frame
		frame.add(canvas, BorderLayout.CENTER);
		
		// Set the size of the frame to the size of the canvas
		frame.pack();
		
		// Makes the window start in the centre of the screen
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		// Gives us 2 available buffers to render images to
		canvas.createBufferStrategy(2);
		bufferStrategy = canvas.getBufferStrategy();
		
		graphics = bufferStrategy.getDrawGraphics();
	}
	
	public void update()
	{
		// Draws to the buffer strategy
		graphics.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		
		// Draws buffer to canvas
		bufferStrategy.show();
	}

	public BufferedImage getImage() {
		return image;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getFrame() {
		return frame;
	}
}
