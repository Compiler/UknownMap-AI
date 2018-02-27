import java.util.*;

public class Algorithms{





	public static void generateHValues(Vector2 goal, Map map){
		for(int i = 0; i < map.getDimensions().x; i++){
			for(int k = 0; k<map.getDimensions().y; k++){
				Vector2 val = new Vector2(i - goal.x, k - goal.y);
				if(map.getMapSquare(i, k).getH() == 999)
				map.setSquare(i, k, (val.x < 0 ? -1*val.x : val.x) + (val.y < 0 ? -1*val.y : val.y));
			}
		}
	
	}
	
	public static int getGoalLength(Map map, Vector2 goal){
		MapSquare head = map.getMapSquare(goal);
		int count = 0;	
		while(head != null){
			count++;
			head = head.getParent();
		}
		return count;
	}

	public static void adaptiveAStarForward(Vector2 start, Vector2 goal, Map map){
		PriorityQueue<MapSquare> frontier = new PriorityQueue<MapSquare>();
		generateHValues(goal, map);
		HashMap<MapSquare, Integer> visited = new HashMap<MapSquare, Integer>();
		map.setSquare(start.x, start.y, 0, 0, false);
		frontier.offer(map.getMapSquare(start));
		int count = 0;
		//regos to imporve algo
			while(frontier.size() > 0){
	
				MapSquare cur = frontier.poll();
				Vector2 pos = cur.getPosition();
				visited.put(map.getMapSquare(pos.x, pos.y), 1);
				count++;
				//north value
				if(map.isValid(pos.x, pos.y+1)){
					MapSquare seq = map.getMapSquare(pos.x, pos.y+1);	
					if(pos.x == goal.x && pos.y+1 == goal.y){
						map.setSquareParent(goal.x, goal.y, map.getMapSquare(pos.x, pos.y));
					}else if(visited.containsKey(seq) == false && seq.isBlocked() == false){
							if(seq.getF() == 999 || seq.getF() > cur.getF()){
								map.setSquare(pos.x, pos.y+1, cur.getG() + 1, cur.getG()+1+seq.getH());
								map.setSquareParent(pos.x, pos.y+1, map.getMapSquare(pos.x, pos.y));
								frontier.offer(map.getMapSquare(pos.x,pos.y+1));
							}
					}
				}
			}
		for(MapSquare closed : visited.keySet()){
			int gvalx = map.getMapSquare(start).getPosition().x - closed.getPosition().x;
			int gvaly = map.getMapSquare(start).getPosition().y - closed.getPosition().y;
			gvalx = gvalx < 0 ? gvalx * -1 : gvalx;
			gvaly = gvaly < 0 ? gvalx * -1 : gvaly;
			closed.setH(getGoalLength(map, start) + (gvalx + gvaly));
		}
		for(int i = 0; i < map.getDimensions().x / 3; i++){
			MapSquare closed = map.getMapSquare(r.nextInt(map.getDimensions().x - 1) + 1, 
							r.nextInt(map.getDimensions().y - 1) + 1);
			int gvalx = map.getMapSquare(start).getPosition().x - closed.getPosition().x;
			int gvaly = map.getMapSquare(start).getPosition().y - closed.getPosition().y;
			gvalx = gvalx < 0 ? gvalx * -1 : gvalx;
			gvaly = gvaly < 0 ? gvalx * -1 : gvaly;
			closed.setH(getGoalLength(map, start) + (gvalx + gvaly));
		
		}
	}
	private static Random r = new Random();
	public static int repeatedAStarForward(Vector2 start, Vector2 goal, Map map){
		PriorityQueue<MapSquare> frontier = new PriorityQueue<MapSquare>();
		HashMap<MapSquare, Integer> visited = new HashMap<MapSquare, Integer>();
		generateHValues(goal, map);
		map.setSquare(start.x, start.y, 0, 0, false);
		frontier.offer(map.getMapSquare(start));
		int count = 0;
		while(frontier.size() > 0){
		MapSquare cur = frontier.poll();
			Vector2 pos = cur.getPosition();
			visited.put(map.getMapSquare(pos.x, pos.y), 1);
			count++;
			//north value
			if(map.isValid(pos.x, pos.y+1)){
				MapSquare seq = map.getMapSquare(pos.x, pos.y+1);	
				if(pos.x == goal.x && pos.y+1 == goal.y){
					map.setSquareParent(goal.x, goal.y, map.getMapSquare(pos.x, pos.y));
					return count;
				}else if(visited.containsKey(seq) == false && seq.isBlocked() == false){
						if(seq.getF() == 999 || seq.getF() > cur.getF()){
							map.setSquare(pos.x, pos.y+1, cur.getG() + 1, cur.getG()+1+seq.getH());
							map.setSquareParent(pos.x, pos.y+1, map.getMapSquare(pos.x, pos.y));
							frontier.offer(map.getMapSquare(pos.x,pos.y+1));
						}
				}
			}
			

			//south value
			if(map.isValid(pos.x, pos.y-1)){
				MapSquare seq = map.getMapSquare(pos.x, pos.y-1);	
				if(pos.x == goal.x && pos.y-1 == goal.y){
					map.setSquareParent(goal.x, goal.y, map.getMapSquare(pos.x, pos.y));
					return count;
				}else if(visited.containsKey(seq) == false && seq.isBlocked() == false){
						if(seq.getF() == 999 || seq.getF() > cur.getF()){
							map.setSquare(pos.x, pos.y-1, cur.getG() + 1, cur.getG()+1+seq.getH());
							map.setSquareParent(pos.x, pos.y-1, map.getMapSquare(pos.x, pos.y));
							frontier.offer(map.getMapSquare(pos.x,pos.y-1));
						}
				}
			}
			
			
			//west value
			if(map.isValid(pos.x-1, pos.y)){
				MapSquare seq = map.getMapSquare(pos.x-1, pos.y);	
				if(pos.x-1 == goal.x && pos.y == goal.y){
					map.setSquareParent(goal.x, goal.y, map.getMapSquare(pos.x, pos.y));
					return count;
				}else if(visited.containsKey(seq) == false && seq.isBlocked() == false){
						if(seq.getF() == 999 || seq.getF() > cur.getF()){
							map.setSquare(pos.x-1, pos.y, cur.getG() + 1, cur.getG()+1+seq.getH());
							map.setSquareParent(pos.x-1, pos.y, map.getMapSquare(pos.x, pos.y));
							frontier.offer(map.getMapSquare(pos.x-1,pos.y));
						}
				}
			}
			//east value
			if(map.isValid(pos.x+1, pos.y)){
				MapSquare seq = map.getMapSquare(pos.x+1, pos.y);	
				if(pos.x+1 == goal.x && pos.y == goal.y){
					map.setSquareParent(goal.x, goal.y, map.getMapSquare(pos.x, pos.y));
					return count;
				}else if(visited.containsKey(seq) == false && seq.isBlocked() == false){
						if(seq.getF() == 999 || seq.getF() > cur.getF()){
							map.setSquare(pos.x+1, pos.y, cur.getG() + 1, cur.getG()+1+seq.getH());
							map.setSquareParent(pos.x+1, pos.y, map.getMapSquare(pos.x, pos.y));
							frontier.offer(map.getMapSquare(pos.x+1,pos.y));
						}
				}
			}

		}
		return -1;

		
	
	
	
	}

}
