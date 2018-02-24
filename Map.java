


public class Map{


	private Vector2 dimensions;
	private MapSquare map[][];
	
	public Map(int width, int height){
		dimensions = new Vector2(width, height);
		map = new MapSquare[dimensions.x][dimensions.y];
		
	}

	public void setBlock(int x, int y, MapSquare flag){
		map[x][y] = flag;
	}


	public MapSquare getMapSquare(int x, int y){ return map[x][y]; }
	
	public void printMap(){
		System.out.print('|');
		for(int i = dimensions.y; i > -1; i++){
			for(int k = 0; k < dimensions.x; k++){
				System.out.print(map[k][i] + "|");
			}
			System.out.print('\n' + "|");
		}	
	}


}
//
