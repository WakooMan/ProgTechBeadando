package labirinth.model.utilities;

import java.util.Random;

public class RandomGenerator implements IRandomGenerator {

  private final Random random = new Random();
    
  public RandomGenerator() {
  }

  @Override
  public int generate(int min, int max) {
    return random.nextInt(max - min + 1) + min;
  }

}