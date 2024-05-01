package labirinth.view.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.function.Supplier;
import labirinth.model.entities.Direction;
import labirinth.model.map.Block;
import labirinth.model.map.Map;
import labirinth.model.map.MapConfiguration;
import labirinth.model.map.Position;
import labirinth.model.map.Rectangle;
import labirinth.resources.ResourceLoader;

/**
 * Responsible for drawing the map on the screen.
 */
public class MapDrawer implements IDrawable {

    private final Supplier<Map> getMapFunction;
    private Image horizontalWall;
    private Image verticalWall;
    
    /**
     * Constructs a MapDrawer object with the specified function to get the map.
     *
     * @param getMapFunction The function to get the map.
     */
    public MapDrawer(Supplier<Map> getMapFunction)
    {
        this.getMapFunction = getMapFunction;
        try{
            horizontalWall = ResourceLoader.loadImage("walls/HorizontalWall.png");
            verticalWall = ResourceLoader.loadImage("walls/VerticalWall.png");
        }
        catch(IOException ex)
        {
            horizontalWall = null;
            verticalWall = null;
        }
    }
    
    @Override
    public void draw(int dms, Graphics2D graphics) {
        Map map = getMapFunction.get();
        for(int i = 0; i < map.getBlockNum(); i++)
        {
            for(int j = 0; j < map.getBlockNum(); j++)
            {
                Block block = map.getBlock(i, j);
                graphics.setStroke(new BasicStroke(1));
                graphics.setColor(Color.black);
                Rectangle rect = block.getRectangle();
                graphics.fillRect(rect.getUpperLeftPoint().getX(), rect.getUpperLeftPoint().getY(), rect.getWidth(), rect.getHeight());
                if(block.getCell().getWall(Direction.Up) != null)
                {
                    drawHorizontalWall(graphics, rect.getUpperLeftPoint(), rect.getUpperRightPoint());   
                }
                if(block.getCell().getWall(Direction.Right) != null)
                {
                    drawVerticalWall(graphics, rect.getUpperRightPoint(), rect.getBottomRightPoint());   
                }
                if(block.getCell().getWall(Direction.Left) != null)
                {
                    drawVerticalWall(graphics, rect.getUpperLeftPoint(), rect.getBottomLeftPoint());   
                }
                if(block.getCell().getWall(Direction.Down) != null)
                {
                    drawHorizontalWall(graphics, rect.getBottomLeftPoint(), rect.getBottomRightPoint());   
                }
            }
        }
    }
    
    private void drawHorizontalWall(Graphics2D g, Position from, Position to)
    {
        if(horizontalWall != null)
        {
            g.drawImage(horizontalWall, 
                    from.getX(), 
                    from.getY(), 
                    to.getX() - from.getX(),
                    MapConfiguration.getInstance().getWallSize().getY(),
                    (img, infoflags, x, y, width, height) -> false);
        }
        else
        {
            g.setStroke(new BasicStroke(MapConfiguration.getInstance().getWallSize().getY()));
            g.setColor(Color.ORANGE);
            g.drawLine(from.getX(), from.getY(), to.getX(), to.getY()); 
        }
    }
    
    private void drawVerticalWall(Graphics2D g, Position from, Position to)
    {
        if(verticalWall != null)
        {
            g.drawImage(verticalWall, 
                    from.getX(), 
                    from.getY(), 
                    MapConfiguration.getInstance().getWallSize().getX(), 
                    to.getY() - from.getY(), 
                    (img, infoflags, x, y, width, height) -> false);
        }
        else
        {
            g.setStroke(new BasicStroke(MapConfiguration.getInstance().getWallSize().getX()));
            g.setColor(Color.ORANGE);
            g.drawLine(from.getX(), from.getY(), to.getX(), to.getY()); 
        }
    }
}
