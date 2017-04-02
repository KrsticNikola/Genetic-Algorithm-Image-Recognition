/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author Nick
 */
public class CustomComponent extends JFrame {

    private static final long serialVersionUID = 1L;
    
    CustomComponents cc;

    public CustomComponent() {
//        setTitle("Custom Component Graphics2D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void display() {
        cc = new CustomComponents();
        /*cc.addComponentListener(new java.awt.event.ComponentAdapter() {

         @Override
         public void componentResized(ComponentEvent event) {
         setSize(Math.min(getPreferredSize().width, getWidth()),
         Math.min(getPreferredSize().height, getHeight()));
         }
         });*/
        add(cc, BorderLayout.CENTER);

        CustomComponents cc1 = new CustomComponents();
        add(cc1, BorderLayout.EAST);

        pack();
        // enforces the minimum size of both frame and component
        setMinimumSize(getSize());
        //setMaximumSize(getMaximumSize());
        setVisible(true);

    }
    
    public void updateImage(BufferedImage image){
        cc.setSrc(image);
        cc.repaint();
    }

//    public static void main(String[] args) {
//        CustomComponent main = new CustomComponent();
//        main.display();
//    }
}
