import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Board extends JFrame{

	int player = 0;
	BoardDrawing bd; 
	JPanel stats;
	JLabel dieResults;
	JLabel whichPlayer;
	
	public Board(){
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
	    bd = new BoardDrawing(8, 8);
		bd.setVisible(true);
		//bd.setSize(getSize());
		
		int sw = getSize().width;
		int sh = getSize().height;
		int a = (int) (0.75*((sw > sh)?sh:sw));
		
		bd.setSize(a, a);
		
		add(bd);
		getContentPane().add(bd);
		 
		
	    stats = new JPanel();
		stats.setLayout(new BoxLayout(stats, BoxLayout.Y_AXIS));
		getContentPane().add(stats);
		
		
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
          
		//getContentPane().add(roll);
		stats.add(roll);
		
		
		dieResults = new JLabel();
		stats.add(dieResults);
		
	}
	
}
