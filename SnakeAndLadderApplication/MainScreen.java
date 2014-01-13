import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class MainScreen {
	
	public static void main(String args[]){
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				MainScreen ms = new MainScreen();
				ms.displayMainScreen();
			}
		});
	}
	
	public void displayMainScreen(){
		final JFrame jf1 = new JFrame("Snake and Ladders - G Chander");
		jf1.setSize(400, 400);
		jf1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jf1.setLayout(new FlowLayout());
		jf1.setLayout(new BorderLayout());
		
		jf1.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent event){
				if(JOptionPane.showConfirmDialog(jf1, "Are you sure?") == JOptionPane.OK_OPTION){
					System.exit(0);	
		        }
			}
		});
		
		
		JLabel jl2 = new JLabel("A G.Chander development");
		jl2.setSize(200, 200);
		jl2.setLocation(200, 200);
		//jl2.setBorder()
		jl2.setPreferredSize(new Dimension(200, 200));
		
		JLabel jl1 = new JLabel("Welcome to Snake and Ladders Game");
		jl1.setSize(200, 200);
		jl1.setLocation(200, 200);
		jl1.setPreferredSize(new Dimension(200, 200));
		
		JPanel headPanel = new JPanel();
		headPanel.setLayout(new BoxLayout(headPanel, BoxLayout.PAGE_AXIS));
		headPanel.add(jl1);
		headPanel.add(jl2);
		jf1.add(headPanel, BorderLayout.CENTER);
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
		
		buttonPanel.add(Box.createHorizontalGlue());
		JButton goButton = new JButton("Let's Play");
		goButton.setSize(50, 50);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setSize(50, 50);
		
		buttonPanel.add(goButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(10,0)));
		buttonPanel.add(quitButton);
		
		jf1.add(buttonPanel,BorderLayout.PAGE_END);
		
		
		
		
		jf1.setVisible(true);
	}

}
