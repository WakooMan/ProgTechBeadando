package labirinth.model.map;

/**
 * The IMapConfigurationListener interface defines a listener for map configuration changes.
 */
public interface IMapConfigurationListener {
    
    /**
     * Called when the size of the map configuration changes.
     */
    void onMapSizeChanged();
}
