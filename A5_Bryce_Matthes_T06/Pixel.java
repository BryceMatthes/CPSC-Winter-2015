
/**
 * Pixel class is the basic object of the program.
 * each pixel object holds RGB values for a single pixel of
 * a PPM image. 
 *
 * ID:10147880
 * @author(s) Bryce Matthes, Majid Ghaderi
 * @date Aril 10 2015
 * @version	1.0
 */

public class Pixel{
	
	int red = 0;
	int blue = 0;
	int green = 0;
	
	/*
	* default contructor for pixel that will set its color to white
	*
	*/
	public Pixel(){
		red = 255;
		blue = 255;
		green = 255;
	}
	/*
	* contructor for pixel that will set its color
	* @param(s): redIn, bleIn, greenIn are the RGB values of the pixel
	*
	*/
	public Pixel(int redIn, int blueIn, int greenIn){
		red = redIn;
		blue = blueIn;
		green = greenIn;
	}

	public Pixel(Pixel pixValue){
		red = pixValue.getRed();
		blue = pixValue.getBlue();
		green = pixValue.getGreen();
	}
	/*
	* to return the red value
	* @return returns the value of the red part of RGB
	*
	*/
	public int getRed(){
		return red;
	}
	/*
	* to return the blue value
	* @return returns the value of the blue part of RGB
	*
	*/
	public int getBlue(){
		return blue;
	}
	/*
	* to return the green value
	* @return returns the value of the green part of RGB
	*
	*/
	public int getGreen(){
		return green;
	}
	/*
	* to set the red value
	* @param value to change the red in RGB to
	*
	*/
	public void setRed(int redVal){
		red = redVal;
	}
	/*
	* to set the blue value
	* @param value to change the blue in RGB to
	*
	*/
	public void setBlue(int blueVal){
		blue = blueVal;
	}
	/*
	* to set the green value
	* @param value to change the green in RGB to
	*
	*/
	public void setGreen(int greenVal){
		green = greenVal;
	}
	/*
	* used to copy one Pixel object pixValue to another
	* @param a pixel to be copied
	*
	*/
	public void copyPixel(Pixel pixValue){
		red = pixValue.getRed();
		blue = pixValue.getBlue();
		green = pixValue.getGreen();
	}
}
