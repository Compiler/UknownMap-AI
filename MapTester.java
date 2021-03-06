import java.io.*;


public class MapTester{




	public static void AdaptiveMaps(String fileName){
	    try{


            FileWriter fileWriter = new FileWriter("Results/"+fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Goal\tMap#\tForward\tAdaptive\n\n");
			Vector2 start = new Vector2(0,0);
			Vector2 goal = new Vector2(0,0);
			
			Map	map = MapHandler.loadMap("Maps/map_1.txt");
			
			
			goal.x = map.getDimensions().x - 1;
			start.y = map.getDimensions().y - 1;
			for(int j = 0; j <50; j++){

				map = MapHandler.loadMap("Maps/map_"+(j+1) +".txt");

				Algorithms.repeatedAStarForward(start, goal, map);
				int found = Algorithms.repeatedAStarForward(new Vector2(0,0), goal,map);
				map = MapHandler.loadMap("Maps/map_"+(j+1) +".txt");
				Algorithms.adaptiveAStarForward(start, goal, map);
				int found2 = Algorithms.repeatedAStarForward(new Vector2(0, 0), goal, map);

				bufferedWriter.write((found == -1 ? "No" : "Yes") + "\t\t"+(j+1) + "\t\t"+found+"\t\t"+found2);
            	bufferedWriter.newLine();
			}
            bufferedWriter.close();
     	}catch(IOException ex) {
            ex.printStackTrace();
        }		
				MapSquare.tie_breaking_method = 0;
	}	

	public static void FBMaps(String fileName){
	    try{


            FileWriter fileWriter = new FileWriter("Results/"+fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Goal\tMap#\tlow G\thigh G\n-----------------------------------\n");
			Vector2 start = new Vector2(0,0);
			Vector2 goal = new Vector2(0,0);
			Map map;
			for(int j = 0; j <50; j++){


				map = MapHandler.loadMap("Maps/map_"+(j+1) +".txt");
				MapSquare.tie_breaking_method = 0;
				goal.x = map.getDimensions().x - 1;
				start.y = map.getDimensions().y - 1;
				int found = Algorithms.repeatedAStarForward(start, goal, map);
				map = MapHandler.loadMap("Maps/map_"+(j+1) +".txt");
				MapSquare.tie_breaking_method = 1;
				int found2 = Algorithms.repeatedAStarForward(start, goal, map);
				bufferedWriter.write((found == -1 ? "No" : "Yes") + "\t\t"+(j+1) + "\t\t"+found+"\t\t"+found2);
            	bufferedWriter.newLine();
			}
            bufferedWriter.close();
     	}catch(IOException ex) {
            ex.printStackTrace();
        }		
				MapSquare.tie_breaking_method = 0;
	}	
	public static void ForBackMaps(String fileName){
	    try{


            FileWriter fileWriter = new FileWriter("Results/"+fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Goal\tMap#\tForward\tBackward\n-----------------------------------------------------------------------------\n");
			Vector2 start = new Vector2(0,0);
			Vector2 goal = new Vector2(0,0);
			Map map;
			for(int j = 0; j <50; j++){


				map = MapHandler.loadMap("Maps/map_"+(j+1) +".txt");
				goal.x = map.getDimensions().x - 1;
				start.y = map.getDimensions().y - 1;
				int found = Algorithms.repeatedAStarForward(start, goal, map);
				map = MapHandler.loadMap("Maps/map_"+(j+1) +".txt");
				int found2 = Algorithms.repeatedAStarForward(goal, start, map);
				bufferedWriter.write((found == -1 ? "No" : "Yes") + "\t\t"+(j+1) + "\t\t"+found+"\t\t"+found2);
            	bufferedWriter.newLine();
			}
            bufferedWriter.close();
     	}catch(IOException ex) {
            ex.printStackTrace();
        }		
	}	
}
