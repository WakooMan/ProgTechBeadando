package tictactoe.exceptions;

/**
 * Thrown when field number (row, column) is out of range.
 */
public class FieldNumberOutOfRangeException extends Exception {
   
    /**
     * Default constructor.
     */
   public FieldNumberOutOfRangeException()
   {
       super();
   } 
   
   /**
    * Constructor with message.
    * @param message message.
    */
   public FieldNumberOutOfRangeException(String message)
   {
       super(message);
   } 
}
