package capitaly.generators;
import java.util.Random;

/**
 * RandomGenerator class, which can generate a random number.
 */
public class RandomGenerator implements IRandomGenerator {

  private Random random;

  /**
   * Public constructor for constructing a RandomGenerator class object.
   */
  public RandomGenerator() {
    random = new Random();
  }

  @Override
  public Integer generate() {
    return Math.abs(random.nextInt() % 6) + 1;
  }

}