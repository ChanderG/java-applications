import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

//note: board does not change dynamically 
//note: board shape and window aesthetics to be set


public class BoardDrawing extends JPanel{

	int b = 0;
	int row = 8;
	int col = 8;
	ArrayList<Rectangle> cells;
	int player;
	int[] cellnos;
	
	public BoardDrawing(int row, int col){
		this.row = row;
		this.col = col;
		player = 0;
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
	

		g2d.setColor(Color.yellow);
		for(Rectangle cell : cells){
			g2d.fill(cell);
		}
		
		g2d.setColor(Color.BLUE);
		for(Rectangle cell : cells){
			g2d.draw(cell);
		}
		
		g2d.setColor(Color.BLUE);
		int i=0;
		for(Rectangle cell : cells){
			
			String message = "" + cellnos[i];
		    g2d.drawString(message,(int)cell.getCenterX(),(int)cell.getCenterY());
			//g2d.setColor(Color.red);
			
			if(player == cellnos[i]){
				g2d.setColor(Color.red);
				g2d.fillRect(cell.getLocation().x, cell.getLocation().y, cellWidth/4, cellHeight/4);
				g2d.setColor(Color.blue);
			}
			
		    i++;
		}
		
		
		
		//Toolkit.getDefaultToolkit().sync();
		//g2d.dispose();
	}
	
	
	public void setPlayer(int a){
		player = a;
	}
	
	
}
