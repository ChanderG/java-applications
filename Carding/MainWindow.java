import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainWindow extends JFrame{
	
	JPanel cards;
	String cardDisplayed;
	CardLayout cl;
	
	public void showCard(String cardName){
		cl.show(cards, cardName);
	}
	
	public MainWindow(){
		
		setVisible(true);
		
		cards = new JPanel();
		cards.setLayout(new CardLayout());
		add(cards);
		
		WelcomeScreen s1 = new WelcomeScreen(this);
		s1.setTitle("Snake and Ladders");
		
		
		JPanel jp2 = new JPanel(new FlowLayout());
		JLabel jl2 = new JLabel("Panel 2");
		JButton jb2 = new JButton("Go ahead!");
		jp2.add(jb2);
		jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				cl.show(cards, "Three");
			}
		});
		
		jp2.setSize(this.getSize());
		jp2.add(jl2);
		jp2.setVisible(true);
		
		JPanel jp3 = new JPanel(new FlowLayout());
		JLabel jl3 = new JLabel("Panel 3");
		
		jp3.setSize(this.getSize());
		jp3.add(jl3);
		jp3.setVisible(true);
		
		cards.add(s1,"One");
		cards.add(jp2,"Two");
		cards.add(jp3,"Three");
		
		cl = (CardLayout)(cards.getLayout());
		
		cl.show(cards, "One");
		showCard("One");	
	}

}
