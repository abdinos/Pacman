package engine.gameplay;

public class BoxCollider {


    private final int minX;
    private final int maxX;
    private final int minY;
    private final int maxY;

    public BoxCollider(int minX, int maxX, int minY, int maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    public int[] getColliderBounds() {
        return new int[]{minX, maxX, minY, maxY};
    }

    public boolean isColliding(BoxCollider other) {
        return maxX > other.minX && minX < other.maxX && maxY > other.minY && minY < other.maxY;
    }


}
