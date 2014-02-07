/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package videostore;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.SwingUtilities;

/**
 *
 * @author chander
 */
public class VideoStore {

   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                JFrame wind = new JFrame();
                wind.setTitle("Video Store");
                wind.setSize(600,600);
                
                MainMenu mm = new MainMenu(wind);
                mm.setVisible(true);
                wind.add(mm);
                
                wind.setDefaultCloseOperation(EXIT_ON_CLOSE);
                wind.setVisible(true);
            }
        });
        
    }
    
}
