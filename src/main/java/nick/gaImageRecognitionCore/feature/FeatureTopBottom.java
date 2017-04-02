package nick.gaImageRecognitionCore.feature;

import nick.gaImageRecognitionCore.image.Rect;

public class FeatureTopBottom extends Feature {

    private float top_val;
    private float botton_val;

    private Integer width;

    private Integer topSideHeight;
    private Integer bottomSideHeight;

    @Override
    protected void autoSetSize() {
//        size = new Rectangle(width, bottomSideHeight + topSideHeight);
    }

    private FeatureTopBottom() {
        super(0, 0, 0, null, FeatureType.TOP_BOTTOM);
    }

//    public FeatureTopBottom(float threshold, float weight) {
//        super(threshold, weight, FeatureType.TOP_BOTTOM);
//    }
//    private FeatureTopBottom(float maxAllowedthreshold, float minAllowedThreshold, float weight, Rectangle size) {
//        super(maxAllowedthreshold, minAllowedThreshold, weight, FeatureType.TOP_BOTTOM);
//    }

//    private FeatureTopBottom(float maxAllowedthreshold, float minAllowedThreshold, float weight, Rect positionInPicture) {
//        super(maxAllowedthreshold, minAllowedThreshold, weight, positionInPicture, FeatureType.TOP_BOTTOM);
//    }
    
     //this constructor required when auto generating features! 
    public FeatureTopBottom(float maxAllowedthreshold, float minAllowedThreshold, float weight, int topSideHeight, int bottomSideHeight, int featureWidth) {
        super(maxAllowedthreshold, minAllowedThreshold, weight, FeatureType.TOP_BOTTOM);
        this.topSideHeight = topSideHeight;
        this.bottomSideHeight = bottomSideHeight;
        this.width = featureWidth;
//        this.rightSideWidth = rightSideWidth;
    }
    
    //this constructor required when loading config data 
    public FeatureTopBottom(float maxAllowedthreshold, float minAllowedThreshold, float weight, int topSideHeight, int bottomSideHeight, int width,  Rect positionInPicture) {
        super(maxAllowedthreshold, minAllowedThreshold, weight, FeatureType.TOP_BOTTOM);
        this.topSideHeight = topSideHeight;
        this.bottomSideHeight = bottomSideHeight;
        this.width = width;
        setPositionInPicture(positionInPicture);
    }

    //this constructor is used when extracting features, maybe will be irelevant?
    public FeatureTopBottom(float top_val, float botton_val, float maxAllowedthreshold, float minAllowedThreshold, float weight, int topSideHeight, int bottomSideHeight, int featureWidth) {
        super(maxAllowedthreshold, minAllowedThreshold, weight, FeatureType.TOP_BOTTOM);
        this.top_val = top_val;
        this.botton_val = botton_val;
        this.topSideHeight = topSideHeight;
        this.bottomSideHeight = bottomSideHeight;
        this.width = featureWidth;
    }

    public float getTop_val() {
        return top_val;
    }

    public void setTop_val(float top_val) {
        this.top_val = top_val;
    }

    public float getBotton_val() {
        return botton_val;
    }

    public void setBotton_val(float botton_val) {
        this.botton_val = botton_val;
    }

    public Integer getTopSideHeight() {
        return topSideHeight;
    }

    public void setTopSideHeight(Integer topSideHeight) {
        this.topSideHeight = topSideHeight;
    }

    public Integer getBottomSideHeight() {
        return bottomSideHeight;
    }

    public void setBottomSideHeight(Integer bottomSideHeight) {
        this.bottomSideHeight = bottomSideHeight;
    }

    public Integer getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "FeatureTopBottom{" + "top_val=" + top_val + ", botton_val=" + botton_val + ", width=" + width + ", topSideHeight=" + topSideHeight + ", bottomSideHeight=" + bottomSideHeight + '}' + super.toString();
    }
    
    

}
