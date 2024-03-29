/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Александр
 */
public class AboutFrame extends javax.swing.JFrame {
    private static int x;
    public static int y;
    /**
     * Creates new form AboutFrame
     */
    public AboutFrame() {
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

        aboutMainPanel = new javax.swing.JPanel();
        aboutFillerPanel = new javax.swing.JPanel();
        infoLabel = new javax.swing.JLabel();
        homeLabel = new javax.swing.JLabel();
        homeLinkLabel = new javax.swing.JLabel();
        aboutNameLabel = new javax.swing.JLabel();
        aboutButtonClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        aboutMainPanel.setBackground(new java.awt.Color(255, 204, 102));
        aboutMainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        aboutMainPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                aboutMainPanelMouseDragged(evt);
            }
        });
        aboutMainPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                aboutMainPanelMousePressed(evt);
            }
        });

        aboutFillerPanel.setBackground(new java.awt.Color(255, 255, 204));
        aboutFillerPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        infoLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        infoLabel.setForeground(new java.awt.Color(51, 51, 0));
        infoLabel.setText("Описание: Программа для контроля бронирования номеров отеля");

        homeLabel.setForeground(new java.awt.Color(51, 51, 0));
        homeLabel.setText("Домашний адрес: ");

        homeLinkLabel.setForeground(new java.awt.Color(51, 51, 0));
        homeLinkLabel.setText("  ");
        homeLinkLabel.setText("<html><a href=\"https://github.com/AlKulakov\">https://github.com/AlKulakov</a></html>");
        homeLinkLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeLinkLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeLinkLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeLinkLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout aboutFillerPanelLayout = new javax.swing.GroupLayout(aboutFillerPanel);
        aboutFillerPanel.setLayout(aboutFillerPanelLayout);
        aboutFillerPanelLayout.setHorizontalGroup(
            aboutFillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutFillerPanelLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(aboutFillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoLabel)
                    .addGroup(aboutFillerPanelLayout.createSequentialGroup()
                        .addComponent(homeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(homeLinkLabel)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        aboutFillerPanelLayout.setVerticalGroup(
            aboutFillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutFillerPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(infoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(aboutFillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeLabel)
                    .addComponent(homeLinkLabel))
                .addContainerGap(228, Short.MAX_VALUE))
        );

        aboutNameLabel.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        aboutNameLabel.setForeground(new java.awt.Color(51, 51, 0));
        aboutNameLabel.setText("О программе");

        aboutButtonClose.setBackground(new java.awt.Color(255, 204, 102));
        aboutButtonClose.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        aboutButtonClose.setForeground(new java.awt.Color(255, 255, 204));
        aboutButtonClose.setText("X");
        aboutButtonClose.setBorder(null);
        aboutButtonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutButtonCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutButtonCloseMouseExited(evt);
            }
        });
        aboutButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout aboutMainPanelLayout = new javax.swing.GroupLayout(aboutMainPanel);
        aboutMainPanel.setLayout(aboutMainPanelLayout);
        aboutMainPanelLayout.setHorizontalGroup(
            aboutMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutMainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aboutNameLabel)
                .addGap(208, 208, 208)
                .addComponent(aboutButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(aboutFillerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        aboutMainPanelLayout.setVerticalGroup(
            aboutMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aboutMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aboutButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aboutNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutFillerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aboutMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aboutMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonCloseActionPerformed
        MainForm.aboutFormCount--;
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_aboutButtonCloseActionPerformed

    private void aboutButtonCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonCloseMouseEntered
        aboutButtonClose.setBackground(Color.RED);    // TODO add your handling code here:
    }//GEN-LAST:event_aboutButtonCloseMouseEntered

    private void aboutButtonCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonCloseMouseExited
        aboutButtonClose.setBackground(new Color(255, 204, 102));
    }//GEN-LAST:event_aboutButtonCloseMouseExited

    private void aboutMainPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMainPanelMousePressed
        x = evt.getX();
        y = evt.getY();        // TODO add your handling code here:
    }//GEN-LAST:event_aboutMainPanelMousePressed

    private void aboutMainPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMainPanelMouseDragged
        this.setLocation(evt.getXOnScreen() - x, evt.getYOnScreen() - y);        // TODO add your handling code here:
    }//GEN-LAST:event_aboutMainPanelMouseDragged

    private void homeLinkLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeLinkLabelMouseEntered
        homeLinkLabel.setCursor(new Cursor(HAND_CURSOR));// TODO add your handling code here:
    }//GEN-LAST:event_homeLinkLabelMouseEntered

    private void homeLinkLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeLinkLabelMouseExited
        homeLinkLabel.setCursor(new Cursor(DEFAULT_CURSOR));        // TODO add your handling code here:
    }//GEN-LAST:event_homeLinkLabelMouseExited
private static class LinkRunner extends SwingWorker<Void, Void> {

    private final URI uri;

    private LinkRunner(URI u) {
        if (u == null) {
            throw new NullPointerException();
        }
        uri = u;
    }

    @Override
    protected Void doInBackground() throws Exception {
        Desktop desktop = java.awt.Desktop.getDesktop();
        desktop.browse(uri);
        return null;
    }

    @Override
    protected void done() {
        try {
            get();
        } catch (ExecutionException | InterruptedException ee) {
            handleException(uri, ee);
        }
    }

    private static void handleException(URI u, Exception e) {
        JOptionPane.showMessageDialog(null, "Sorry, a problem occurred while trying to open this link in your system's standard browser.", "A problem occured", JOptionPane.ERROR_MESSAGE);
    }
}
    private void homeLinkLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeLinkLabelMousePressed
        try {
            URI uri = new java.net.URI("https://github.com/AlKulakov");
            (new LinkRunner(uri)).execute();
        } catch (URISyntaxException use) {
            throw new AssertionError(use + ": " + homeLinkLabel.getText());
        }// TODO add your handling code here:
    }//GEN-LAST:event_homeLinkLabelMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AboutFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AboutFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AboutFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AboutFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AboutFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButtonClose;
    private javax.swing.JPanel aboutFillerPanel;
    private javax.swing.JPanel aboutMainPanel;
    private javax.swing.JLabel aboutNameLabel;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JLabel homeLinkLabel;
    private javax.swing.JLabel infoLabel;
    // End of variables declaration//GEN-END:variables
}
