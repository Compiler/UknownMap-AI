import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Core{
	public static final Vector2 DIMENSIONS = new Vector2(720, 480);
	
	public static void CLEAR(){for(int i = 0; i < 15; i++)System.out.println('\n');}

	public static void main(String... a)throws InterruptedException{
		Map map = MapHandler.loadMap("Maps/map1.txt");
		
		Vector2 goal = new Vector2(4,0);
		

		Scanner scan = new Scanner(System.in);
	
		String answer;
		while(true){
		CLEAR();
		map.printMap();

		
		System.out.print("1.) Step Algorithm\n2.) Generate H Values\n3.) Load new map\n");
		System.out.println("4.) Generate new map\n5.) Open GUI\n6.) Exit");

		answer = scan.nextLine();

		switch(answer){
				case "1":
						Algorithms.repeatedAStarForward(new Vector2(1,0), goal, map);
						break;
				case "7":
						Algorithms.repeatedAStarForward(goal, new Vector2(1,0), map);
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


				case "6": System.exit(0);
		}
		}
	}
}

