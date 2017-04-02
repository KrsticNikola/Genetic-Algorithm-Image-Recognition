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
public abstract class BasePanel extends javax.swing.JPanel {

    protected final JPanelTopPanel topPanel;
    public BasePanel(JPanelTopPanel topPanel) {
//        Util.centreWindow(this);
//        initLabelValues();
        this.topPanel = topPanel;
        setDefaultSize();
    }
    
    /**
     * Label texts for each of panels
     */
    abstract void initLabelValues();
    
    protected final void setDefaultSize(){
        this.setPreferredSize(new Dimension(800, 600));
    }
    
}
