/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package videostore;

import javax.swing.JFrame;

/**
 *
 * @author chander
 */
public class MainMenu extends javax.swing.JPanel {

    JFrame wind;
    public MainMenu(JFrame wind) {
        this.wind = wind;
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

        jLabel1 = new javax.swing.JLabel();
        manageCustButton = new javax.swing.JButton();
        mspButton = new javax.swing.JButton();
        transactButton = new javax.swing.JButton();

        jLabel1.setBackground(new java.awt.Color(242, 2, 2));
        jLabel1.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Video Store");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        manageCustButton.setText("Manage Customers");
        manageCustButton.setToolTipText("Add/Manage customers");
        manageCustButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCustButtonActionPerformed(evt);
            }
        });

        mspButton.setText("Manage Store Purchases");
        mspButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mspButtonActionPerformed(evt);
            }
        });

        transactButton.setText("Manage Transactions");
        transactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(transactButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageCustButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mspButton, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageCustButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mspButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(transactButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageCustButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageCustButtonActionPerformed
        CustRegScreen crs = new CustRegScreen(wind);
        wind.add(crs);
        setVisible(false);
    }//GEN-LAST:event_manageCustButtonActionPerformed

    private void mspButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mspButtonActionPerformed
        StorePurchaseScreen sps = new StorePurchaseScreen(wind);
        wind.add(sps);
        setVisible(false);
    }//GEN-LAST:event_mspButtonActionPerformed

    private void transactButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactButtonActionPerformed
        CustomerSelectScreen css = new CustomerSelectScreen(wind);  //wind);
        wind.add(css);
        setVisible(false);
    }//GEN-LAST:event_transactButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageCustButton;
    private javax.swing.JButton mspButton;
    private javax.swing.JButton transactButton;
    // End of variables declaration//GEN-END:variables
}
