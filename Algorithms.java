import java.util.*;

public class Algorithms{





	public static void generateHValues(Vector2 goal, Map map){
		for(int i = 0; i < map.getDimensions().x; i++){
			for(int k = 0; k<map.getDimensions().y; k++){
				Vector2 val = new Vector2(i - goal.x, k - goal.y);
				map.setSquare(i, k, (val.x < 0 ? -1*val.x : val.x) + (val.y < 0 ? -1*val.y : val.y));
			}
		}
	
	}



	public static void repeatedAStarForward(Vector2 start, Vector2 goal, Map map){
		PriorityQueue<MapSquare> frontier = new PriorityQueue<MapSquare>();
		HashMap<MapSquare, Integer> visited = new HashMap<MapSquare, Integer>();
		generateHValues(goal, map);
		
		map.setSquare(start.x, start.y, 0, 0, false);
		frontier.offer(map.getMapSquare(start));
		int i = 0;
		while(frontier.size() > 0){
		MapSquare cur = frontier.poll();
			Vector2 pos = cur.getPosition();
			visited.put(map.getMapSquare(pos.x, pos.y), 1);
			System.out.println("Checking ("+ pos.x + ", " + pos.y + ")");
		

			//north value
			if(map.isValid(pos.x, pos.y+1)){
				MapSquare seq = map.getMapSquare(pos.x, pos.y+1);	
				if(pos.x == goal.x && pos.y+1 == goal.y){
					System.out.println("Goal found");
					map.setSquareParent(goal.x, goal.y, map.getMapSquare(pos.x, pos.y));
					return;
				}else if(visited.containsKey(seq) == false && seq.isBlocked() == false){
						if(seq.getF() == 999 || seq.getF() > cur.getF()){
							map.setSquare(pos.x, pos.y+1, cur.getG() + 1, cur.getG()+1+seq.getH());
							map.setSquareParent(pos.x, pos.y+1, map.getMapSquare(pos.x, pos.y));
							frontier.offer(map.getMapSquare(pos.x,pos.y+1));
							System.out.println("Setting "+ seq.getPosition() + " g to 1");
							System.out.println("Setting " + seq.getPosition() + " parent to " + pos.x + ", " + pos.y);
						}
				}else System.out.println(seq.getPosition() + " has been visited or is blocked");
			}else System.out.println("("+ pos.x + ", " + (pos.y+1) + ") is invalid");
			

			//south value
			if(map.isValid(pos.x, pos.y-1)){
				MapSquare seq = map.getMapSquare(pos.x, pos.y-1);	
				if(pos.x == goal.x && pos.y-1 == goal.y){
					System.out.println("Goal found");
					map.setSquareParent(goal.x, goal.y, map.getMapSquare(pos.x, pos.y));
					return;
				}else if(visited.containsKey(seq) == false && seq.isBlocked() == false){
						if(seq.getF() == 999 || seq.getF() > cur.getF()){
							map.setSquare(pos.x, pos.y-1, cur.getG() + 1, cur.getG()+1+seq.getH());
							map.setSquareParent(pos.x, pos.y-1, map.getMapSquare(pos.x, pos.y));
							frontier.offer(map.getMapSquare(pos.x,pos.y-1));
							System.out.println("Setting "+ seq.getPosition() + " g to 1");
							System.out.println("Setting " + seq.getPosition() + " parent to " + pos.x + ", " + pos.y);
						}
				}else System.out.println(seq.getPosition() + " has been visited or is blocked");
			}else System.out.println("("+ pos.x + ", " + (pos.y-1) + ") is invalid");
			
			
			//west value
			if(map.isValid(pos.x-1, pos.y)){
				MapSquare seq = map.getMapSquare(pos.x-1, pos.y);	
				if(pos.x-1 == goal.x && pos.y == goal.y){
					System.out.println("Goal found");
					map.setSquareParent(goal.x, goal.y, map.getMapSquare(pos.x, pos.y));
					return;
				}else if(visited.containsKey(seq) == false && seq.isBlocked() == false){
						if(seq.getF() == 999 || seq.getF() > cur.getF()){
							map.setSquare(pos.x-1, pos.y, cur.getG() + 1, cur.getG()+1+seq.getH());
							map.setSquareParent(pos.x-1, pos.y, map.getMapSquare(pos.x, pos.y));
							frontier.offer(map.getMapSquare(pos.x-1,pos.y));
							System.out.println("Setting "+ seq.getPosition() + " g to 1");
							System.out.println("Setting " + seq.getPosition() + " parent to " + pos.x + ", " + pos.y);
						}
				}else System.out.println(seq.getPosition() + " has been visited or is blocked");
			}else System.out.println("("+ (pos.x-1) + ", " + (pos.y) + ") is invalid");
	
			//east value
			if(map.isValid(pos.x+1, pos.y)){
				MapSquare seq = map.getMapSquare(pos.x+1, pos.y);	
				if(pos.x+1 == goal.x && pos.y == goal.y){
					System.out.println("Goal found");
					map.setSquareParent(goal.x, goal.y, map.getMapSquare(pos.x, pos.y));
					return;
				}else if(visited.containsKey(seq) == false && seq.isBlocked() == false){
						if(seq.getF() == 999 || seq.getF() > cur.getF()){
							map.setSquare(pos.x+1, pos.y, cur.getG() + 1, cur.getG()+1+seq.getH());
							map.setSquareParent(pos.x+1, pos.y, map.getMapSquare(pos.x, pos.y));
							frontier.offer(map.getMapSquare(pos.x+1,pos.y));
							System.out.println("Setting "+ seq.getPosition() + " g to 1");
							System.out.println("Setting " + seq.getPosition() + " parent to " + pos.x + ", " + pos.y);
						}
				}else System.out.println(seq.getPosition() + " has been visited or is blocked");
			}else System.out.println("("+ (pos.x+1) + ", " + (pos.y) + ") is invalid");
		
		
		}

		
	
	
	
	}

}
