import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Screen1 extends JPanel{
	JLabel title;
	JButton goButton;
	JButton quitButton;
	int cont = 0;
	
	public Screen1(){
		
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS ));
		title = new JLabel("Snake and Ladders");
		//title.setFont();                   //get from gui maker
		
		goButton = new JButton("Play");
		quitButton = new JButton("Quit");
		
		goButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				playButtonActionListener();
			}
			
		});
		
		quitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				quitButtonActionListener();
			}
			
		});
		
		add(title);
		//format here 
		add(goButton);
		add(quitButton);
		this.setVisible(true);
	}
	
	private void playButtonActionListener(){
		cont = 1;
	}
	
    private void quitButtonActionListener(){
		if(JOptionPane.showConfirmDialog(this, "Are You Sure?") == JOptionPane.OK_OPTION)
	        System.exit(0);
    }

}
