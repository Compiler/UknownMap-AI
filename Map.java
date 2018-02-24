import java.util.*;


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


	public void createRandomMap(){
		int visits[][] = new int[dimensions.x][dimensions.y];
		Vector2 cur = new Vector2(0, 0);
		Stack<Vector2> stack = new Stack<Vector2>();

		stack.push(cur);
		Random rand = new Random();
		boolean completed = false;

		while(!completed){
            while(stack.empty() == false){
                cur=stack.pop();
				if(visits[cur.x][cur.y] == 1) continue;
				else visits[cur.x][cur.y] = 1;
				if(rand.nextDouble() > 0.7)
					map[cur.x][cur.y].setBlocked(true);
				
				
				
				if(cur.x > 0){
					Vector2 nxt = new Vector2(cur.x-1, cur.y);
					if(visits[nxt.x][nxt.y] == 0)stack.push(nxt);
				}
				if(cur.y > 0){
					Vector2 nxt = new Vector2(cur.x, cur.y-1);
					if(visits[nxt.x][nxt.y] == 0)stack.push(nxt);
				}	
				if(cur.x < dimensions.x-1){
					Vector2 nxt = new Vector2(cur.x+1, cur.y);
					if(visits[nxt.x][nxt.y] == 0)stack.push(nxt);
				}	
				if(cur.y < dimensions.y-1){
					Vector2 nxt = new Vector2(cur.x, cur.y+1);
					if(visits[nxt.x][nxt.y] == 0)stack.push(nxt);
				}	
                 
                 
            }
			completed = true;
			for(int i = 0; i < visits.length; i++){
				for(int k = 0; k < visits.length; k++){
					if(visits[i][k] == 0){
						cur = new Vector2(i, k); completed = false;
					}
				}
			}
		}

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
