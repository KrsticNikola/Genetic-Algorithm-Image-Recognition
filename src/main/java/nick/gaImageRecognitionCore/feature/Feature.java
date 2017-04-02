package nick.gaImageRecognitionCore.feature;

import nick.gaImageRecognitionCore.image.Rect;

public abstract class Feature {

    //debug
    private Rect positionInPicture;

    private final Float maxAllowedthreshold;
    private final Float minAllowedThreshold;
    private final Float weight;
//    protected Rectangle size;

    protected final FeatureType featureType;

    protected abstract void autoSetSize();
    
//    protected abstract Feature getScaledFeature(float scale);

//    protected Feature() {
//        autoSetSize();
//    }

    public Feature(float maxAllowedthreshold, float minAllowedThreshold, float weight, FeatureType featureType) {
//        this();
        this.minAllowedThreshold = minAllowedThreshold;
        this.maxAllowedthreshold = maxAllowedthreshold;
        this.weight = weight;
//        this.size = size;
        this.featureType = featureType;
//        this.rectangles = rectangles;
    }

    //debug
    public Feature(float threshold, float minAllowedThreshold, float weight, Rect positionInPicture, FeatureType featureType) {
        this(threshold, minAllowedThreshold, weight, featureType);
        this.positionInPicture = positionInPicture;
    }

    @Override
    public String toString() {
        return "Feature{" + "positionInPicture=" + positionInPicture + ", maxAllowedthreshold=" + maxAllowedthreshold + ", minAllowedThreshold=" + minAllowedThreshold + ", weight=" + weight  + ", featureType=" + featureType + '}';
    }


    @Override
    public boolean equals(Object obj) {
        Feature featu = (Feature) obj;
        if (this.positionInPicture == featu.getPositionInPicture()) {
            return true;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
    //    public void setMaxAllowedthreshold(float maxAllowedthreshold) {
//        this.maxAllowedthreshold = maxAllowedthreshold;
//    }


//    public void setWeight(float weight) {
//        this.weight = weight;
//    }

    public Rect getPositionInPicture() {
        return positionInPicture;
    }

    public void setPositionInPicture(Rect positionInPicture) {
        this.positionInPicture = positionInPicture;
    }

//    public Rectangle getSize() {
//        return size;
//    }

    public FeatureType getFeatureType() {
        return featureType;
    }

    public Float getMaxAllowedthreshold() {
        return maxAllowedthreshold;
    }

    public Float getMinAllowedThreshold() {
        return minAllowedThreshold;
    }

    public Float getWeight() {
        return weight;
    }
    
}
