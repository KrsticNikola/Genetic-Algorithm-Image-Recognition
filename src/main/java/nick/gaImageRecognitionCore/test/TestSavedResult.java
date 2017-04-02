/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.test;

import nick.gaImageRecognitionCore.individual.Individual;
import nick.gaImageRecognitionCore.util.ConfigurationUtil;
import nick.gaImageRecognitionCore.util.IOUtil;
import nick.gaImageRecognitionCore.util.ScannerUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author Nick
 */
public class TestSavedResult {

	public static void main(String[] args) {
//		String testFolder = "C:/Users/Nick/Documents/resources/ForTesting/face/";
//		String testFalsePositivesFolder = "C:/Users/Nick/Documents/resources/ForTesting/non-face/";
		String testFolder = "src/main/resources/ForTesting/face/";
		String testFalsePositivesFolder = "src/main/resources/ForTesting/non-face/";
		// ForTraining
		// ForTesting

		String configLocation = "src/main/resources/config/config.txt";
		String configLocation2 = "src/main/resources/config/config0.txt";
		Individual[] individualsFromConfig = ConfigurationUtil.readConfiguration(configLocation);
		Individual[] individualsFromConfig2 = ConfigurationUtil.readConfiguration(configLocation2);
		List<BufferedImage> faceImages = IOUtil.getImagesFromFolder(testFolder);
		List<BufferedImage> nonFaceImages = IOUtil.getImagesFromFolder(testFalsePositivesFolder);
		
		Individual[] individualsJoined = ArrayUtils.addAll(individualsFromConfig, individualsFromConfig2);
		
		BufferedImage[] faces = faceImages.toArray(new BufferedImage[faceImages.size()]);
		BufferedImage[] nonFaces = nonFaceImages.toArray(new BufferedImage[nonFaceImages.size()]);
		double foundPercentageFaces = ScannerUtil.scannImages(faces, individualsJoined);
		double foundPercentageNonFace = ScannerUtil.scannImages(nonFaces, individualsJoined);
		
		System.out.println("Test faces found: " + foundPercentageFaces);
		System.out.println("Test non faces found: " + foundPercentageNonFace);
		

	}
}
