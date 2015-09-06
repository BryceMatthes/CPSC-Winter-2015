
/**
 * A class to represent rationla numbers.
 *  
 * @author	Majid Ghaderi
 * @version	1.0, Feb 28, 2015
 */

public class Rational {

	// instance variables
	private int	numerator;
	private int	denominator;
	
	// constructors
	public Rational();
	public Rational(int wholeNumber);
	public Rational(int numerator, int denominator);
	public Rational(Rational other); // copy constructor

	// static methods
	public static Rational add(Rational r1, Rational r2);
	public static Rational subtract(Rational r1, Rational r2);
	public static Rational multiply(Rational r1, Rational r2);
	public static Rational divide(Rational r1, Rational r2);

	public static Rational reciprocate(Rational r);
	public static Rational negate(Rational r);
	
	// non-static methods
	public void add(Rational r);
	public void subtract(Rational r);
	public void multiply(Rational r);
	public void divide(Rational r);
	
	public void reciprocate();
	public void negate();
	
	// accessor and mutator methods
	public void setNumerator(int num);
	public int getNumerator();
	
	public void setDenominator(int num);
	public int getDenominator();
	
	// additional methods
	public String toString();
	public boolean equals(Rational other);
}
