/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.feature;

import nick.gaImageRecognitionCore.image.Rect;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nick
 */
public class FoundWindow extends Rect {

	private ArrayList<Feature> features;
	private float scale;

	public FoundWindow(int minX, int minY, int width, int height, List<Feature> foundFeatures, float scale) {
		super(minX, minY, width, height);
		this.features = (ArrayList<Feature>) foundFeatures;
		this.scale = scale;
	}

	public FoundWindow(int minX, int minY, int width, int height, float scale) {
		super(minX, minY, width, height);
		this.scale = scale;
	}

	@Override
	public boolean equals(Object obj) {
		FoundWindow rect = (FoundWindow) obj;
		if (super.minX == rect.getMinX() && super.minY == rect.getMinY() && super.width == rect.getWidth()
				&& super.height == rect.getHeight() && scale == rect.getScale()) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		String hashCode = String.valueOf(this.scale + this.minX + this.minY + this.height + this.width);
		return hashCode.hashCode();
	}

	public ArrayList<Feature> getFeatures() {
		return features;
	}

	// public void setFeatures(ArrayList<Feature> features) {
	// this.features = features;
	// }

	public float getScale() {
		return scale;
	}

}
