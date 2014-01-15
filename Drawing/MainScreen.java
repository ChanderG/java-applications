import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;


public class MainScreen {
	
	public static void main(String args[]) throws Exception, InterruptedException{
		edt();
	}
	
	public static void edt() throws InvocationTargetException, InterruptedException{
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				Board p = new Board();
				p.setTitle("Graphics");
				//p.setLayout(new BorderLayout());
				p.setSize(600,500);
				p.setVisible(true);
			}
		});
	}

}
