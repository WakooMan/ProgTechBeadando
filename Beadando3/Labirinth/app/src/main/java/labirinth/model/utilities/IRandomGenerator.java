package labirinth.model.utilities;

/**
 * Interface for generating random integers within a specified range.
 */
public interface IRandomGenerator {

    /**
     * Generates a random integer within the specified range.
     *
     * @param min The minimum value (inclusive) of the range.
     * @param max The maximum value (inclusive) of the range.
     * @return A random integer within the specified range.
     */
    public int generate(int min, int max);

}
