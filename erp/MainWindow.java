package erp;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame{
	
	JPanel cards;
	String cardDisplayed;
	CardLayout cl;
	
	MainScreen s1;
	DeanScreen1 s2;
        DeanScreen2 s3; 
        InitStudentRegScreen s4;
	//BoardScreen s4;            // 
	
	public void showCard(String cardName){
		cl.show(cards, cardName);
	}
	
	public void resetAll() throws ClassNotFoundException{
		s1 = new MainScreen(this);
		s2 = new DeanScreen1(this); 
		s3 = new DeanScreen2(this); 
                s4 = new InitStudentRegScreen(this);
		//s4 = new BoardScreen(this);            //
		
		cards.add(s1,"One");
		cards.add(s2,"Dean Screen 1");
		cards.add(s3, "Dean Screen 2");          //
		cards.add(s4, "Init Stud Reg Screen");
                //cards.add(s4, "Four");            //
	}
	
        /*
	//maintaining board info
	public void setBoard(){
		s4 = new BoardScreen(this);
		cards.add(s4, "Four");
	}
	
        */
	public MainWindow() throws ClassNotFoundException{
		
		setVisible(true);
		
		cards = new JPanel();
		cards.setLayout(new CardLayout());
		add(cards);
		
		s1 = new MainScreen(this);
		
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                
		/*
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
		
		*/
		
		/*
		JPanel jp5 = new JPanel(new FlowLayout());
		JLabel jl5 = new JLabel("Panel 5");
		
		jp5.setSize(this.getSize());
		jp5.add(jl5);
		jp5.setVisible(true);
		*/
		
		
		s2 = new DeanScreen1(this);
		s3 = new DeanScreen2(this); 
                s4 = new InitStudentRegScreen(this);
		//s4 = new BoardScreen(this);            //
		
		cards.add(s1,"One");
		cards.add(s2,"Dean Screen 1");
		cards.add(s3, "Dean Screen 2");                 
		cards.add(s4, "Init Stud Reg Screen");
                //cards.add(s4, "Four");                    //
		
		//cards.add(jp2,"Two");
		//cards.add(jp4,"Four");
		//cards.add(jp5, "Five");                  //
		
		cl = (CardLayout)(cards.getLayout());
		
		cl.show(cards, "One");
		showCard("One");	
	}

}
