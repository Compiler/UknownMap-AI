import java.io.*;

public class MapHandler{



	public static Map loadMap(String fileName){
	
        String line = null;
        try {
            FileReader fileReader = 
                new FileReader(fileName);
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
			line = bufferedReader.readLine();
			int split = line.indexOf(',');
			int width = Integer.parseInt(line.substring(0,split));
			int height = Integer.parseInt(line.substring(split+1, line.length()));
			Map map = new Map(width, height);
            while((line = bufferedReader.readLine()) != null) {
				int sp1 = line.indexOf('|');
				int sp2 = line.substring(sp1+1).indexOf('|');
				for(int x = 0; x < width; x++){
					String cur = line.substring(sp1,sp2);
					System.out.println("parsing: \"" + cur + "\"");
					int indexOfBlocked = cur.indexOf('_') == -1 ? cur.indexOf('X') : cur.indexOf('_');
					int g = Integer.parseInt(cur.substring(2, indexOfBlocked));
					int h = Integer.parseInt(cur.substring(indexOfBlocked+1, cur.length()));
					char blocked = cur.charAt(indexOfBlocked);
					map.setSquare(x, height-1, h, g, blocked == 'X');
					sp1 = sp2;
					sp2 = line.substring(sp1+2).indexOf('|') + sp1;
					sp1++;sp2++;
				}
				height-=1;
            }   
            bufferedReader.close();         
			return map;	
        }
        catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
		return null;	
	}

	public static void writeMap(String fileName, Map map){
		try{
            FileWriter fileWriter = new FileWriter("Maps/"+fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(""+map.getDimensions().x + ","+map.getDimensions().y);
            bufferedWriter.newLine();
            for(int y = map.getDimensions().y - 1; y > -1; y--){
				String line = "|";
				for(int x = 0; x < map.getDimensions().x; x++){
					line += (map.getMapSquare(x,y) + "|");
				}
				bufferedWriter.write(line);
            	bufferedWriter.newLine();
			}
            bufferedWriter.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }		
	
	}
	


}
