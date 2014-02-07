
package convert;

import java.sql.SQLException;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.SwingUtilities;

public class Convert {

    public static void main(String[] args) throws SQLException {
        /*
        Window w = new Window();
        w.setSize(520,370);
        w.setTitle("Hello Conversion");
        w.setVisible(true);
        */
        
        /*
        Test t = new Test();
        t.setSize(400, 400);
        t.setTitle("Panes and Areas");
        t.setVisible(true);
        */
        
        /*
        JFrame temp = new JFrame();
        StudentLogin sl = new StudentLogin();
        temp.setSize(400,400);
        temp.add(sl);
        temp.setTitle("Check it");
        temp.setVisible(true);
        */
        
        /*
        StudentLogin sl = new StudentLogin();
        
        JFrame temp = new JFrame();
        temp.setSize(400,400);
        TestPanel tes = new TestPanel(sl);
        temp.add(tes);
        temp.setTitle("Check it");
        temp.setVisible(true);
        */
        
        /*
        JFrame temp = new JFrame();
        temp.setSize(400,400);
        tWindow tw = new tWindow();
        temp.add(tw);
        temp.setTitle("Check it");
        temp.setVisible(true);
        */
        
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                JFrame wind = new JFrame();
                wind.setDefaultCloseOperation(EXIT_ON_CLOSE);
                wind.setTitle("MCTE");
                MainWindow mw = new MainWindow(wind);
                //mw.setSize(700, 500);
                mw.setVisible(true);
                
                wind.add(mw);
                wind.setSize(730, 500);
                //wind.setSize(550, 350);
                wind.setVisible(true);
            }
        });
        
        
        
                
                
    }
    
}
