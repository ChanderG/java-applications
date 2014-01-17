import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainWindow extends JFrame{
	
	JPanel cards;
	String cardDisplayed;
	CardLayout cl;
	
	public MainWindow(){
		//this.setLayout(new CardLayout());
		
		//cl = (CardLayout)(cards.getLayout());
		
		cards = new JPanel();
		cards.setLayout(new CardLayout());
		add(cards);
		
		WelcomeScreen s1 = new WelcomeScreen();
		s1.setTitle("Snake and Ladders");
		
		JPanel jp2 = new JPanel(new FlowLayout());
		JLabel jl2 = new JLabel("Panel 2");
		jp2.setSize(this.getSize());
		jp2.add(jl2);
		jp2.setVisible(true);
		
		cards.add(s1,"One");
		cards.add(jp2,"Two");
		
		cl = (CardLayout)(cards.getLayout());
		s1.setCl(cl,cards);
		
		cardDisplayed = "One";
		//cardDisplayed =
		cl.show(cards, cardDisplayed);
		setVisible(true);
	}

}
