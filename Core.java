import java.util.*;

public class Core{

	
	public static void CLEAR(){for(int i = 0; i < 15; i++)System.out.println('\n');}
		
	public static void main(String... a){
		Map map = MapHandler.loadMap("Maps/map1.txt");
		
		Vector2 goal = new Vector2(4,0);
		

		Scanner scan = new Scanner(System.in);
	
		String answer;
		while(true){
		CLEAR();
		map.printMap();
		
		System.out.println("1.) Step Algorithm\n2.) Generate H Values\n3.) Load new map\n4.) Generate new map\n5.) Exit");
		answer = scan.nextLine();
		switch(answer){
				case "1":
						Algorithms.repeatedAStarForward(new Vector2(1,0), goal, map);
						break;
				case "2":
					Algorithms.generateHValues(goal, map);
					break;
				case "3":
					System.out.println("Specify name of map..");
					map = MapHandler.loadMap("Maps/" + scan.nextLine());
					break;
				case "4":
					map = new Map(5,5);
					map.createRandomMap();
					break;
				case "5": System.exit(0);
		}
		}
	}
}

