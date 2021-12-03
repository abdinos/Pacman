package engine.physicsengine;

import entity.IEntity;

public class StaticPhysicEntity implements IEntity {
    private Hitbox hitbox;
    private boolean isSolid;


    public StaticPhysicEntity(int x, int y, int width, int height) {
        this.hitbox = new Hitbox(x, y, width, height);
        this.isSolid = true;
    }

    public StaticPhysicEntity() {
        this.hitbox = new Hitbox();
        this.isSolid = true;
    }

    public int getWidth() {
        return (int) hitbox.getWidth();
    }

    public int getHeight() {
        return (int) hitbox.getHeight();
    }

    public int getX() {
        return (int) hitbox.getX();
    }

    public void setX(int x) {
        hitbox.setX(x);
    }

    public int getY() {
        return (int) hitbox.getY();
    }

    public void setY(int y) {
        hitbox.setY(y);
    }

    public boolean isSolid() {
        return isSolid;
    }
    @Override
    public void setSolid(boolean solid) {
        isSolid = solid;
    }

    public void setWidth(double width) {
        hitbox.setWidth(width);
    }

    public void setHeight(double height) {
        hitbox.setHeight(height);
    }

    public Hitbox getHitbox() {
        return hitbox;
    }

    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }



    @Override
    public String toString() {
        return "PhysicEntity{" +
                ", hitbox=" + hitbox +
                ", isSolid=" + isSolid +
                '}';
    }

}