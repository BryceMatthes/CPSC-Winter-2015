
/**
 * Extended functionality for the PPMImage class.
 * ## My code doesn't have the drawRectange function working ##
 *
 * ID:10147880
 * @author(s) Bryce Matthes, Majid Ghaderi
 * @date Aril 10 2015
 * @version	1.0
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
	public PPMFigure(int rows, int cols) throws PPMException{
		row = rows;
		col = cols;
		int rowCount = 0;
		int colCount = 0;
		if(rows <= 0 || cols <= 0){
			throw new PPMException();
		}
		else{
			pixels = new Pixel[row][col];
			while(row > rowCount){
  				pixels[rowCount][colCount] = new Pixel();
  				colCount++;
  				if(colCount == col){
  					colCount = 0;
  					rowCount++;
  				}
  			} 
		}
	}
	
	/**
	 * Creates an image of dimensions rows*cols.
	 * Sets the color of every pixel of the image to color.
	 * 
	 * Precondition: color is not null
	 * @throws PPMException if rows <= 0 or cols <= 0
	 */
	public PPMFigure(int rows, int cols, Pixel color) throws PPMException{
		row = rows;
		col = cols;
		int rowCount = 0;
		int colCount = 0;
		if(rows <= 0 || cols <= 0 || color == null){
			throw new PPMException();
		}
		else{
			pixels = new Pixel[row][col];
			while(row > rowCount){
  				pixels[rowCount][colCount] = new Pixel(color.getRed(),color.getBlue(),color.getGreen());
  				colCount++;
  				if(colCount == col){
  					colCount = 0;
  					rowCount++;
  				}
  			} 
		}
	}
	
	// drawing methods
	/**
	 * Clears the image by seeting the value of every pixel in the image to color
	 * 
	 * Precondition: color is not null
	 */
	public void clear(Pixel color){
		if(color == null){

		}
		else{
			int rowCount = 0;
			int colCount = 0;
			while(row > rowCount){
  				pixels[rowCount][colCount] = new Pixel(color.getRed(),color.getBlue(),color.getGreen());
  				colCount++;
  				if(colCount == col){
  					colCount = 0;
  					rowCount++;
  				}
			}
		}
	}
	
	/**
	 * Draws a straight line between (startRow, startCol) and (endRow, endCol) with the specified color
	 * 
	 * Precondition: color is not null
	 * @return false, if the start point or end point is outside the image coordinates; otherwise true 
	 */
	public boolean drawLine(int startRow, int startCol, int endRow, int endCol, Pixel color){
		if(startRow < 0 || startRow > row || startCol > col || startCol < 0){
			return false;
		}
		else{
			double dx = endCol - startCol;
			double dy = endRow - startRow;
			for (int col = startCol; col <= endCol; col++){
				int row = (int) (startRow + col*(dy/dx));
				pixels[row][col] = new Pixel(color);
			}
			return true;
		}
	}
	
	/**
	 * Draws a rectabgle from the point (startRow, startCol) with the given width and height. 
	 * Parameter color specifies the fill color of the rectangle.
	 *  
	 * Precondition: color is not null
	 * Precondition: width > 0 and height > 0
	 * @return false, if any part of the rectangle is outside the image coordinates; otherwise true 
	 */
	public boolean drawRectangle(int startRow, int startCol, int width, int height, Pixel color){
		return true;
	}
}
