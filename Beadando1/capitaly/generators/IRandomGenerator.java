package capitaly.generators;

import capitaly.exceptions.NotEnoughTestRandomNumberException;

/**
 * Public interface, which represents a random generator.
 */
public interface IRandomGenerator {

  /**
   * Gets a random generated number between 1 and 6.
   * @return Random Integer number between 1 and 6.
   * @throws NotEnoughTestRandomNumberException thrown, if there is no more test number in the Queue of FileRandomGenerator class.
   */
  public Integer generate() throws NotEnoughTestRandomNumberException;

}