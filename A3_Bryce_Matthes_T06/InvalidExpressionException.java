public class InvalidExpressionException extends RuntimeException {

      //Parameterless Constructor
      public InvalidExpressionException() {

      }

      //Constructor that accepts a message
      public InvalidExpressionException(String message)
      {
         super(message);
      }
 }