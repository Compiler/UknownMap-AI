

public class Core{

	public static void main(String... a){
		Map map = new Map(5,5);

		map.setSquare(2,3, 4,2, true);
		map.setSquare(2,2, 3,1, true, map.getMapSquare(2,3));
		map.setSquare(1,2, 9,7, true, map.getMapSquare(2,2));
		map.setSquare(1,1, 8,0, true, map.getMapSquare(1,2));
		map.printMap();
	}
}
//
