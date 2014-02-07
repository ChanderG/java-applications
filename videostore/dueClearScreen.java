
package videostore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class dueClearScreen extends javax.swing.JPanel {

    JFrame wind;
    int custId;
    
    int aid;
    int vid;
    
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
    long diffInMillies = date2.getTime() - date1.getTime();
    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }
    
    private void calcdues(){
        try {
            //duesLabel.setText("You have no dues.");
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            
            String url = "jdbc:derby:videostoredb;"; //create=true [user12 on USER12]";
            
            
            DriverManager.registerDriver( new org.apache.derby.jdbc.EmbeddedDriver());
            
            con = DriverManager.getConnection(url);
            pst = con.prepareStatement("SELECT * FROM USER12.CUSTOMERS WHERE ID = ?");
            
            pst.setInt(1, custId);
            
            rs = pst.executeQuery();
            if(rs == null){
                return;
            }
            
//            
//            while (rs.next()) {
//                System.out.print(rs.getInt("ID"));
//                System.out.print(" ");
//                System.out.println(rs.getString("CNAME"));
//                System.out.print(" ");
//                System.out.println(rs.getString("ADDRESS"));
//                System.out.print(" ");
//                System.out.print(rs.getInt("ARENTED"));
//                System.out.print(" ");
//                System.out.print(rs.getInt("VRENTED"));
//                System.out.print(" ");
//                
//                
//            }
            
            java.util.Date last = null;
            
            while(rs.next()){
            last = new Date(rs.getTimestamp("DATEOFRENT").getTime());
            aid = rs.getInt("ARENTED");
            vid = rs.getInt("VRENTED");
            }
            
            java.util.Date today = new java.util.Date();
            int noofdays = -1*(int)getDateDiff(today, last, TimeUnit.DAYS);
            
            
            if((aid == 0)&&(vid == 0)){
                textarea.append("You have no pending items.");
                return;
            }
            
            int p1 = 0,p2 = 0;
            int curra = 0,currv = 0;
            
            pst = con.prepareStatement("SELECT * FROM USER12.PURCHASES WHERE ITEMNO = ?");
            
            rs = null;
            pst.setInt(1, aid);
            rs = pst.executeQuery();
            while(rs.next()){
                p1 = rs.getInt("DRENTALCHARGE");
                curra = rs.getInt("NOOFCOPIES");
            }
            
            rs = null;
            pst.setInt(1, vid);
            rs = pst.executeQuery();
            while(rs.next()){
                p2 = rs.getInt("DRENTALCHARGE");
                currv = rs.getInt("NOOFCOPIES");
            }
            
            int cost = (p1 + p2)*noofdays;
           
            //JOptionPane.showMessageDialog(wind, "You have to pay: " + cost);
            
            //JOptionPane.showMessageDialog(wind, "You have to pay: " );
            
            pst = con.prepareStatement("UPDATE USER12.PURCHASES SET NOOFCOPIES = ?  WHERE ITEMNO = ?");
            
            pst.setInt(1,curra + 1);
            pst.setInt(2, aid);
            pst.executeUpdate();
            
            pst.setInt(1,currv + 1);
            pst.setInt(2, vid);
            pst.executeUpdate();
            
            
            
           
            textarea.append("Your details: \n"+
                              "Audio: " + aid + "\n" +
                              "Video: " + vid + "\n" +
                              "Taken on : " + last.toString() + "\n" +
                              "Returned on : " + today.toString() + "\n" +
                              "No of days : " + noofdays + "\n" +  
                              "Total Cost : " + cost + "\n");
            JOptionPane.showMessageDialog(wind, "You have to pay: " + cost);
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
                              
        } catch (SQLException ex) {
            //Logger.getLogger(dueClearScreen.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        catch(Exception E){
            return;
        }
        
    }
    
    public dueClearScreen(JFrame wind, String id){
        this.wind = wind;
        custId = Integer.parseInt(id);
        initComponents();
        titlelabel.setText("Due Payment for Customer: " + custId);
        //textarea.append("Hello");
        calcdues();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlelabel = new javax.swing.JLabel();
        duesLabel = new javax.swing.JLabel();
        proceedButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();

        titlelabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N

        proceedButton.setText("Proceed");
        proceedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedButtonActionPerformed(evt);
            }
        });

        textarea.setEditable(false);
        textarea.setColumns(20);
        textarea.setRows(5);
        jScrollPane1.setViewportView(textarea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(titlelabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(proceedButton)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(duesLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(titlelabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(duesLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(proceedButton)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void proceedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedButtonActionPerformed
        rentScreen rs = new rentScreen(wind, custId);
        wind.add(rs);
        setVisible(false);
    }//GEN-LAST:event_proceedButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel duesLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton proceedButton;
    private javax.swing.JTextArea textarea;
    private javax.swing.JLabel titlelabel;
    // End of variables declaration//GEN-END:variables
}
