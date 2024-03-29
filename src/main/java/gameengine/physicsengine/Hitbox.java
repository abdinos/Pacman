package gameengine.physicsengine;

import javafx.scene.shape.Rectangle;


public class Hitbox extends Rectangle {
   public Hitbox (int x, int y , int width , int height){
       super();
       setX(x);
       setY(y);
       setWidth(width);
       setHeight(height);
    }
    public Hitbox (){
        new Rectangle();}

    public boolean intersects(Hitbox other)
    {
        return this.getX() <= other.getX() + other.getWidth()-3 &&
                this.getX() + this.getWidth()-3 >= other.getX() &&
                this.getY() <= other.getY() + other.getHeight()-3 &&
                this.getHeight()-3 + this.getY() >= other.getY();
    }

    public void resize(float percent) {
        resize(getWidth()*percent, getHeight()*percent);
    }
    public void resize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    public void resizeCenter(float percent) {
        resizeCenter((int) (getWidth()*percent), (int) (getHeight()*percent));
    }

    public void resizeCenter(int width, int height)
    {
        double tempX = (getWidth()-width)/2;
        double tempY = (getHeight()-height)/2;
        resize(width, height);
        setX((int) (getX()+tempX));
        setY((int) (getY()+tempY));
    }


}