package capitaly.generators;
import java.util.Random;

public class RandomGenerator implements IRandomGenerator {

  private Random random;

  public RandomGenerator() {
    random = new Random();
  }

  @Override
  public Integer generate() {
    return Math.abs(random.nextInt() % 6) + 1;
  }

}