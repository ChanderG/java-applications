import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PlayerSelectionMenu extends JPanel{
	
	private int continuePermission = 0;
	
	
	public PlayerSelectionMenu(){
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		JLabel hw = new JLabel("Hello World");
		add(hw);
		JButton go = new JButton("Done");
		go.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				//continuePermission = 1;
			    setVisible(false);
			    //dispose();
			}
		});
		
		add(go);
	}
	
	public int returnContinuePermission(){
		return continuePermission;
	}
	

}
