package labirinth.model.map;

public class MapGeneratorFactory implements IMapGeneratorFactory {

  public MapGeneratorFactory() {
  }

  @Override
  public IMapGenerator create() {
  return new MapGenerator();
  }

}