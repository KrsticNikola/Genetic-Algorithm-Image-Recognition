/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.ga;

import nick.gaImageRecognitionCore.feature.FoundWindow;
import nick.gaImageRecognitionCore.image.IntegralImage;
import nick.gaImageRecognitionCore.image.PictureScanner;
import nick.gaImageRecognitionCore.individual.Individual;

import java.util.ArrayList;
import java.util.List;

/**
 * <a> Class which will use {@link Individual} with {@code positiveImages} and {@code falsePositiveImages} for generating {@link Fitness}
 *
 * @author Nick
 */

public class FitnessCalculation {

	private List<IntegralImage> trainingIntegralImages;

	private List<IntegralImage> falseIntegralImages;

	private static FitnessCalculation instance;

	private FitnessCalculation() {
	}

	public static FitnessCalculation getInstance() {
		if (instance == null) {
			instance = new FitnessCalculation();
		}
		return instance;
	}

	// Calculate inidividuals fittness by comparing it to our candidate solution
	public Fitness generateFitness(final Individual individual) {
		if (trainingIntegralImages == null || trainingIntegralImages.isEmpty()) {
			throw new RuntimeException("Failed operation, positive images null!");
		}
		if (falseIntegralImages == null || falseIntegralImages.isEmpty()) {
			throw new RuntimeException("Failed operation, false positive images null!");
		}
		Fitness fitness = new Fitness();
		fitness.setSizeOfPostitives(trainingIntegralImages.size());
		fitness.setSizeOfFailedPositives(falseIntegralImages.size());

		Individual ind = individual;

		// float minFeaturePercentage =
		// IndividualUtil.getMinFeaturePerecntage(ind.getIndividualType());

		PictureScanner pictureScanner = new PictureScanner(new Individual[] { ind });

		// handling of found features size?

		for (IntegralImage image : trainingIntegralImages) {
			pictureScanner.setImageToScann(image);
			ArrayList<FoundWindow> foundWindowsPositives = pictureScanner.scannPicture();
			if (!foundWindowsPositives.isEmpty()) {
				fitness.setNumberOfPostitives(fitness.getNumberOfPostitives() + 1);
			}
			// FIXME needs proper handling of sum of features, maybe average of
			// all windows is good way to go?
			// for (FoundWindow result : foundWindowsPositives) {
			//// result.getFeatures();
			//// fitness.setNumberOfFailedPositives(result.getFeatures().size());
			// fitness.setSumOfFeatures(result.getFeatures().size());
			// }

		}

		for (IntegralImage positiveImage : falseIntegralImages) {
			pictureScanner.setImageToScann(positiveImage);
			ArrayList<FoundWindow> foundWindowsFalsePositives = pictureScanner.scannPicture();
			if (!foundWindowsFalsePositives.isEmpty()) {
				fitness.setNumberOfFailedPositives(fitness.getNumberOfFailedPositives() + 1);
			}
		}

		return fitness;

	}

	public void setTrainingIntegralImages(List<IntegralImage> positiveImages) {
		this.trainingIntegralImages = positiveImages;
	}

	public void setFalseIntegralImages(List<IntegralImage> falsePositiveImages) {
		this.falseIntegralImages = falsePositiveImages;
	}
        
        
    public List<IntegralImage> getTrainingIntegralImages() {
        return trainingIntegralImages;
    }

    public List<IntegralImage> getFalseIntegralImages() {
        return falseIntegralImages;
    }

}
