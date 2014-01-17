import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainWindow extends JFrame {
	
	CardLayout cardlayout;
	JPanel cardController;
	
	public MainWindow(){
		
		//this.setLayout(new CardLayout());
		setLayout(new FlowLayout());
		
		
		cardController = new JPanel();
		cardController.setLayout(new CardLayout());
		cardController.setSize(getSize());
		
		cardlayout = new CardLayout();
		cardlayout = (CardLayout)(cardController.getLayout());
		
		Screen1 s1 = new Screen1();
		s1.setSize(getSize());
	    cardController.add(s1,"1");
   		//add(s1);
		
		cardlayout.show(cardController, "1");
   		//cardlayout.show(this, "1");
   		
		
		add(cardController);
	    setVisible(true);
		
	}

}
