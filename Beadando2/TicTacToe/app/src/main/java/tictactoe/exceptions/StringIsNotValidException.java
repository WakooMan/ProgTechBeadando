package tictactoe.exceptions;

/**
 * Thrown, when string is not valid.
 */
public class StringIsNotValidException extends Exception{
   
    /**
     * Default constructor.
     */
    public StringIsNotValidException()
   {
       super();
   } 
   
   /**
    * Constructor with message.
    * @param message message.
    */
   public StringIsNotValidException(String message)
   {
       super(message);
   } 
}
