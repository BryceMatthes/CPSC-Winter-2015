
/**
 * This class is used to evaulte expressions and throw exceptions if said expressions have errors
 * 
 * Based on sudo code provided in Assignment 4 folder
 *
 * ID:10147880
 * @author(s) Bryce Matthes
 * @date March 27 2015
 * @version	1.0
 */

public class Expression{

	/**
	*
	* The evaluate method is used to evalute the String expr
	*
	* @param expr - the expression to be evaluated
	* @return this method returns a double holding the value of the evaluated expression
	*/
	public double evaluate(String expr) throws InvalidExpressionException{

		expr = expr.replaceAll("\\s+","");
		int n = expr.length();
		if (n < 5){
			throw new InvalidExpressionException();
		}
		BoundedStack S = new BoundedStack(n);
		int i = 0;
		double n1 = 0;
		double n2 = 0;
		int lbCounter = 0; //left brackets counter
		int rbCounter = 0; //right bracket counter
		String op = "";
		double result = 0;
		char[] exprArray = expr.toCharArray();
		if (exprArray[i] != '('){
			throw new InvalidExpressionException();
		}
		while (i < n){
			char c = exprArray[i];
			if (c=='+'||c=='-'||c=='*'||c=='/'||c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c =='9'||c =='('){
				if (c=='('){
					lbCounter++;
				}
				String cPush = "" + c;
				S.push(cPush);
			}
			else if (c == ')'){
				rbCounter++;
				try{
					n2 = Double.parseDouble(S.pop());
				}
				catch(NumberFormatException b){
					throw new InvalidExpressionException();
				}
				catch(EmptyStackException j){
					throw new EmptyStackException();
				}
				catch(FullStackException p){
					throw new FullStackException();
				}
				try{
					op = S.pop();
				}
				catch(InvalidExpressionException h){
					throw new InvalidExpressionException();
				}
				catch(EmptyStackException m){
					throw new EmptyStackException();
				}
				catch(FullStackException j){
					throw new FullStackException();
				}
				try{
					n1 = Double.parseDouble(S.pop());
				}
				catch(NumberFormatException v){
					throw new InvalidExpressionException();
				}
				catch(EmptyStackException z){
					throw new EmptyStackException();
				}
				catch(FullStackException j){
					throw new FullStackException();
				}
				S.pop(); //clear '('
				char op2 = (op).charAt(0);	
				if (op2 == '+'){
					result = n1+n2;
				}
				else if (op2 == '-'){
					result = n1-n2;
				}
				else if (op2 == '*'){
					result = n1*n2;
				}
				else if (op2 == '/'){
					result = (n1)/(n2);
				}
				String resultPush = String.valueOf(result);
				S.push(resultPush);
			}	
			else if (c != ' '){
				throw new InvalidExpressionException();
			}
			i++;
		}
		if (lbCounter != rbCounter){//uneven brackets
			throw new InvalidExpressionException();
		}
		else if (n > 5 && lbCounter == 1){//missing brackets
			throw new InvalidExpressionException();
		}
		double returnValue = Double.parseDouble(S.pop());
		if (S.isEmpty() == false){
			throw new InvalidExpressionException();
		}
		return(returnValue);
	}
}