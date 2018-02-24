


public class Map{


	private Vector2 dimensions;
	private MapSquare map[][];
	
	public Map(int width, int height){
		dimensions = new Vector2(width, height);
		map = new MapSquare[dimensions.x][dimensions.y];
		init();			
	}
	private void init(){
		for(int i = 0; i < dimensions.x;i++){
		for(int k = 0; k < dimensions.y;k++){
			map[i][k] = new MapSquare(i, k); 
		}}
	}

	public void setSquare(int x, int y, MapSquare flag){
		map[x][y] = flag;
	}
	public void setSquare(int x, int y, int h, int g, boolean blocked){
		map[x][y].setG(g);map[x][y].setH(h);
		map[x][y].setBlocked(blocked);
	}
	public void setSquare(int x, int y, int h, int g, boolean blocked, MapSquare parent){
		map[x][y].setG(g);map[x][y].setH(h);
		map[x][y].setBlocked(blocked);
		map[x][y].setParent(parent);
	}


	public MapSquare getMapSquare(int x, int y){ return map[x][y]; }
	
	public void printMap(){
		System.out.print('|');
		for(int i = dimensions.y-1; i > -1; i--){
			for(int k = 0; k < dimensions.x; k++)
				System.out.print(map[k][i] + "|");
			System.out.print('\n' + "|");
		}	
	}


}
//
