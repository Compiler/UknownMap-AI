import java.lang.*;
public class MapSquare implements Comparable<MapSquare>{
	

	private boolean blocked = false;
	private Vector2 position = new Vector2(-1,-1);
	private MapSquare parent;
	private int g = 999, h = 999;
	private int f = 999;

	public MapSquare(int x, int y, boolean blocked){
		this.blocked = blocked;
		this.position = new Vector2(x,y);
	}
	public MapSquare(int x, int y){
		this.position = new Vector2(x,y);
	}

	public char getDirection(){
		if(parent == null) return ' ';
		Vector2 pp = parent.getPosition();
		if(pp.x > position.x) return '>';
		else if(pp.y < position.y) return 'v';
		else if(pp.x < position.x) return '<';
		return '^';

		
	}
	public boolean isBlocked(){return blocked;}
	public int getH(){return h;}
	public int getG(){return g;}
	public int getF(){return f;}
	public MapSquare getParent(){return parent;}
	public Vector2 getPosition(){return this.position;}
	public void setG(int g){this.g=g;}
	public void setH(int h){this.h=h;}
	public void setF(int f){this.f=f;}
	public void setBlocked(boolean blocked){this.blocked=blocked;}
	public void setParent(MapSquare p){this.parent = p;}	
	public String toString(){
		return ""+ getDirection() +"" + g + "" + (blocked ? 'X' : '_') + "" + h+ "" +  getDirection();
	}


	public static int tie_breaking_method = 0;
	@Override
	public int compareTo(MapSquare s1){
		int f1 = h + g;
		int f2 = s1.getH() + s1.getG();
		if(f1 == f2){
			if(tie_breaking_method == 0)
				return (999 * g - f1) - (999* s1.getG() - f2);
			else return (999 * f1 - g) - (999*f2 - s1.getG());
		}

		return f1- f2;
	}

}
//
