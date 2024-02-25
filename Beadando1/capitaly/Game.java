package capitaly;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import capitaly.fields.*;
import capitaly.generators.*;
import capitaly.players.*;

public class Game {

  private static Game instance;

  private IField startField;

  private List<IPlayer> players;

  private Boolean isGameOver;

  private IRandomGenerator randomGenerator;

  private Game() {
    players = new ArrayList<IPlayer>();
    isGameOver = true;
  }

  public static Game getInstance() {
    if(instance == null)
    {
      instance = new Game();
    }
    return instance;
  }

  public void start(String file) {
    readFromFile(file);
    isGameOver = false;
    gameLoop();
  }

  public IRandomGenerator getRandomGenerator() {
    return randomGenerator;
  }

  private void readFromFile(String file) {
    try (FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr))
    {
      readTable(br);
      readPlayers(br);
      List<Integer> randomNumbers = readGeneratedNumbers(br);
      randomGenerator = (randomNumbers.size() > 0) ? new FileRandomGenerator(randomNumbers): new RandomGenerator(); 
    }
    catch(FileNotFoundException ex)
    {

    }
    catch(IOException ex)
    {

    }
  }

  private void readTable(BufferedReader br) throws IOException
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
          field = new Luck(luckValue);
          break;
          case "Service":
          Integer serviceValue = Integer.parseInt(splittedLine[1]);
          field = new Service(serviceValue);
          break;
        default:
          throw new IllegalArgumentException("");
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
          throw new IllegalArgumentException("");
      }
    }
  }

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

  private void gameLoop() {
    int round = 1;
    while(!isGameOver)
    {
      for (IPlayer player : players) {
        if(player.isInGame())
        {
          player.step();
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