package com.albionbrown.rawge.gfx;

public class Font {
	
//	public static final Font STANDARD = new Font(GameContainer.getSystemPath() + "\\assets\\img\\font_test.png");

	private Image fontImage;
	
	private int numberOfCharacters;
	
	private int[] offsets;
	private int[] widths;
	
	private int startCharacterColour = 0xff0000ff;
	private int endCharacterColour = 0xffffff00;
	
	public Font(String path, int numChars)
	{																
		this(new Image(path), numChars);
	}
	
	public Font(Image image, int numChars)
	{			
		fontImage = image;
		numberOfCharacters = numChars;
	}
	
	/**
	 * Default constructor
	 */
	public Font()
	{

	}
	
	/**
	 * Reads the font character widths into memory
	 */
	public void readImageCharacters()
	{
		offsets = new int[numberOfCharacters];
		widths = new int[numberOfCharacters];
		
		int unicode = 0;
		
		if (fontImage != null) {
			
			// For each pixel in the first row
			for (int i = 0; i < fontImage.getW(); i++) {
				
				// If the pixel is the start colour, log the character's offset in the image
				if (fontImage.getP()[i] == startCharacterColour) {
					offsets[unicode] = i;
					continue;
				}
				
				// If the character is the end colour, log the character's width
				if (fontImage.getP()[i] == endCharacterColour) {
					widths[unicode] = i - offsets[unicode];
					unicode++;
				}
			}
		}
	}

	public Image getFontImage() {
		return fontImage;
	}

	public void setFontImage(Image fontImage) {
		this.fontImage = fontImage;
	}

	public int[] getOffsets() {
		return offsets;
	}

	public void setOffsets(int[] offsets) {
		this.offsets = offsets;
	}

	public int[] getWidths() {
		return widths;
	}

	public void setWidths(int[] widths) {
		this.widths = widths;
	}

	public int getNumberOfCharacters() {
		return numberOfCharacters;
	}

	public void setNumberOfCharacters(int numberOfCharacters) {
		this.numberOfCharacters = numberOfCharacters;
	}

	public int getStartCharacterColour() {
		return startCharacterColour;
	}

	public void setStartCharacterColour(int startCharacterColour) {
		this.startCharacterColour = startCharacterColour;
	}

	public int getEndCharacterColour() {
		return endCharacterColour;
	}

	public void setEndCharacterColour(int endCharacterColour) {
		this.endCharacterColour = endCharacterColour;
	}
}
