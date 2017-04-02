/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.feature;

import nick.gaImageRecognitionCore.image.Rect;

/**
 *
 * @author Nick
 */
public class FeatureMiddleLeftRight extends Feature {

    private float left_val;
    private float right_val;
    private float middle_val;

    private Integer height;

    private Integer leftSideWidth;
    private Integer centerSideWidth;
    private Integer rightSideWidth;
    
    //this constructor required when auto generating features! 
    public FeatureMiddleLeftRight(float maxAllowedthreshold, float minAllowedThreshold, float weight, int leftSideWidth, int centerSideWidth, int rightSideWidth, int featureHeight) {
        super(maxAllowedthreshold, minAllowedThreshold, weight, FeatureType.MIDDLE_LEFT_RIGHT);
        this.leftSideWidth = leftSideWidth;
        this.centerSideWidth = centerSideWidth;
        this.rightSideWidth = rightSideWidth;
        this.height = featureHeight;
    }
    
    //this constructor required when loading config data 
    public FeatureMiddleLeftRight(float maxAllowedthreshold, float minAllowedThreshold, float weight, int leftSideWidth, int centerSideWidth, int rightSideWidth, int featureHeight,  Rect positionInPicture) {
        super(maxAllowedthreshold, minAllowedThreshold, weight, FeatureType.MIDDLE_LEFT_RIGHT);
        this.leftSideWidth = leftSideWidth;
        this.centerSideWidth = centerSideWidth;
        this.rightSideWidth = rightSideWidth;
        this.height = featureHeight;
        setPositionInPicture(positionInPicture);
    }

    //this constructor is used when extracting features, maybe will be irelevant?
    public FeatureMiddleLeftRight(float left_val, float right_val, float middle_val, float maxAllowedthreshold, float minAllowedThreshold, float weight, int leftSideWidth, int centerSideWidth, int rightSideWidth, int featureHeight) {
        super(maxAllowedthreshold, minAllowedThreshold, weight, FeatureType.MIDDLE_LEFT_RIGHT);
        this.left_val = left_val;
        this.right_val = right_val;
        this.middle_val = middle_val;
        this.leftSideWidth = leftSideWidth;
        this.centerSideWidth = centerSideWidth;
        this.rightSideWidth = rightSideWidth;
        this.height = featureHeight;
    }


    @Override
    protected void autoSetSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "FeatureMiddleLeftRight{" + "left_val=" + left_val + ", right_val=" + right_val + ", middle_val=" + middle_val + ", height=" + height + ", leftSideWidth=" + leftSideWidth + ", centerSideWidth=" + centerSideWidth + ", rightSideWidth=" + rightSideWidth + '}';
    }
    
    

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

    public float getMiddle_val() {
        return middle_val;
    }

    public void setMiddle_val(float middle_val) {
        this.middle_val = middle_val;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getLeftSideWidth() {
        return leftSideWidth;
    }

    public void setLeftSideWidth(Integer leftSideWidth) {
        this.leftSideWidth = leftSideWidth;
    }

    public Integer getCenterSideWidth() {
        return centerSideWidth;
    }

    public void setCenterSideWidth(Integer centerSideWidth) {
        this.centerSideWidth = centerSideWidth;
    }

    public Integer getRightSideWidth() {
        return rightSideWidth;
    }

    public void setRightSideWidth(Integer rightSideWidth) {
        this.rightSideWidth = rightSideWidth;
    }
    
    

}
