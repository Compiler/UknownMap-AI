import java.util.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Core{
	public static final Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
	public static Vector2 DIMENSIONS = new Vector2(1080, 600);
	public static void CLEAR(){for(int i = 0; i < 15; i++)System.out.println('\n');}

	public static void regenerateMaps(){
		
		Map map = new Map(101, 101);
		for(int i = 0; i < 50; i++){
			map = new Map(101, 101);
			map.createRandomMap();
			MapHandler.writeMap("map_"+(i+1)+".txt", map);
			
		}
	}
	public static void main(String... a)throws InterruptedException{
		Map map = MapHandler.loadMap("Maps/5x5.txt");	
		Vector2 goal = new Vector2(4,0);
		Vector2 start = new Vector2(0,4);
		//regenerateMaps();
		//MapTester.AdaptiveMaps("Adaptive.txt");	
		//MapTester.FBMaps("TieBreaking.txt");
		//MapTester.ForBackMaps("Forward_Backward.txt");	
		Scanner scan = new Scanner(System.in);
	
		String answer;
		while(true){
		CLEAR();
		map.printMap();

		
		System.out.print("1.) Step Algorithm\n2.) Generate H Values\n3.) Load new map\n");
		System.out.println("4.) Generate new map\n5.) Open GUI\n6.) Adaptive A*\n7.)Exit");

		answer = scan.nextLine();

		switch(answer){
				case "1":
						Algorithms.repeatedAStarForward(start, goal, map);
						break;
				case "6":
						Algorithms.adaptiveAStarForward(start,goal, map);
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


				case "5":
					JFrame frame = new JFrame("Sample Frame");
					Game game = new Game();
					frame.add(game);
					frame.setSize(DIMENSIONS.x, DIMENSIONS.y);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					while (true) {
		    			game.repaint();
		    			Thread.sleep(10);
					}


				case "7": System.exit(0);
		}
		}
	}
}

