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
public class CustomComponents extends JComponent {

    private static final long serialVersionUID = 1L;
    
    private BufferedImage src;

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(100, 100);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(800, 600);
    }

    @Override
    public void paintComponent(Graphics g) {
        if (src != null) {
            g.drawImage(src, 0, 0, this);
//            g.dispose();

        }
        
        
//        int margin = 10;
//        Dimension dim = getSize();
//        super.paintComponent(g);
//        g.setColor(Color.red);
//        g.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin * 2);
    }

    public BufferedImage getSrc() {
        return src;
    }

    public void setSrc(BufferedImage src) {
        this.src = src;
    }
}
