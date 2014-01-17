import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

//note: board does not change dynamically 
//note: board shape and window aesthetics to be set
//note: unification of colors not done


public class BoardDrawing extends JPanel{

	int b = 0;
	int row = 8;
	int col = 8;
	ArrayList<Rectangle> cells;
	//int player;
	int[] cellnos;
	ArrayList<Portal> portals;
	ArrayList<Player> players;
	
	public BoardDrawing(int row, int col){
		this.row = row;
		this.col = col;
		//player = 0;
		players = new ArrayList<Player>();
		players.add(new Player());
		//get and add player(s) names
		
		cells = new ArrayList<Rectangle>();
		
		cellnos = new int[row*col];
	    for(int i= 0;i < row;i++){
	    	for(int j = 0;j< col;j++){
	    		if(i%2 == 0)
	    		    cellnos[i*col + j] = i*col + j;
	    		else
	    			cellnos[i*col + j] = i*col + (row - 1 - j);
	    	}
	    }
		
	    for(int i= 0;i < row;i++){
	    	for(int j = 0;j< col;j++){
	    		cellnos[i*col + j] = row*col -1 - cellnos[i*col + j];
	    	}
	    }
	    
	    int noPorts = 6;
	    portals = new ArrayList<Portal>(noPorts);
	    for(int i = 0; i < noPorts;i++){
	    	Portal temp = new Portal(row*col);
	    	portals.add(temp);
	    }
	
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;//.create();
		
		/*
		int sw = getSize().width;
		int sh = getSize().height;
		int a = (int) (0.75*((sw > sh)?sh:sw));
		
		//Point start = new Point(0,0);
		//Point end = new Point(100,100);
		
		g.drawLine(0,0,sw, sh);
		*/
	    
		//Create cells
		
		int width = getWidth();
		int height = getHeight();
		
		int cellWidth = width / col;
		int cellHeight = height / row;
		
		int xOffset = (width - (col * cellWidth)) / 2;
        int yOffset = (height - (row * cellHeight)) / 2;

		
		if(cells.isEmpty()){
		for(int i=0;i< row;i++){
			for(int j = 0;j<col;j++){
				Rectangle latest = new Rectangle(
						 xOffset + (j * cellWidth),
                         yOffset + (i * cellHeight),
                         cellWidth,
                         cellHeight);
				cells.add(latest); 
			}
		}
		}
	

		g2d.setColor(Color.white);
		for(Rectangle cell : cells){
			g2d.fill(cell);
		}
		
		g2d.setColor(Color.BLUE);
		for(Rectangle cell : cells){
			g2d.draw(cell);
		}
		
		//Draw cells and numbers
		//may have to modify program based on number of players
		
		g2d.setColor(Color.BLUE);
		int i=0;                                // i is our visible numbering 
		for(Rectangle cell : cells){
			
			String message = "" + cellnos[i];
		    g2d.drawString(message,(int)cell.getCenterX(),(int)cell.getCenterY());
			//g2d.setColor(Color.red);
			
		    //draw player position
			if(players.get(0).returnPosition() == cellnos[i]){                         //only one player considered here
				
				g2d.setColor(Color.red);        //change to player color
				g2d.fillRect(cell.getLocation().x, cell.getLocation().y, cellWidth/4, cellHeight/4);//change to player position
				g2d.setColor(Color.blue);
			}
			
		    i++;
		}
		
		//Drawing snakes and ladders
		for(Portal port:portals){
			if(port.returnNature() == -1)
				g2d.setColor(Color.red);
			else 
				g2d.setColor(Color.green);
			
			int ind;
			int s = port.returnStart(); 
			for(ind=0;ind<row*col;ind++){
				if(cellnos[ind] == s)
					break;
			}
			
			int j;
			int e = port.returnEnd(); 
			for(j=0;j<row*col;j++){
				if(cellnos[j] == e)
					break;
			}
			
			g2d.drawLine((int)cells.get(ind).getCenterX(),(int) cells.get(ind).getCenterY(),(int) cells.get(j).getCenterX(),(int)cells.get(j).getCenterY());
			
		}
		
	}
	/*
	public void ensurePlayerPosition(){
		for(Portal port :portals){
			if(player == port.returnStart())
				player = port.returnEnd();
		}
	}
	*/
	public void ensurePlayerPosition(int pnos){
		for(Portal port :portals){
			if(players.get(pnos).returnPosition() == port.returnStart())
				players.get(pnos).setPosition(port.returnEnd());
		}
	}
	
	
	/*
	public void setPlayer(int a){
		player = a;
	}
	*/
	
	public void setPlayer(int a, int pnos){
		players.get(pnos).incPosition(a);
	}
	
	
}