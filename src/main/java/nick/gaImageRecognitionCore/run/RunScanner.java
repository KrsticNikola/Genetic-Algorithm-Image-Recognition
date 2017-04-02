/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.run;

import nick.gaImageRecognitionCore.feature.FoundWindow;
import nick.gaImageRecognitionCore.image.PictureScanner;
import nick.gaImageRecognitionCore.individual.Individual;
import nick.gaImageRecognitionCore.util.ConfigurationUtil;
import nick.gaImageRecognitionCore.util.IOUtil;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Nick
 */
public class RunScanner {
    public static void main(String[] args) {
        Individual[] ind = ConfigurationUtil.readConfigurationsFromFolder("C:\\Users\\Nick\\Desktop\\Development\\master_resursi\\configTest");
        BufferedImage imageForRecognition = IOUtil.readImage("cmu_0080.png");
        PictureScanner pictureScanner = new PictureScanner(imageForRecognition, ind);
        ArrayList<FoundWindow> foundWindows = pictureScanner.scannPicture();
        System.out.println("Found windows: " + foundWindows.size());
        IOUtil.writeFoundWindowToImage(imageForRecognition, foundWindows, "img1Rectangles");
    }
}
