/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionGui.panel;

import nick.gaImageRecognitionCore.feature.Feature;
import nick.gaImageRecognitionCore.image.Rect;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Nick
 */
public class JPanelPrintFeatures extends javax.swing.JPanel {

    private List<Feature> features;
    private final int SIZE_ZOOM = 15;

    /**
     * Creates new form JPanelPrintPanel
     */
    public JPanelPrintFeatures(List<Feature> features, int width, int height) {
        
        initComponents();
        this.features = features;

        int widthP = SIZE_ZOOM * width;
        int heightP = SIZE_ZOOM * height;

        setPreferredSize(new Dimension(widthP, heightP));
        setMaximumSize(new Dimension(widthP, heightP));
        setMinimumSize(new Dimension(widthP, heightP));
//        setBackground(new java.awt.Color(255, 255, 255));
//        setBorder(BorderFactory.createLineBorder(Color.black));
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(new java.awt.Dimension(100, 100));
        setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        final Random r = new Random();
        Color c;

        Graphics2D g2 = (Graphics2D) g;
//        g2.setColor(Color.BLACK);
        g2.setColor(Color.red);
//        g2.setStroke(new BasicStroke(5));
        g2.setStroke(new BasicStroke(0.1f));
//        g2.setStroke(new BasicStroke(0.01f));
//        g2.drawRect(WIDTH, WIDTH, WIDTH, WIDTH);
//        System.out.println("test");
        for (Feature feature : features) {
            Rect rect = feature.getPositionInPicture();
            c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256), r.nextInt(256));
            g2.setColor(c);
            g2.drawRect(SIZE_ZOOM * rect.getMinX(), SIZE_ZOOM * rect.getMinY(), SIZE_ZOOM * rect.getWidth(), SIZE_ZOOM * rect.getHeight());
//            System.out.println("Drawed");
        }
    }
}
