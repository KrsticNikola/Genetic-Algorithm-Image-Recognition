package nick.gaImageRecognitionCore.feature;

import nick.gaImageRecognitionCore.image.Rect;

public class FeatureFourSide extends Feature {

    private float top_left_val;
    private float top_right_val;
    private float bottom_left_val;
    private float bottom_right_val;

    private Integer topSideHeight;
    private Integer bottomSideHeight;
    private Integer leftSideWidth;
    private Integer rightSideWidth;

    @Override
    protected void autoSetSize() {
//        size = new Rectangle(leftSideWidth + rightSideWidth, bottomSideHeight + topSideHeight);
    }

    private FeatureFourSide() {
        super(0, 0, 0, null, FeatureType.FOUR_SIDE);
    }

//    private FeatureFourSide(float maxAllowedthreshold, float minAllowedThreshold, float weight, Rectangle size) {
//        super(maxAllowedthreshold, minAllowedThreshold, weight, FeatureType.FOUR_SIDE);
//    }

//    private FeatureFourSide(float maxAllowedthreshold, float minAllowedThreshold, float weight, Rect positionInPicture) {
//        super(maxAllowedthreshold, minAllowedThreshold, weight, positionInPicture, FeatureType.FOUR_SIDE);
//    }

    //this constructor required when auto generating features! 
    public FeatureFourSide(float maxAllowedthreshold, float minAllowedThreshold, float weight, int topSideHeight, int bottomSideHeight, int leftSideWidth, int rightSideWidth) {
        super(maxAllowedthreshold, minAllowedThreshold, weight, FeatureType.FOUR_SIDE);
        this.topSideHeight = topSideHeight;
        this.bottomSideHeight = bottomSideHeight;
        this.leftSideWidth = leftSideWidth;
        this.rightSideWidth = rightSideWidth;
    }
    
    //this constructor required when loading config data 
    public FeatureFourSide(float maxAllowedthreshold, float minAllowedThreshold, float weight, int topSideHeight, int bottomSideHeight, int leftSideWidth, int rightSideWidth, Rect positionInPicture) {
        super(maxAllowedthreshold, minAllowedThreshold, weight, FeatureType.FOUR_SIDE);
        this.topSideHeight = topSideHeight;
        this.bottomSideHeight = bottomSideHeight;
        this.leftSideWidth = leftSideWidth;
        this.rightSideWidth = rightSideWidth;
        setPositionInPicture(positionInPicture);
    }
    
    //this constructor is used when extracting features, maybe will be irelevant?
    public FeatureFourSide(float topLeft_val, float bottomLeft_val, float topRight_val, float bottomRight_val, float maxAllowedthreshold, float minAllowedThreshold, float weight, int topSideHeight, int bottomSideHeight, int leftSideWidth, int rightSideWidth) {
        super(maxAllowedthreshold, minAllowedThreshold, weight, FeatureType.FOUR_SIDE);
        this.top_left_val = topLeft_val;
        this.bottom_left_val = bottomLeft_val;
        this.top_right_val = topRight_val;
        this.bottom_right_val = bottomRight_val;
        this.topSideHeight = topSideHeight;
        this.bottomSideHeight = bottomSideHeight;
        this.leftSideWidth = leftSideWidth;
        this.rightSideWidth = rightSideWidth;
    }

    @Override
    public String toString() {
        return "FeatureFourSide{" + "top_left_val=" + top_left_val + ", top_right_val=" + top_right_val + ", bottom_left_val=" + bottom_left_val + ", bottom_right_val=" + bottom_right_val + ", topSideHeight=" + topSideHeight + ", bottomSideHeight=" + bottomSideHeight + ", leftSideWidth=" + leftSideWidth + ", rightSideWidth=" + rightSideWidth + '}' + super.toString();
    }

    public float getTop_left_val() {
        return top_left_val;
    }

    public void setTop_left_val(float top_left_val) {
        this.top_left_val = top_left_val;
    }

    public float getTop_right_val() {
        return top_right_val;
    }

    public void setTop_right_val(float top_right_val) {
        this.top_right_val = top_right_val;
    }

    public float getBottom_left_val() {
        return bottom_left_val;
    }

    public void setBottom_left_val(float bottom_left_val) {
        this.bottom_left_val = bottom_left_val;
    }

    public float getBottom_right_val() {
        return bottom_right_val;
    }

    public void setBottom_right_val(float bottom_right_val) {
        this.bottom_right_val = bottom_right_val;
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

    public Integer getLeftSideWidth() {
        return leftSideWidth;
    }

    public void setLeftSideWidth(Integer leftSideWidth) {
        this.leftSideWidth = leftSideWidth;
    }

    public Integer getRightSideWidth() {
        return rightSideWidth;
    }

    public void setRightSideWidth(Integer rightSideWidth) {
        this.rightSideWidth = rightSideWidth;
    }
}
