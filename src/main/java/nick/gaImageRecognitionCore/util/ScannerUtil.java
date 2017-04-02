package nick.gaImageRecognitionCore.util;

import nick.gaImageRecognitionCore.feature.FoundWindow;
import nick.gaImageRecognitionCore.image.IntegralImage;
import nick.gaImageRecognitionCore.image.PictureScanner;
import nick.gaImageRecognitionCore.individual.Individual;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * @author Nick
 *
 */
public class ScannerUtil {

	/**
	 * <p>
	 * This method will return percentage of found images for selected
	 * individuals
	 * 
	 * @param images
	 *            for scanning
	 * @param individuals
	 *            to use in scanner
	 * @return
	 */
	public static double scannImages(IntegralImage[] images, Individual[] individuals) {
		int found = 0;

		for (IntegralImage image : images) {
			PictureScanner pictureScannerSelectedRectanglesPositives = new PictureScanner(image, individuals);
			ArrayList<FoundWindow> foundWindowsPositive = pictureScannerSelectedRectanglesPositives.scannPicture();
			if (!foundWindowsPositive.isEmpty()) {
				found++;
			}
		}

		int summary = images.length;
		float foundPercentage = (float) found / summary;
		System.out.println("Found samples: " + foundPercentage);
		return 0;

	}
	
	/**
	 * <p>
	 * This method will return percentage of found images for selected
	 * individuals
	 * 
	 * @param images
	 *            for scanning
	 * @param individuals
	 *            to use in scanner
	 * @return
	 */
	public static double scannImages(BufferedImage[] images, Individual[] individuals) {
		int found = 0;
		
		for (BufferedImage image : images) {
			PictureScanner pictureScannerSelectedRectanglesPositives = new PictureScanner(image, individuals);
			ArrayList<FoundWindow> foundWindowsPositive = pictureScannerSelectedRectanglesPositives.scannPicture();
			if (!foundWindowsPositive.isEmpty()) {
				found++;
			}
		}
		
		int summary = images.length;
		float foundPercentage = (float) found / summary;
//		System.out.println("Found samples: " + foundPercentage);
		return foundPercentage;
		
	}

}
