package nick.gaImageRecognitionCore.image;

public class Rect {
    
    protected final Integer minX;
	protected final Integer minY;
	protected final Integer width;
	protected final Integer height;

    public Rect(int minX, int minY, int width, int height) {
        this.minX = minX;
        this.minY = minY;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public String toString() {
        return "Rectangle [minX: " + minX + ", minY: " + minY + ", width: " + width + ", height: " + height + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        Rect rect = (Rect) obj;
        if (this.minX == rect.minX && this.minY == rect.minY && this.width == rect.width && this.height == rect.height) {
            return true;
        }
        return false;
    }

    public Integer getMinX() {
        return minX;
    }

    public Integer getMinY() {
        return minY;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }
    
}
