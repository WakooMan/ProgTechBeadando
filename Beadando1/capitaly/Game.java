package capitaly;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import capitaly.exceptions.NotEnoughTestRandomNumberException;
import capitaly.exceptions.PlayerNotInGameException;
import capitaly.exceptions.WrongTableException;
import capitaly.fields.*;
import capitaly.generators.*;
import capitaly.players.*;

/**
 * Represents the capitaly game.
 * This class is responsible for reading the table with fields 
 * and initialize the game, then control the game until it ends.
 */
public class Game {

  private static Game instance;

  private IField startField;

  private List<IPlayer> players;

  private Boolean isGameOver;

  private IRandomGenerator randomGenerator;

  /**
   * Private constructor in order to enforce Singleton pattern.
   */
  private Game() {
    players = new ArrayList<IPlayer>();
    isGameOver = true;
  }

  /**
   * Returns an instance of the game.
   * @return Game instance.
   */
  public static Game getInstance() {
    if(instance == null)
    {
      instance = new Game();
    }
    return instance;
  }

  /**
   * Initializes the Game by reading an input file, then starts a game loop until the game ends.
   * @param file input file
   */
  public void start(String file) {
    try{
    readFromFile(file);
    isGameOver = false;
    gameLoop();
    }
    catch(FileNotFoundException ex)
    {
      System.out.println("Input file: " + file + " is not found!");
    }
    catch(IOException ex)
    {
      System.out.println("Error occured, when reading file: " + file);
    }
    catch(WrongTableException ex)
    {
      System.out.println(ex.getMessage());
    }
  }

  /**
   * Gets the random generator created during initialization.
   * @return IRandomGenerator object.
   */
  public IRandomGenerator getRandomGenerator() {
    return randomGenerator;
  }

  /**
   * reads the input file and initiates the table and the players based on it.
   * @param file input file.
   * @throws FileNotFoundException thrown, if file is not found.
   * @throws IOException thrown, if error happens during reading the file.
   * @throws WrongTableException thrown, if built table is wrong.
   */
  private void readFromFile(String file) throws FileNotFoundException, IOException, WrongTableException {
    try (FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr))
    {
      readTable(br);
      if(!checkIfTableContains(Property.class) || !checkIfTableContains(Service.class) || !checkIfTableContains(Luck.class))
      {
        throw new WrongTableException("The table should contain at least one Property, one Service and one Luck field.");
      }
      readPlayers(br);
      List<Integer> randomNumbers = readGeneratedNumbers(br);
      randomGenerator = (randomNumbers.size() > 0) ? new FileRandomGenerator(randomNumbers): new RandomGenerator(); 
    }
  }

  private Boolean checkIfTableContains(Class<? extends Field> fieldType) {
    IField currField = startField;

    do
    {
      if(fieldType.isInstance(currField))
      {
        return true;
      }
      currField = currField.getNext();
    }
    while(currField != startField);

    return false;
  }

  /**
   * Reads the fields from the input file.
   * @param br buffered reader.
   * @throws IOException thrown, if error happens during reading the file.
   * @throws WrongTableException thrown, if built table is wrong.
   */
  private void readTable(BufferedReader br) throws IOException, WrongTableException
  {
    String line = br.readLine();
    int tableLength = Integer.parseInt(line);
    IField previousField = null;
    for(int i=0;i < tableLength; i++)
    {
      line = br.readLine();
      String[] splittedLine = line.split(" ");
      IField field = null;
      switch (splittedLine[0]) {
        case "Property":
          field = new Property();
          break;
          case "Luck":
          Integer luckValue = Integer.parseInt(splittedLine[1]);
          if(luckValue < 0)
          {
            throw new WrongTableException("A Luck field's value should not be a negative number!");
          }
          field = new Luck(luckValue);
          break;
          case "Service":
          Integer serviceValue = Integer.parseInt(splittedLine[1]);
          if(serviceValue < 0)
          {
            throw new WrongTableException("A Service field's value should not be a negative number!");
          }
          field = new Service(serviceValue);
          break;
        default:
          throw new IllegalArgumentException("Input file is wrong! Field amount number is bigger, than the actual field count!");
      }
      if(previousField == null)
      {
        startField = field;
        previousField = startField;
      }
      else
      {
        previousField.setNext(field);
        previousField = field;
      }
    }
    previousField.setNext(startField);
  }

  /**
   * Reads the players from the input file.
   * @param br buffered reader.
   * @throws IOException thrown, if error happens during reading the file.
   */
  private void readPlayers(BufferedReader br) throws IOException
  {
    String line = br.readLine();
    int playerCount = Integer.parseInt(line);
    for(int i=0;i < playerCount; i++)
    {
      line = br.readLine();
      String[] splittedLine = line.split(" ");
      String name = splittedLine[0];
      switch (splittedLine[1]) {
        case "Greedy":
        players.add(new Greedy(name, startField));
          break;
          case "Cautious":
          players.add(new Cautious(name, startField));
          break;
          case "Tactician":
          players.add(new Tactician(name, startField));
          break;
        default:
          throw new IllegalArgumentException("Input file is wrong! Player amount number is bigger, than the actual player count!");
      }
    }
  }

  /**
   * Reads the random test numbers from the input file if there is any, else returns an empty list.
   * @param br buffered reader.
   * @return random test numbers in a list.
   * @throws IOException thrown, if error happens during reading the file.
   */
  private List<Integer> readGeneratedNumbers(BufferedReader br) throws IOException
  {
    List<Integer> randomNumbers = new ArrayList<Integer>();
    String line = br.readLine();

    while(line != null)
    {
      randomNumbers.add(Integer.parseInt(line));
      line = br.readLine();
    }

    return randomNumbers;
  }

  /**
   * Runs the game loop until the game ends and writes out the state of the players after each round.
   */
  private void gameLoop() {
    int round = 1;
    while(!isGameOver)
    {
      for (IPlayer player : players) {
        if(player.isInGame())
        {
          try{
            player.step();
          }
          catch(NotEnoughTestRandomNumberException ex)
          {
            System.out.println(ex.getMessage());
            isGameOver = true;
            return;
          }
          catch(PlayerNotInGameException ex)
          {
            System.out.println(ex.getMessage());
          }
          if(!player.isInGame() && players.stream().filter(pl -> pl.isInGame()).count() < 2)
          {
            isGameOver = true;
            break;
          }
        }
      }
      System.out.println(round + ". round's end state:");
      for (IPlayer player : players) {
        System.out.println("-------------------------------");
        System.out.print(player);
        System.out.println("-------------------------------");
      }
      round++;
    }
    System.out.println("Game is over!");
  }
}