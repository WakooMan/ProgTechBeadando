package capitaly.generators;

import java.util.*;

public class FileRandomGenerator implements IRandomGenerator {

  private Queue<Integer> numbers;

  public FileRandomGenerator(Collection<Integer> numbers) {
    this.numbers = new PriorityQueue<Integer>();
    for (Integer integer : numbers) {
     this.numbers.add(integer); 
    }
  }

  @Override
  public Integer generate() {
    return numbers.poll();
  }

}