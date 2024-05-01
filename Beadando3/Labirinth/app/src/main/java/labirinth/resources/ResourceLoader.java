package labirinth.resources;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * Utility class for loading resources such as images.
 */
public class ResourceLoader {

    /**
     * Loads a resource as an InputStream.
     *
     * @param resName The name of the resource.
     * @return An InputStream representing the loaded resource.
     */
    public static InputStream loadResource(String resName) {
        return ResourceLoader.class.getClassLoader().getResourceAsStream(resName);
    }
    
    /**
     * Loads an image resource.
     *
     * @param resName The name of the image resource.
     * @return The loaded Image object.
     * @throws IOException if the image resource cannot be loaded.
     */
    public static Image loadImage(String resName) throws IOException {
        URL url = ResourceLoader.class.getClassLoader().getResource(resName);
        if (url == null) {
            throw new IOException("File Not Found!");
        }
        return ImageIO.read(url);
    }
}
