import java.awt.*;
import java.awt.geom.*;

public class VisualMapSquare{




	private MapSquare info;

	private Vector2 dimensions;
	private Rectangle rect;
	private String hs, gs, fs;
	private Vector2 position;

	public VisualMapSquare(MapSquare data, Vector2 dimensions){
		this.info = data;
		this.dimensions = dimensions;
		this.rect = new Rectangle(dimensions.x, dimensions.y);
		hs = "h:"+info.getH();
		gs = "g:"+info.getG();
		fs = "f:" + info.getF();
		position = new Vector2(0,0);
	}
		
	public void update(MapSquare data){
		this.info = data;
		this.dimensions = dimensions;
		hs = "h:"+info.getH();
		gs = "g:"+info.getG();
		fs = "f:" + info.getF();
		
}

	public void setDimensions(Vector2 dims){
		this.dimensions = dims;
		rect.setSize(dims.x, dims.y);

	}
	public Vector2 getDimensions(){return dimensions;}
	public void setPosition(Vector2 pos){
		rect.setBounds(pos.x, pos.y, dimensions.x, dimensions.y);
		this.position = pos;
	}
	private Vector2 adir = new Vector2(0,0);
	public void render(Graphics2D g2){
		if(info.getDirection() != ' '){
			g2.setColor(Color.green);
			switch(info.getDirection()){
				case '^': adir.x = position.x;
						adir.y = position.y - dimensions.y - 50;
			g2.drawString(""+String.format("%0" + (1) + "d", 0).replace("0", ""+info.getDirection()), (int)rect.getX(), (int)rect.getY()/1);
						  		  		  break;
				
				case 'v': adir.x = position.x;
						adir.y = position.y;
				g2.drawString(""+String.format("%0" + (1) + "d", 0).replace("0", ""+info.getDirection()), adir.x, adir.y);
						  break;
				case 'a': adir.x = position.x+dimensions.x;
						adir.y = position.y;
						  for(int i = 0; i < dimensions.y/5; i++)g2.drawString(">", adir.x + dimensions.x, adir.y - 5*i);
					break;
				case 'g': adir.x = position.x;
						adir.y = position.y - dimensions.y;
						for(int i = 0; i < dimensions.y/5; i++)g2.drawString(">", adir.x, adir.y - 5*i);
						break;
			}
		
		}			
		g2.setColor(Color.black);	
		if(info.isBlocked()) g2.fill(rect);
		else g2.draw(rect);
		//g2.drawString(hs + " p="+(info.getParent() == null ? "" : info.getParent().getPosition()), position.x+3, position.y + dimensions.y - 1);
        //g2.drawString(gs, position.x+3, position.y - (dimensions.y /3) + dimensions.y - 1);
        //g2.drawString(fs, position.x+3, position.y- (2*dimensions.y / 3) + dimensions.y - 1); 
		
		
	
	}




}
