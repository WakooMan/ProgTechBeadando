package capitaly;

import void;
import capitaly.generators.IRandomGenerator;
import String;
import capitaly.fields.IField;
import List<Integer>;
import Boolean;

public class Game {

  private static Game instance;

  private IField startField;

  private List<IPlayer> players;

  private Boolean isGameOver;

  private IRandomGenerator randomGenerator;

  private Game() {
  }

  public static Game getInstance() {
  return null;
  }

  public void start(String file) {
  }

  public IRandomGenerator getRandomGenerator() {
  return null;
  }

  private void readFromFile(String file) {
  }

  private void readTable(BufferedReader br) {
  }

  private void readPlayers(BufferedReader br) {
  }

  private List<Integer> readGeneratedNumbers(BufferedReader br) {
  return null;
  }

  private void gameLoop() {
  }

}