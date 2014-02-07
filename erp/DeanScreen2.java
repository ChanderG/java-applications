
package erp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DeanScreen2 extends JPanel {
    
    MainWindow mw;
    JLabel titleLabel;
    JLabel selSemLabel;
    JComboBox selSemComboBox;
    DefaultComboBoxModel model;
    String sem;
    JLabel selCorLabel;
    JComboBox selCorComboBox;
    DefaultComboBoxModel model2;
    JButton backButton;
    JLabel selCredLabel;
    JComboBox selCredComboBox;
    JLabel selTypeLabel;
    JComboBox selTypeComboBox;
    JButton addButton;
    JButton finishButton;
    
    String courseid;
    int credit;
    String ctype;
    
    public void readAndUpdateCorCodes() throws ClassNotFoundException{
        model2.removeAllElements();
        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String url = "jdbc:derby:testdb";
        
        try {
            
            System.setProperty("derby.system.home", 
                    "home/mDbFolder");
           
            
            DriverManager.registerDriver( new org.apache.derby.jdbc.EmbeddedDriver());
            
            con = DriverManager.getConnection(url);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM USER12.COURSEMASTER");
        
            
            while (rs.next()) {
                model2.addElement(rs.getString(1));
                System.out.println(rs.getString(1));
                rs.getString(2);
                rs.getString(3);
            }
            
            DriverManager.getConnection("jdbc:derby:;shutdown=true");

        } catch (SQLException ex) {
            
            Logger lgr = Logger.getLogger(DeanScreen2.class.getName());

            if (((ex.getErrorCode() == 50000)
                    && ("XJ015".equals(ex.getSQLState())))) {

                lgr.log(Level.INFO, "Derby shut down normally", ex);

            } else {

                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }

        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(DeanScreen2.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        
        
        
    }
    
    private void backButtonActionEvent(){
        mw.showCard("Dean Screen 1");
    }
    
    public void courseAllocate(){
        
        courseid = (String) selCorComboBox.getSelectedItem();
        credit = Integer.parseInt((String)selCredComboBox.getSelectedItem());
        ctype = (String) selTypeComboBox.getSelectedItem();
        
        Connection con = null;
        Statement st = null;
        PreparedStatement pst = null;
        
        String url = "jdbc:derby:testdb;user=USER12";

        try {
            
            System.setProperty("derby.system.home", 
                    "home/mDbFolder");
            DriverManager.registerDriver( new org.apache.derby.jdbc.EmbeddedDriver());
            
            
            con = DriverManager.getConnection(url);
            st = con.createStatement();
            
            //Use to drop a table
            //st.executeUpdate("DROP TABLE USER12.COURSEALLOCATION ");
            
            //Use to create a fresh table
            //st.executeUpdate("CREATE TABLE COURSEALLOCATION(ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY "
            //        + "(START WITH 1, INCREMENT BY 1),"
            //        + "COURSEID VARCHAR(15), CREDIT INT, CTYPE VARCHAR(15))");
            
            //st.executeUpdate("INSERT INTO CARS VALUES(1, 'Audi', 52642)");
            
            //st.executeUpdate("INSERT INTO COURSEALLOCATION(COURSEID, CREDIT, CTYPE)"
            //        + "VALUES( )")
            pst = con.prepareStatement("INSERT INTO COURSEALLOCATION(COURSEID, CREDIT, CTYPE)"
                    + "VALUES(?, ?, ?)"); 
            pst.setString(1, courseid);
            pst.setInt(2, credit);
            pst.setString(3, ctype);
            
            pst.executeUpdate();
            
            DriverManager.getConnection("jdbc:derby:;shutdown=true");

        } catch (SQLException ex) {
            
            Logger lgr = Logger.getLogger(DeanScreen2.class.getName());

            if (((ex.getErrorCode() == 50000)
                    && ("XJ015".equals(ex.getSQLState())))) {

                lgr.log(Level.INFO, "Derby shut down normally", ex);

            } else {

                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }

        } finally {

            try {

                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(DeanScreen2.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        
        
    }
    
    private void addButtonActionEvent(){
        courseAllocate();
        
        //selSemComboBox.setSelectedIndex(-1);
        selCorComboBox.setSelectedIndex(-1);
        selCredComboBox.setSelectedIndex(-1);
        selTypeComboBox.setSelectedIndex(-1);
        
    }
    
    private void finishButtonActionEvent(){
        mw.showCard("One");
    }
    
    public DeanScreen2(MainWindow mw) throws ClassNotFoundException{
        this.mw = mw;
        
        sem = "1314S";
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        titleLabel = new JLabel("Semester Course Registration");
        add(titleLabel);
        
        selSemLabel = new JLabel("Select semester:");
        add(selSemLabel);
        
        model = new DefaultComboBoxModel();  
        selSemComboBox = new JComboBox(model);
        add(selSemComboBox);
        
        model.addElement(sem);
        
        selCorLabel = new JLabel("Select Course Code:");
        add(selCorLabel);
        
        model2 = new DefaultComboBoxModel();  
        selCorComboBox = new JComboBox(model2);
        add(selCorComboBox);
      
        /*
        selCorComboBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                try {
                    selCorComboBoxActionListener();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DeanScreen2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
       */
        
        
        model2.addElement("Empty");
        readAndUpdateCorCodes();
        
        selCredLabel = new JLabel("Select credits:");
        add(selCredLabel);
        
        selCredComboBox = new JComboBox(new String[] {"2", "3", "4"});
        add(selCredComboBox);
        
        selTypeLabel = new JLabel("Select type of course:");
        add(selTypeLabel);
        
        selTypeComboBox = new JComboBox(new String[] {"Core", "Elective"});
        add(selTypeComboBox);
        
        addButton = new JButton("Add Course");
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                addButtonActionEvent();
            }
        });
        
        add(addButton);
        
        
        finishButton = new JButton("Finish");
        finishButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                finishButtonActionEvent();
            }
        });
        
        add(finishButton);
        
        
        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                backButtonActionEvent();
            }
        });
        
        add(backButton);
        selCorComboBox.setSelectedIndex(-1);
        selCredComboBox.setSelectedIndex(-1);
        selTypeComboBox.setSelectedIndex(-1);
    }
   
    
}
