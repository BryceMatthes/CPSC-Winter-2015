
/**
 * A class to represent a matrices of rationla numbers.
 *  
 * @author	Majid Ghaderi
 * @version	1.0, Feb 28, 2015
 */

public class RationalMatrix {
	
	// instance variables
	private	Rational[][]	matrix;

	// constructors
	public RationalMatrix(int rows, int columns);
	public RationalMatrix(int rows, int columns, Rational initial);
	public RationalMatrix(Rational[][] matrix);
	public RationalMatrix(RationalMatrix other); // copy constructor
	
	// static methods
	public static RationalMatrix add(RationalMatrix m1, RationalMatrix m2); // addition
	public static RationalMatrix subtract(RationalMatrix m1, RationalMatrix m2); // subtraction
	public static RationalMatrix multiply(RationalMatrix m, Rational r); // scalar multiplication

	public static RationalMatrix transpose(RationalMatrix m);
	public static RationalMatrix negate(RationalMatrix m);
	
	// non-static methods
	public void add(RationalMatrix m); // addition
	public void subtract(RationalMatrix m); // subtraction
	public void multiply(Rational r); // scalar multiplication
	
	public void transpose();
	public void negate();
	
	// accessor and mutator methods
	public void setMatrix(Rational[][] m);
	public Rational[][] getMatrix();
	
	public void setAt(int row, int column, Rational r);
	public Rational getAt(int row, int column);

	// additional methods
	public boolean equals(RationalMatrix other);
	public String toString();
}
