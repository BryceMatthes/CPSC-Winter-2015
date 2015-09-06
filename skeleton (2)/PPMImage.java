
/**
 * A class for reading/writing and manipulating PPM images.
 *  
 * @author	Majid Ghaderi
 * @version	2.0, March 26, 2015
 */

public class PPMImage {

	//
	// image pixels
	// Defined protected so that it can be accessed directly in subclasses
	protected Pixel[][] pixels;
	
	//
	// constructors
	/**
	 * No-argument constructor to be used in subclasses only, i.e., in PPMFigure 
	 * Initializes the image type to "P3", maximum color value to 255
	 * Initializes the array pixels to null
	 */
	protected PPMImage();
	
	/**
	 * Reads the image file specified by fileName and initialize pixels accordingly
	 * 
	 * @throws PPMException if anything goes wrong during the loading of the file fileName
	 */
	public PPMImage(String fileName) throws PPMException;
	
	/**
	 * Initializes array pixels by deep copying the content of newPixels
	 * 
	 * Precondition: newPixels is not null
	 */
	public PPMImage(Pixel[][] newPixels);
	
	/**
	 * Copy constructor that makes a deep copy of the parameter image
	 */
	public PPMImage(PPMImage image);

	//
	// accessor and mutator methods
	/**
	 * Sets the pixel at (row, col) to a deep copy of pixel
	 * 
	 * Precondition: (row, col) is a valid index and pixel is not null
	 */
	public void setPixelAt(int row, int col, Pixel pixel);
	
	/**
	 * Returns the pixel at (row, col)
	 * 
	 * Precondition: (row, col) is a valid index
	 */
	public Pixel getPixelAt(int row, int col);
	
	/**
	 * Sets the instance variable pixels using a deep copy of newPixels
	 * 
	 * Precondition: newPixels is not null 
	 */
	public void setPixels(Pixel[][] newPixels);
	
	/**
	 * Returns a deep copy of instance variable pixels 
	 */
	public Pixel[][] getPixels();
	
	//
	// image operations
	/**
	 * Fattens the color in the image
	 * 
	 * @throws PPMException if the color is not one of "red", "green", "blue", ignore the upper/lower case
	 */
	public void flattenColor(String color) throws PPMException;
	
	/**
	 * Negates the color in the image
	 * 
	 * @throws PPMException if the color is not one of "red", "green", "blue", ignore the upper/lower case
	 */
	public void negateColor(String color) throws PPMException;
	
	/**
	 * Makes the image in grey scale
	 */
	public void greyScale();
	
	/**
	 * Tiles the image horizontally and vertically by the factors xRatio and yRatio, respectively
	 * 
	 * @throws PPMException of xRatio <= 0 or yRatio <= 0 
	 */
	public void tile(int xRatio, int yRatio) throws PPMException;
	
	/**
	 * Scales the image horizontally and vertically by the factors xRatio and yRatio, respectively
	 * 
	 * @throws PPMException if xRatio <= 0 or yRatio <= 0
	 */
	public void scale(double xRatio, double yRatio) throws PPMException;
	
	
	//
	// IO methods
	/**
	 * Saves the image in the file fileName. Should write the header and body of the image.
	 * 
	 * @throws PPMException if anyhting goes wrong during saving the image to the file
	 */
	public void save(String fileName) throws PPMException;
	
}
