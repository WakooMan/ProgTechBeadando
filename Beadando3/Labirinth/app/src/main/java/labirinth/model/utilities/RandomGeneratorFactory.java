package labirinth.model.utilities;

public class RandomGeneratorFactory implements IRandomGeneratorFactory {

  public RandomGeneratorFactory() {
  }

  @Override
  public IRandomGenerator create() {
    return new RandomGenerator();
  }

}