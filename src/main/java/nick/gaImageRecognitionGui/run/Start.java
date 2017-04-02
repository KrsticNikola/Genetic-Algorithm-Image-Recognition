/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionGui.run;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nick
 */
public class Start {
    public static void main(String[] args) {
        JFrameStart jFrameStart = new JFrameStart();
        jFrameStart.setVisible(true);
        
         //logger infos..
        Logger root = Logger.getLogger("");
        root.setLevel(Level.INFO);
    }
}
