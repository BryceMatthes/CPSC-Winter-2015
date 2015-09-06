/**
 * This class is used to add EmptyStackException to RuntimeExeception
 * 
 * ID:10147880
 * @author(s) Bryce Matthes
 * @date March 27 2015
 * @version	1.0
 */

public class EmptyStackException extends RuntimeException {

      /*
      * Parameterless Constructor
      *
      * @throws EmptyStackException
      */
      public EmptyStackException() {

      }

      /*
      * Parameterless Constructor
      *
      * @throws EmptyStackException
      */
      public EmptyStackException(String message)
      {
         super(message);
      }
 }