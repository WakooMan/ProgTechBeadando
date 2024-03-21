package tictactoe.exceptions;

public class StringIsNotValidException extends Exception{
   public StringIsNotValidException()
   {
       super();
   } 
   
   public StringIsNotValidException(String message)
   {
       super(message);
   } 
}
