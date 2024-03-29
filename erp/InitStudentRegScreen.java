
package erp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InitStudentRegScreen extends javax.swing.JPanel {

    MainWindow mw;
    String name;
    String address;
    String eaddr;
    String phone;
    
    public void addStudentToDB(){
        name = nameTf.getText();
        address = addTf.getText();
        eaddr = eaddTf.getText();
        phone = phoneTf.getText();
    
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
            //st.executeUpdate("DROP TABLE USER12.STUDENTMASTER ");
            
            //Use to create a fresh table
            st.executeUpdate("CREATE TABLE STUDENTMASTER(ROLLNO INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY "
                    + "(START WITH 1, INCREMENT BY 1),"
                    + "ADDRESS VARCHAR(50), EADDRESS VARCHAR(20), PHONE VARCHAR(15))");
            
            //st.executeUpdate("INSERT INTO CARS VALUES(1, 'Audi', 52642)");
            
            pst = con.prepareStatement("INSERT INTO STUDENTMASTER(ADDRESS, EADDRESS, PHONE)"
                    + "VALUES(?, ?, ?)"); 
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, eaddr);
            pst.setString(4, phone);
            
            pst.executeUpdate();
            
            DriverManager.getConnection("jdbc:derby:;shutdown=true");

        } catch (SQLException ex) {
            
            Logger lgr = Logger.getLogger(InitStudentRegScreen.class.getName());

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
                Logger lgr = Logger.getLogger(InitStudentRegScreen.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        
        
    }        
            
    public InitStudentRegScreen(MainWindow mw) {
        this.mw = mw;
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameTf = new javax.swing.JTextField();
        addLabel = new javax.swing.JLabel();
        addTf = new javax.swing.JTextField();
        eaddLabel = new javax.swing.JLabel();
        eaddTf = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneTf = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        titleLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        titleLabel.setText("Student Registration Screen");

        nameLabel.setText("Enter Name:");

        nameTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTfActionPerformed(evt);
            }
        });

        addLabel.setText("Enter Address:");

        eaddLabel.setText("Enter Email address:");

        phoneLabel.setText("Enter Phone no:");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        submitButton.setText("Submit and Proceed");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(83, 83, 83))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(50, 50, 50)
                        .addComponent(clearButton)
                        .addGap(57, 57, 57)
                        .addComponent(submitButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(phoneLabel)
                            .addGap(18, 18, 18)
                            .addComponent(phoneTf))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(eaddLabel)
                            .addGap(18, 18, 18)
                            .addComponent(eaddTf))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(addLabel)
                            .addGap(18, 18, 18)
                            .addComponent(addTf))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(nameLabel)
                            .addGap(18, 18, 18)
                            .addComponent(nameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titleLabel)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addLabel)
                    .addComponent(addTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eaddLabel)
                    .addComponent(eaddTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(phoneTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(submitButton)
                    .addComponent(clearButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTfActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        mw.showCard("One");
    }//GEN-LAST:event_backButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        addStudentToDB();
        mw.showCard("One");
        nameTf.setText("");
        addTf.setText("");
        eaddTf.setText("");
        phoneTf.setText("");
    }//GEN-LAST:event_submitButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        nameTf.setText("");
        addTf.setText("");
        eaddTf.setText("");
        phoneTf.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addLabel;
    private javax.swing.JTextField addTf;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel eaddLabel;
    private javax.swing.JTextField eaddTf;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTf;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTf;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
