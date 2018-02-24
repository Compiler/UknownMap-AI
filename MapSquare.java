
public class MapSquare {
	

	private boolean blocked = false;
	private Vector2 position = new Vector2(-1,-1);
	private MapSquare parent;
	private int g, h;

	public MapSquare(int x, int y, boolean blocked){
		this.blocked = blocked;
		this.position = new Vector2(x,y);
	}
	public MapSquare(int x, int y){
		this.position = new Vector2(x,y);
	}

	public char getDirection(MapSquare parent){
		if(parent == null) return ' ';
		Vector2 pp = parent.getPosition();
		if(pp.x > position.x) return '>';
		else if(pp.y < position.y) return 'v';
		else if(pp.x < position.x) return '<';
		return '^';

		
	}
	public Vector2 getPosition(){return this.position;}

	public String toString(){
		return ""+ getDirection(parent) +"" +  g + "" + (blocked ? 'X' : '_') + "" + h+ "" +  getDirection(parent);
	}


}
//
