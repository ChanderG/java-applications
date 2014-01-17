import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class BoardScreen extends JPanel{

	int player = 0;
	BoardDrawing bd; 
	JPanel stats;
	JLabel dieResults;
	JLabel whichPlayer;
	MainWindow mw;
	
	JButton go;
	JButton quit;

	public void quitButtonActionListener(){
		if(JOptionPane.showConfirmDialog(this, "Are you sure?") == JOptionPane.OK_OPTION)
	        System.exit(0);
	}
	
	public void goButtonActionListener(){
		mw.showCard("Two");
	}
 
	
	
	public BoardScreen(MainWindow mw){
		this.mw = mw;
		
		go = new JButton("New Game");
		quit = new JButton("Quit");	
		
		go.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				goButtonActionListener();
			}
		});
		
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				 quitButtonActionListener();
			}
		});
				
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
	    bd = new BoardDrawing(8, 8);
		bd.setVisible(true);
		//bd.setSize(getSize());
		
		int sw = getSize().width;
		int sh = getSize().height;
		int a = (int) (0.75*((sw > sh)?sh:sw));
		
		bd.setSize(a, a);
		
		add(bd);
		 
		
	    stats = new JPanel();
		stats.setLayout(new BoxLayout(stats, BoxLayout.Y_AXIS));
		add(stats);
		
		stats.add(go);
		stats.add(quit);
		
		
		
		String playername = "Player 1";
		
		whichPlayer = new JLabel();
		whichPlayer.setText(playername);
		stats.add(whichPlayer);
		
		//modify action listener to move between the n players 
		//outside needs to know some amount of player data which may be got be asking and passing to inside
		//no need to create separate stores outside
		//may need more functions inside to communicate for this reason
		JButton roll = new JButton("Roll the die!");
		roll.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Random die = new Random();
				int a = die.nextInt(6) + 1;
				dieResults.setText("You rolled a " + a);
				player += a;
				//bd.setPlayer(player);
				bd.setPlayer(a, 0);
				//bd.ensurePlayerPosition();
				bd.ensurePlayerPosition(0);
				bd.repaint();
			}
		});
		roll.setVisible(true);
          
		stats.add(roll);
		
		
		dieResults = new JLabel();
		stats.add(dieResults);
		
		
		
	}
	
}
