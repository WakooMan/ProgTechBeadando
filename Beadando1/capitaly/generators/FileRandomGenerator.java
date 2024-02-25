package capitaly.generators;

import java.util.*;

public class FileRandomGenerator implements IRandomGenerator {

  private Queue<Integer> numbers;

  public FileRandomGenerator(Collection<Integer> numbers) {
    this.numbers = new PriorityQueue<Integer>(numbers);
  }

  @Override
  public Integer generate() {
    return numbers.poll();
  }

}