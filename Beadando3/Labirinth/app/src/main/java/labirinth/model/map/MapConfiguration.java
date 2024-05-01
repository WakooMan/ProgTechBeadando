package labirinth.model.map;

import java.util.ArrayList;
import java.util.List;

/**
 * The MapConfiguration class represents the configuration settings for the game map.
 */
public class MapConfiguration {

    private final int blockNum = 15;
    private int roadNumber = 3;
    private Position mapSize;
    private final List<IMapConfigurationListener> listeners;

    private static MapConfiguration instance;

    private MapConfiguration() {
        listeners = new ArrayList<>();
    }

    /**
     * Gets the singleton instance of MapConfiguration.
     *
     * @return The MapConfiguration instance.
     */
    public static MapConfiguration getInstance() {
        if (instance == null) {
            instance = new MapConfiguration();
        }
        return instance;
    }

    /**
     * Gets the number of blocks in the map.
     *
     * @return The number of blocks.
     */
    public int getBlockNum() {
        return blockNum;
    }

    /**
     * Gets the number of roads in the map.
     *
     * @return The number of roads.
     */
    public int getRoadNumber() {
        return roadNumber;
    }

    /**
     * Sets the number of roads in the map.
     *
     * @param roadNumber The number of roads.
     */
    public void setRoadNumber(int roadNumber) {
        this.roadNumber = roadNumber;
    }

    /**
     * Gets the size of a block in the map.
     *
     * @return The size of a block.
     */
    public Position getBlockSize() {
        return new Position(mapSize.getX() / blockNum, mapSize.getY() / blockNum);
    }

    /**
     * Gets the size of a wall in the map.
     *
     * @return The size of a wall.
     */
    public Position getWallSize() {
        return new Position(getBlockSize().getX() / 5, getBlockSize().getY() / 5);
    }

    /**
     * Gets the size of an entity in the map.
     *
     * @return The size of an entity.
     */
    public Position getEntitySize() {
        return new Position(getBlockSize().getX() / 2, getBlockSize().getY() / 2);
    }

    /**
     * Gets the size of a step in the map.
     *
     * @return The size of a step.
     */
    public Position getStepSize() {
        return new Position(getBlockSize().getX() / 10, getBlockSize().getY() / 10);
    }

    /**
     * Gets the sight range of the player in the map.
     *
     * @return The sight range of the player.
     */
    public int getPlayerSight() {
        return Math.min(getBlockSize().getX(), getBlockSize().getY()) * 3;
    }

    /**
     * Gets the size of the map.
     *
     * @return The size of the map.
     */
    public Position getMapSize() {
        return mapSize;
    }

    /**
     * Sets the size of the map and notifies listeners about the change.
     *
     * @param mapSize The size of the map.
     */
    public void setMapSize(Position mapSize) {
        this.mapSize = mapSize;
        for (IMapConfigurationListener listener : listeners) {
            listener.onMapSizeChanged();
        }
    }

    /**
     * Adds a listener for map configuration changes.
     *
     * @param listener The listener to add.
     */
    public void addMapConfigurationListener(IMapConfigurationListener listener) {
        listeners.add(listener);
    }
}
