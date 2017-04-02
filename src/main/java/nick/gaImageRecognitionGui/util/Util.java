/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionGui.util;

import java.awt.*;
import java.util.prefs.Preferences;

/**
 *
 * @author Nick
 */
public class Util {

    /**
     * Set window location to center of monitor
     *
     * @param frame
     */
    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    public static void savePreferences(String key, String value) {
        // Retrieve the user preference node for the package com.mycompany
        Preferences prefs = Preferences.userNodeForPackage(nick.gaImageRecognitionGui.util.Util.class);

//        final String PREF_NAME = key;

        prefs.put(key, value);

    }
    
    public static String getPreferences(String key) {
         Preferences prefs = Preferences.userNodeForPackage(nick.gaImageRecognitionGui.util.Util.class);
        return prefs.get(key, null); // "a string"
    }
}
