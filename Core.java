

public class Core{

	public static void main(String... a){
		//Map map = new Map(5,5);
		//map.createRandomMap();
		Map map = MapHandler.loadMap("Maps/map1.txt");
		map.printMap();
		//MapHandler.writeMap("map1.txt", map);
	}
}

