package labirinth.model.utilities;

import java.util.Random;

/**
 * Generates random integers within a specified range.
 * Implements the IRandomGenerator interface.
 */
public class RandomGenerator implements IRandomGenerator {

    private final Random random = new Random();
    
    /**
     * Constructs a RandomGenerator.
     */
    public RandomGenerator() {
    }

    @Override
    public int generate(int min, int max) {
        // Generate and return a random integer within the specified range
        return random.nextInt(max - min + 1) + min;
    }

}
