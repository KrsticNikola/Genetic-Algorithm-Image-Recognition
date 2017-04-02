package nick.gaImageRecognitionCore.image;

import nick.gaImageRecognitionCore.feature.Feature;
import nick.gaImageRecognitionCore.feature.FeatureType;
import nick.gaImageRecognitionCore.feature.FoundWindow;
import nick.gaImageRecognitionCore.gui.CustomComponent;
import nick.gaImageRecognitionCore.individual.Individual;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Nick
 */
public class PictureScanner {

	public IntegralImage getImageToScann() {
		return imageToScann;
	}

	public void setImageToScann(IntegralImage imageToScann) {
		this.imageToScann = imageToScann;
	}

	private final static Logger LOGGER = Logger.getLogger(PictureScanner.class.getName());

	private final int SCANN_WINDOW_SIZE_X = 19;
	private final int SCANN_WINDOW_SIZE_Y = 19;
	private final float DEFAULT_BASE_SCALE = 1;
	private final float DEFAULT_SCALE_INCREMENT = 1.25f;
	private final float DEFAULT_INCREMENT_SHIFT_WINDOW = 0.1f;

	private final boolean DRAW_FEATURES = false;

	// private Float minFeatureOccurrences;

	// private final int MIN_FEATURES_REQUIRED = 5;
	// private final int SLEEP_TIMER = 50;
	// private Rect foundRectangles;
	// private BufferedImage srcImage;

	// private final ArrayList<Feature> features;
	private final Individual[] individuals;


	private IntegralImage imageToScann;


	/**
	 * when using this constructor you will need to manually provide
	 * {@link PictureScanner.setIntegralImage(IntegralImage integralImage)}
	 * 
	 * scanning is done with method scannPicture(Float baseScale, Float
	 * scale_inc, Float increment)
	 * 
	 * @param features
	 * @param minFeatureOccurrencesPercentage
	 */
	public PictureScanner(Individual[] individuals ) {
		if (DRAW_FEATURES) {
			throw new IllegalArgumentException("Drawing of features not possible with this constructor!!");
		}
//		this.minFeatureOccurrences = minFeatureOccurrencesPercentage;
		this.individuals = individuals;
//		featureOccurrences = new HashMap<>();
		imageToScann = null;
//		populateFeatureOccurrences();
	}

	/**
	 * @param srcImage
	 *            will be converted to {@link IntegralImage}
	 * @param features
	 */
	public PictureScanner(BufferedImage srcImage, Individual[] individuals) {

		this.individuals = individuals;

		imageToScann = new IntegralImage(srcImage);
//		for (int i = 0; i < srcImages.length; i++) {
//			imagesToScann[i] = new IntegralImage(srcImages[i]);
//		}
	}

	public PictureScanner(IntegralImage srcImage, Individual[] individuals) {
		if (DRAW_FEATURES) {
			throw new IllegalArgumentException("Drawing of features not possible with this constructor!!");
		}
		this.individuals = individuals;
		imageToScann = srcImage;
	}

	CustomComponent gui;
	
	/**
	 * <a> call scannPicture(null, null, null)
	 * @return the list of rectangles containing searched objects, expressed in
	 *         pixels.
	 */
	public ArrayList<FoundWindow> scannPicture() { 
		return scannPicture(null, null, null);
	}


	/**
	 * Returns the list of detected objects in an image applying the Viola-Jones
	 * algorithm.
	 *
	 * The algorithm tests, from sliding windows on the image, of variable size,
	 * which regions should be considered as searched objects. Please see
	 * Wikipedia for a description of the algorithm.
	 *
	 * @param baseScale
	 *            The initial ratio between the window size and the Haar
	 *            classifier size (default 2).
	 * @param scale_inc
	 *            The scale increment of the window size, at each step (default
	 *            1.25).
	 * @param featureOccurrencesPercentage
	 * @param increment
	 *            The shift of the window at each sub-step, in terms of
	 *            percentage of the window size.
	 * @return the list of rectangles containing searched objects, expressed in
	 *         pixels.
	 */
	public ArrayList<FoundWindow> scannPicture(Float baseScale, Float scale_inc, Float increment) {


		if (individuals == null || individuals.length == 0) {
			throw new RuntimeException("Feature list can not be null nor emtpy when scanning image");
		}

		if (imageToScann == null) {
			throw new RuntimeException("source images can not be null when scannning image");
		}
		if (DRAW_FEATURES && gui == null) {
			gui = new CustomComponent();
			gui.display();
		}

		if (baseScale == null) {
			baseScale = DEFAULT_BASE_SCALE;
		}
		if (scale_inc == null) {
			scale_inc = DEFAULT_SCALE_INCREMENT;
		}
		if (increment == null) {
			increment = DEFAULT_INCREMENT_SHIFT_WINDOW;
		}
		// if (minFeatureReq == null) {
		// minFeatureReq = MIN_FEATURES_REQUIRED;
		// }

		// List<Rectangle> res = detector.getFaces(img.getAbsolutePath(), 1,
		// 1.25f, 0.1f,1,true);
		// int width = srcImage.getWidth();
		// int height = srcImage.getHeight();
		int width = imageToScann.getWidth();
		int height = imageToScann.getHeight();
		float maxScale = (Math.min((width + 0.f) / SCANN_WINDOW_SIZE_X, (height + 0.0f) / SCANN_WINDOW_SIZE_Y));
		ArrayList<FoundWindow> foundRectangles = new ArrayList<>();

		// FIXME scale <= maxScale changed from scale < maxScale
		for (float scale = baseScale; scale <= maxScale; scale *= scale_inc) {
			int step = (int) (scale * SCANN_WINDOW_SIZE_X * increment);
			int size = (int) (scale * SCANN_WINDOW_SIZE_X);

			for (int xPadding = 0; xPadding <= width - size; xPadding += step) {
				for (int yPadding = 0; yPadding <= height - size; yPadding += step) {
//					for (int i = 0; i < imagesToScann.length; i++) {
						boolean addWindow = true;
						for (int j = 0; j < individuals.length; j++) {
							
							//individual failed we will not continue
							if (addWindow == false) {
								break;
							}

							//hashmap counter
							HashMap<FeatureType, Integer> featureOccurrencesLocal = new HashMap<>();

							// int featureCounter = 0;
							// boolean passed = true;
							List<Feature> foundFeatures = new ArrayList<>();
							for (Feature feature : individuals[j].getFeatureList()) {

								double areaWeight = imageToScann.getSumFeatureWithPadding(feature, xPadding,
										yPadding, scale);

								double value = Math.abs(feature.getWeight() - areaWeight);

//                                                                LOGGER.log(Level.INFO, "value: {0}", value);
//                                                                LOGGER.log(Level.INFO, "feature.getMinAllowedThreshold(): {0}", feature.getMinAllowedThreshold());
//                                                                LOGGER.log(Level.INFO, "feature.getMaxAllowedthreshold(): {0}", feature.getMaxAllowedthreshold());
								if (value > feature.getMinAllowedThreshold()
										&& value <= feature.getMaxAllowedthreshold()) {
									foundFeatures.add(feature);
								}

								if (DRAW_FEATURES) {
									// throw new NotImplementedException("
									// Drawing features is not available ");
									// BufferedImage image =
									// cloneBufferedImage(srcImage);
									// Graphics2D g2 = image.createGraphics();
									// float thickness = 0.01F;
									// g2.setStroke(new BasicStroke(thickness));
									// g2.setColor(Color.red);
									// g2.drawRect(xPadding, yPadding, size,
									// size);
									// // LEFT_RIGHT
									// if (feature.getFeatureType() ==
									// FeatureType.LEFT_RIGHT) {
									// FeatureLeftRigth featurer =
									// (FeatureLeftRigth) feature;
									// // left rectangle
									// int minX = (int)
									// (feature.getPositionInPicture().getMinX()
									// * scale) + xPadding;
									// int minY = (int)
									// (feature.getPositionInPicture().getMinY()
									// * scale) + yPadding;
									// int maxX = (int) (minX +
									// featurer.getLeftSideWidth() * scale);
									// int maxY = (int) (minY +
									// feature.getPositionInPicture().getHeight()
									// * scale);
									//
									// // right rectangle
									// int maxXRight = (int) (maxX +
									// featurer.getRightSideWidth() * scale);
									// g2.drawRect(minX, minY, maxXRight - minX,
									// maxY - minY);
									// }
									//
									// if (feature.getFeatureType() ==
									// FeatureType.TOP_BOTTOM) {
									//
									// FeatureTopBottom featurer =
									// (FeatureTopBottom) feature;
									//
									// // top rectangle
									// int minX = (int)
									// (featurer.getPositionInPicture().getMinX()
									// * scale) + xPadding;
									// int minY = (int)
									// (featurer.getPositionInPicture().getMinY()
									// * scale) + yPadding;
									// int maxX = minX + (int)
									// (featurer.getPositionInPicture().getWidth()
									// * scale);
									// int maxY = minY + (int)
									// (featurer.getTopSideHeight() * scale);
									//
									// // down rectangle
									// int maxYBottom = maxY + (int)
									// (featurer.getBottomSideHeight() * scale);
									//
									// g2.drawRect(minX, minY, maxX - minX,
									// maxYBottom - minY);
									// }
									//
									// gui.updateImage(image);
								}

							}

							//check if minimum number of features are found
							if (foundFeatures.size() < individuals[j].getFeatureList().size() * individuals[j].getMinFeaturePercentage()) {
//                                                            LOGGER.log(Level.INFO, "foundFeatures size: {0}", foundFeatures.size());
//                                                            LOGGER.log(Level.INFO, "individuals[j].getFeatureList().size(): {0}", individuals[j].getFeatureList().size());
//                                                            LOGGER.log(Level.INFO, "individuals[j].getMinFeaturePercentage(): {0}", individuals[j].getMinFeaturePercentage());
								addWindow = false;
							}
							
							
						}
						if (addWindow) {
							foundRectangles.add(new FoundWindow(xPadding, yPadding, size, size, scale));
						}
//					}
				}
			}
		}

		return foundRectangles;

	}

	//this was used with drawing of features, do not delete it yet
	private BufferedImage cloneBufferedImage(BufferedImage imageToClone) {
		ColorModel cm = imageToClone.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = imageToClone.copyData(null);
		return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}


}
