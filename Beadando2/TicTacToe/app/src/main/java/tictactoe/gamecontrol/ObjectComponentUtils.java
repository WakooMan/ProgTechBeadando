package tictactoe.gamecontrol;

public class ObjectComponentUtils {

  private static IMatchFactory matchFactory;

  private static ISaveHandler saveHandler;

  public static IMatchFactory getDefaultMatchFactory() {
    if(matchFactory == null)
    {
       matchFactory = new MatchFactory();
    }
    return matchFactory;
  }

  public static ISaveHandler getDefaultSaveHandler() {
    if(saveHandler == null)
    {
       saveHandler = new SaveHandler("saves");
    }
    return saveHandler;
  }

}