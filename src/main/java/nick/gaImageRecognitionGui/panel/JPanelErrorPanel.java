/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionGui.panel;

import java.awt.*;

/**
 *
 * @author Nick
 */
public class JPanelErrorPanel extends javax.swing.JPanel {

    
    /**
     * Creates new form JPanelErrorPanel
     */
    public JPanelErrorPanel() {
        initComponents();
        setPreferredSize(new Dimension(800, 50));
//        setLayout(new BorderLayout());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelErrorLabel = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(800, 50));
        setPreferredSize(new java.awt.Dimension(800, 50));

        jLabelErrorLabel.setForeground(new java.awt.Color(204, 0, 51));
        jLabelErrorLabel.setText("error label");
        jLabelErrorLabel.setFocusable(false);
        jLabelErrorLabel.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelErrorLabel)
                .addContainerGap(741, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelErrorLabel)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelErrorLabel;
    // End of variables declaration//GEN-END:variables
}
