package labirinth.model.entities;

/**
 * IPlayerEntityListener is an interface for listening to events related to player entities.
 */
public interface IPlayerEntityListener {

    /**
     * Called when the player entity dies.
     */
    void onPlayerDies();

    /**
     * Called when the player entity wins.
     */
    void onPlayerWins();
}
