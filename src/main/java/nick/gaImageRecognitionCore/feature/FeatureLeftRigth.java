package nick.gaImageRecognitionCore.feature;

import nick.gaImageRecognitionCore.image.Rect;

public class FeatureLeftRigth extends Feature {

    private float left_val;
    private float right_val;

    private Integer height;

    private Integer leftSideWidth;
    private Integer rightSideWidth;

    @Override
    protected void autoSetSize() {
//        size = new Rectangle(leftSideWidth + rightSideWidth, height);
    }

    private FeatureLeftRigth() {
        super(0, 0, 0, null, FeatureType.LEFT_RIGHT);
    }

//    public FeatureLeftRigth(float maxAllowedthreshold, float minAllowedThreshold, float weight, Rectangle size) {
//        super(maxAllowedthreshold, minAllowedThreshold, weight, FeatureType.LEFT_RIGHT);
//    }

//    public FeatureLeftRigth(float maxAllowedthreshold, float minAllowedThreshold, float weight, Rect positionInPicture) {
//        super(maxAllowedthreshold, minAllowedThreshold, weight, positionInPicture, FeatureType.LEFT_RIGHT);
//    }
    
    //this constructor required when auto generating features! 
    public FeatureLeftRigth(float maxAllowedthreshold, float minAllowedThreshold, float weight, int featureHeight, int leftSideWidth, int rightSideWidth) {
        super(maxAllowedthreshold, minAllowedThreshold, weight, FeatureType.LEFT_RIGHT);
        this.height = featureHeight;
        this.leftSideWidth = leftSideWidth;
        this.rightSideWidth = rightSideWidth;
    }
    
    //this constructor required when loading config data 
    public FeatureLeftRigth(float maxAllowedthreshold, float minAllowedThreshold, float weight, int leftSideWidth, int rightSideWidth, int height, Rect positionInPicture) {
        super(maxAllowedthreshold, minAllowedThreshold, weight, FeatureType.LEFT_RIGHT);
        this.leftSideWidth = leftSideWidth;
        this.rightSideWidth = rightSideWidth;
        this.height = height;
        setPositionInPicture(positionInPicture);
    }

    public FeatureLeftRigth(float left_val, float right_val, float maxAllowedthreshold, float minAllowedThreshold, float weight, int leftSideWidth, int rightSideWidth, int featureHeight) {
        super(maxAllowedthreshold, minAllowedThreshold, weight, FeatureType.LEFT_RIGHT);
        this.leftSideWidth = leftSideWidth;
        this.rightSideWidth = rightSideWidth;
        this.left_val = left_val;
        this.right_val = right_val;
        this.height = featureHeight;
    }

//    public FeatureLeftRigth(float left_val, float right_val, float threshold, float weight, Rect positionInPicture) {
//        super(threshold, weight, positionInPicture, FeatureType.LEFT_RIGHT);
//        this.left_val = left_val;
//        this.right_val = right_val;
//    }
    public float getLeft_val() {
        return left_val;
    }

    public void setLeft_val(float left_val) {
        this.left_val = left_val;
    }

    public float getRight_val() {
        return right_val;
    }

    public void setRight_val(float right_val) {
        this.right_val = right_val;
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

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "FeatureLeftRigth{" + "left_val=" + left_val + ", right_val=" + right_val + ", height=" + height + ", leftSideWidth=" + leftSideWidth + ", rightSideWidth=" + rightSideWidth + '}' + super.toString();
    }
    
    

}
