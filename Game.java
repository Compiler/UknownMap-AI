import java.awt.*;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.util.*;
@SuppressWarnings("serial")
public class Game extends JPanel implements KeyListener {

    
	private VisualMapSquare squares[][];
	private Font font, menu;
	private Map map;
	private String d1 = "1.)Generate Random map";
	private String d2 = "2.)Repeated Forward A*";
	private String goal = "";
	Vector2 mapDims = new Vector2(101, 101);
	public Game(){
		map = new Map(mapDims.x,mapDims.y);
		map.createRandomMap();
		squares = new VisualMapSquare[map.getDimensions().x][map.getDimensions().y];
		for(int i = squares.length-1; i >= 0; i--){
			for(int k = 0; k < squares.length; k++){
				squares[k][i] = new VisualMapSquare(map.getMapSquare(k,i), new Vector2((Core.DIMENSIONS.x / mapDims.x), Core.DIMENSIONS.y / (mapDims.y+1)));
				squares[k][i].setPosition(new Vector2((k*squares[k][i].getDimensions().x), i *squares[k][i].getDimensions().y + 5*10));
			}
		}	

		addKeyListener(this);setFocusable(true);setFocusTraversalKeysEnabled(false);
		font = new Font("TimesRoman", Font.PLAIN, (Core.DIMENSIONS.x / Core.DIMENSIONS.y) * 10);
		menu = new Font("TimesRoman", Font.BOLD, (Core.DIMENSIONS.x / Core.DIMENSIONS.y) * 10);
		
	}
		
	@Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
    	g2d.setFont(menu);	
		g2d.drawString(goal, 5, 35);
		g2d.drawString(d1, 5, 20);
		g2d.drawString(d2, d1.length() * 15, 20);
    	g2d.setFont(font);
		for(int i = 0; i < squares.length; i++){
			for(int k = 0; k < squares[i].length; k++){
				squares[i][k].update(map.getMapSquare(i, k));
				squares[i][k].render(g2d);
			}
		}	

    }
	Random r = new Random();
	public void keyPressed(KeyEvent e){
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_1){
				map=new Map(mapDims.x,mapDims.y);
				map = MapHandler.loadMap("Maps/map_" + (r.nextInt(49) + 1) + ".txt");
				//map.createRandomMap();
		}
		if(code == KeyEvent.VK_2){
			int found = Algorithms.repeatedAStarForward(new Vector2(0, 0), new Vector2(map.getDimensions().x-1, map.getDimensions().y-1),map);
			if(found != -1) goal = "Goal was found in " + found + " steps.";
			else goal = "Could not find goal";
		}
		if(code == KeyEvent.VK_3){
				map=MapHandler.loadMap("Maps/open_map.txt");
		}
	}
	public void keyReleased(KeyEvent e){
	}
			
	public void keyTyped(KeyEvent e){
	}
	public void ActionPerformed(ActionEvent e){}


}
