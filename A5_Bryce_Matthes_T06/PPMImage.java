
/**
 * This class is used to manage 2D arrays of the Pixel object.
 * ## my code doesn't have the Tile and Scale functions working. ##
 *
 * ID:10147880
 * @author(s) Bryce Matthes, Majid Ghaderi
 * @date Aril 10 2015
 * @version	1.0
 */

import java.io.*;

public class PPMImage {

	//
	// image pixels
	// Defined protected so that it can be accessed directly in subclasses
	Pixel[][] pixels;
	Pixel myPixel = new Pixel();
	public int col = 0;
	public int row = 0;
	
	//
	// constructors
	/**
	 * Just here so my extended class will run.
	 */
	protected PPMImage(){

	}
	/**
	 * Reads the image file specified by fileName and initialize pixels accordingly
	 * 
	 * @throws PPMException if anything goes wrong during the loading of the file fileName
	 */
	public PPMImage(String fileName) throws PPMException{
		try {
			Writer writer = null;
			FileInputStream fstream = new FileInputStream(fileName);
			BufferedReader bReader = new BufferedReader(new InputStreamReader(fstream));
			int myCount = 0;
			String strLine;
			int counter = 0;
			row = 0;
			col = 0;
			//Begin to read file
			while ((strLine = bReader.readLine()) != null)   {
 				if (counter == 0){
  					if((strLine).equals("P3")){

  					}
  					else{
  						throw new PPMException(); //If the first line isn't P3
  					}
 				}
  				else if (counter == 1){
  					int rowCount = 0;
  					int colCount = 0;
  					String[] splited = strLine.split("\\s+"); //Break up row and col into small array
  					col = Integer.parseInt(splited[0]);
  					row = Integer.parseInt(splited[1]);
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
  				else if (counter == 2){
  				}		
  				else if(strLine != null){
  					int colCount = 0;
  					int countSplit = 0;
  					String[] splited = strLine.split("\\s+");
  					int splittedLen = splited.length;
  					while((splittedLen)!=countSplit && myCount < row){
  						pixels[myCount][colCount] = new Pixel(Integer.parseInt(splited[countSplit]),Integer.parseInt(splited[countSplit+1]),Integer.parseInt(splited[countSplit+2]));
  						countSplit = countSplit + 3;
  						colCount++;
  					}
  				myCount++;
  				}
  			counter++;
		}
		bReader.close();
		} 
		catch (PPMException e) {
			e.printStackTrace();
		}
		catch (IOException d) {
			d.printStackTrace();
		}
	}
	
	/**
	 * Initializes array pixels by deep copying the content of newPixels
	 * 
	 * Precondition: newPixels is not null
	 */
	public PPMImage(Pixel[][] newPixels){
		int rowCount = 0;
		int colCount = 0;
		if(newPixels != null){
			while(row > rowCount){
  				pixels[rowCount][colCount] = newPixels[rowCount][colCount];
  				colCount++;
  				if(colCount == col){
  					colCount = 0;
  					rowCount++;
  				}
  			}
  		}
	}
	
	/**
	 * Copy constructor that makes a deep copy of the parameter image
	 */
	public PPMImage(PPMImage image){
		int rowCount = 0;
		int colCount = 0;
		row = image.rowVal();
		col = image.colVal();
		pixels = new Pixel[row][col];
		while(row > rowCount){
  			pixels[rowCount][colCount] = new Pixel();
  			colCount++;
  			if(colCount == col){
  				colCount = 0;
  				rowCount++;
  			}
  		} 
  		rowCount = 0;
  		colCount = 0;	
		Pixel[][] toCopyPix = image.getPixels();
		while(row > rowCount){
  			pixels[rowCount][colCount].copyPixel(toCopyPix[rowCount][colCount]);
  			colCount++;
  			if(colCount == col){
  				colCount = 0;
  				rowCount++;
  			}
		}
	}
	/*
	 * @return col
	 *
	 */
	public int colVal(){
		return col;
	}
	/*
	 * @return row
	 *
	 */
	public int rowVal(){
		return row;
	}
	//
	// accessor and mutator methods
	/**
	 * Sets the pixel at (row, col) to a deep copy of pixel
	 * 
	 * Precondition: (row, col) is a valid index and pixel is not null
	 */
	public void setPixelAt(int row2, int col2, Pixel pixel){
		pixels[row2][col2].copyPixel(pixel);
	}
	
	/**
	 * Returns the pixel at (row, col)
	 * 
	 * Precondition: (row, col) is a valid index
	 */
	public Pixel getPixelAt(int row2, int col2){
		return pixels[row2][col2];
	}
	
	/**
	 * Sets the instance variable pixels using a deep copy of newPixels
	 * 
	 * Precondition: newPixels is not null 
	 */
	public void setPixels(Pixel[][] newPixels){

	}
	
	/**
	 * Returns a deep copy of instance variable pixels 
	 */
	public Pixel[][] getPixels(){
		return pixels;
	}
	
	//
	// image operations
	/**
	 * Fattens the color in the image
	 * 
	 * @throws PPMException if the color is not one of "red", "green", "blue", ignore the upper/lower case
	 */
	public void flattenColor(String color) throws PPMException{
		color = color.toUpperCase();
		if((color).equals("RED")){	
			int rowCount = 0;
			int colCount = 0;
			while(row > rowCount){
  				pixels[rowCount][colCount] = new Pixel(0,pixels[rowCount][colCount].getBlue(),pixels[rowCount][colCount].getGreen());
  				colCount++;
  				if(colCount == col){
  					colCount = 0;
  					rowCount++;
  				}
  			}
  		}
  		else if((color).equals("BLUE")){	
			int rowCount = 0;
			int colCount = 0;
			while(row > rowCount){
  				pixels[rowCount][colCount] = new Pixel(pixels[rowCount][colCount].getRed(),0,pixels[rowCount][colCount].getGreen());
  				colCount++;
  				if(colCount == col){
  					colCount = 0;
  					rowCount++;
  				}
  			}
  		}
  		else if((color).equals("GREEN")){	
			int rowCount = 0;
			int colCount = 0;
			while(row > rowCount){
  				pixels[rowCount][colCount] = new Pixel(pixels[rowCount][colCount].getRed(),pixels[rowCount][colCount].getBlue(),0);
  				colCount++;
  				if(colCount == col){
  					colCount = 0;
  					rowCount++;
  				}
  			}
  		}
  		else{
  			throw new PPMException();
  		}
	}
	
	/**
	 * Negates the color in the image
	 * 
	 * @throws PPMException if the color is not one of "red", "green", "blue", ignore the upper/lower case
	 */
	public void negateColor(String color) throws PPMException{
		color = color.toUpperCase();
		if((color).equals("RED")){	
			int rowCount = 0;
			int colCount = 0;
			while(row > rowCount){
  				pixels[rowCount][colCount] = new Pixel(255-pixels[rowCount][colCount].getRed(),255-pixels[rowCount][colCount].getBlue(),255-pixels[rowCount][colCount].getGreen());
  				colCount++;
  				if(colCount == col){
  					colCount = 0;
  					rowCount++;
  				}
  			}
  		}
  		else if((color).equals("BLUE")){	
			int rowCount = 0;
			int colCount = 0;
			while(row > rowCount){
  				pixels[rowCount][colCount] = new Pixel(255-pixels[rowCount][colCount].getRed(),255-pixels[rowCount][colCount].getBlue(),255-pixels[rowCount][colCount].getGreen());
  				colCount++;
  				if(colCount == col){
  					colCount = 0;
  					rowCount++;
  				}
  			}
  		}
  		else if((color).equals("GREEN")){	
			int rowCount = 0;
			int colCount = 0;
			while(row > rowCount){
  				pixels[rowCount][colCount] = new Pixel(255-pixels[rowCount][colCount].getRed(),255-pixels[rowCount][colCount].getBlue(),255-pixels[rowCount][colCount].getGreen());
  				colCount++;
  				if(colCount == col){
  					colCount = 0;
  					rowCount++;
  				}
  			}
  		}
  		else{
  			throw new PPMException();
  		}
	}
	
	/**
	 * Makes the image in grey scale
	 */
	public void greyScale(){
		int rowCount = 0;
		int colCount = 0;
		while(row > rowCount){
  			int average = (pixels[rowCount][colCount].getRed()+pixels[rowCount][colCount].getBlue()+pixels[rowCount][colCount].getGreen())/3;
  			pixels[rowCount][colCount] = new Pixel(average,average,average);
  			colCount++;
  			if(colCount == col){
  				colCount = 0;
  				rowCount++;
  			}
  		}
	}

	//### Doesn't Function ###
	/**
	 * Tiles the image horizontally and vertically by the factors xRatio and yRatio, respectively
	 * 
	 * @throws PPMException of xRatio <= 0 or yRatio <= 0 
	 */
	public void tile(int xRatio, int yRatio) throws PPMException{}
	

	//### Doesn't Function ###
	/**
	 * Scales the image horizontally and vertically by the factors xRatio and yRatio, respectively
	 * 
	 * @throws PPMException if xRatio <= 0 or yRatio <= 0
	 */
	public void scale(double xRatio, double yRatio) throws PPMException{}
	
	
	//
	// IO methods
	/**
	 * Saves the image in the file fileName. Should write the header and body of the image.
	 * 
	 * @throws PPMException if anyhting goes wrong during saving the image to the file
	 */
	public void save(String fileName) throws IOException{
		int rowCount = 0;
		int colCount = 0;
		FileWriter fw = new FileWriter(fileName);
		fw.write("P3\n");
		fw.write(col+" "+row+"\n");
		fw.write("255\n");
		while(row > rowCount){
			String redS = ""+pixels[rowCount][colCount].getRed();
			String blueS = ""+pixels[rowCount][colCount].getBlue();
			String greenS = ""+pixels[rowCount][colCount].getGreen();
  				fw.write(redS+" "+blueS+" "+greenS);
  				colCount++;
  				if(colCount == col){
  					colCount = 0;
  					fw.write("\n");
  					rowCount++;
  				}
  				else{
  					fw.write(" ");
  				}
  		}
		fw.close();
	}
}