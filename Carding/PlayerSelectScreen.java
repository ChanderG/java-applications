import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//needs massive aesthetic rewrites

public class PlayerSelectScreen extends JPanel {
	JButton go;
	JButton quit;
	MainWindow mw;
	

	public void quitButtonActionListener(){
		mw.showCard("One");
	}
	
	public void goButtonActionListener(){
		mw.showCard("Three");
	}
	
	public PlayerSelectScreen(MainWindow mw){
		this.mw = mw;
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JLabel mess = new JLabel("Select Players: ");
		add(mess);
		
		JLabel uc = new JLabel("Default: 1Player");
		add(uc);
		
		//set up radio buttons
		
		
		
		
		
		

		go = new JButton("Customize Board");
		quit = new JButton("Back");	
		
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
		
		add(go);
		add(quit);
		
	}
	

}
