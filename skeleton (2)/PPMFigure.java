
/**
 * A class to create simple PPM images.
 *  
 * @author	Majid Ghaderi
 * @version	2.0, March 26, 2015
 */

public class PPMFigure extends PPMImage {
	
	// constructors
	//
	/**
	 * Creates an image of dimensions rows*cols by initializing the array pixels.
	 * Sets the color of every pixel of the image to "white".
	 * 
	 * @throws PPMException if rows <= 0 or cols <= 0
	 */
	public PPMFigure(int rows, int cols) throws PPMException;
	
	/**
	 * Creates an image of dimensions rows*cols.
	 * Sets the color of every pixel of the image to color.
	 * 
	 * Precondition: color is not null
	 * @throws PPMException if rows <= 0 or cols <= 0
	 */
	public PPMFigure(int rows, int cols, Pixel color) throws PPMException;
	
	// drawing methods
	/**
	 * Clears the image by seeting the value of every pixel in the image to color
	 * 
	 * Precondition: color is not null
	 */
	public void clear(Pixel color);
	
	/**
	 * Draws a straight line between (startRow, startCol) and (endRow, endCol) with the specified color
	 * 
	 * Precondition: color is not null
	 * @return false, if the start point or end point is outside the image coordinates; otherwise true 
	 */
	public boolean drawLine(int startRow, int startCol, int endRow, int endCol, Pixel color);
	
	/**
	 * Draws a rectabgle from the point (startRow, startCol) with the given width and height. 
	 * Parameter color specifies the fill color of the rectangle.
	 *  
	 * Precondition: color is not null
	 * Precondition: width > 0 and height > 0
	 * @return false, if any part of the rectangle is outside the image coordinates; otherwise true 
	 */
	public boolean drawRectangle(int startRow, int startCol, int width, int height, Pixel color);
	
}
