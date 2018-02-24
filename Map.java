


public class Map{

	public enum MapFlags{OPEN, VISITED, BLOCKED, START, FINISH}

	private Vector2 dimensions;
	private MapFlags map[][];
	
	public Map(int width, int height){
		dimensions = new Vector2(width, height);
		map = new MapFlags[dimensions.x][dimensions.y];
		
	}

	public void setBlock(int x, int y, MapFlags flag){
		map[x][y] = flag;
	}

	public MapFlags getMapInfo(int x, int y){ return map[x][y]; }
	
	public void printMap(int)

}
