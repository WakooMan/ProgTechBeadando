package capitaly.generators;

import java.util.*;

import capitaly.exceptions.NotEnoughTestRandomNumberException;

/**
 * Class, which can return numbers from a given Queue.
 * Used for testing purposes to simulate random numbers, where these numbers are read from an input file.
 */
public class FileRandomGenerator implements IRandomGenerator {

  private Queue<Integer> numbers;

  /**
   * Public constructor for constructing a FileRandomGenerator class object.
   * @param numbers the numbers, which will be returned by the generate method.
   */
  public FileRandomGenerator(Collection<Integer> numbers) {
    this.numbers = new LinkedList<Integer>(numbers);
  }

  @Override
  public Integer generate() throws NotEnoughTestRandomNumberException {
    if(numbers.isEmpty())
    {
      throw new NotEnoughTestRandomNumberException("Not enough test random number is added in input file.");
    }
    return numbers.poll();
  }

}