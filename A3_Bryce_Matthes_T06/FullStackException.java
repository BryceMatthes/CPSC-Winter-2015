/**
 * This class is used to add FullStackException to RuntimeExeception
 * 
 * ID:10147880
 * @author(s) Bryce Matthes
 * @date March 27 2015
 * @version	1.0
 */

public class FullStackException extends RuntimeException {

      /*
      * Parameterless Constructor
      *
      * @throws FullStackException
      */
      public FullStackException() {

      }

      /*
      * Parameterless Constructor
      *
      * @throws FullStackException
      */
      public FullStackException(String message)
      {
         super(message);
      }
 }