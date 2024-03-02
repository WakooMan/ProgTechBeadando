package capitaly.generators;

import java.util.*;

import capitaly.exceptions.NotEnoughTestRandomNumberException;

public class FileRandomGenerator implements IRandomGenerator {

  private Queue<Integer> numbers;

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