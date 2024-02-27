package capitaly.generators;

import capitaly.exceptions.NotEnoughTestRandomNumberException;

public interface IRandomGenerator {

  public Integer generate() throws NotEnoughTestRandomNumberException;

}