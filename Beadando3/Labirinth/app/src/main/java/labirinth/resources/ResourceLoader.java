/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.resources;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author vitya
 */
public class ResourceLoader {
    public static InputStream loadResource(String resName)
    {
        return ResourceLoader.class.getClassLoader().getResourceAsStream(resName);
    }
    
    public static Image loadImage(String resName) throws IOException
    {
        URL url = ResourceLoader.class.getClassLoader().getResource(resName);
        if(url == null)
        {
            throw new IOException("File Not Found!");
        }
        return ImageIO.read(url);
    }
}
