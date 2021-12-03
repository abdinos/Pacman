package engine.physicsengine;

import entity.IEntity;
import entity.IMovableEntity;

public class MovablePhysicEntity implements IEntity, IMovableEntity {
    protected int velocity;
    protected Direction direction;
    private Hitbox hitbox;
    private boolean isSolid;

    public MovablePhysicEntity( int x, int y, int width, int height,int velocity, Direction direction, boolean isSolid) {
        this.velocity = velocity;
        this.direction = direction;
        this.hitbox = new Hitbox(x, y, width, height);
        this.isSolid = isSolid;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move() {
        switch (direction) {
            case UP -> this.setY(this.getY() - this.getVelocity());
            case DOWN -> this.setY(this.getY() + this.getVelocity());
            case LEFT -> this.setX((this.getX() - this.getVelocity()));
            case RIGHT -> this.setX((this.getX() + this.getVelocity()));
            default -> {
            }
        }
    }

    public void moveToWantedDirection(Direction direction) {
        this.setDirection(direction);
        this.move();
    }

    public MovablePhysicEntity newPosition(Direction direction) {
        this.moveToWantedDirection(direction);
        return this;

    }
    @Override
    public String toString() {
        return "PhysicEntity{" +
                "velocity=" + velocity +
                ", direction=" + direction +
                ", hitbox=" + hitbox +
                ", isSolid=" + isSolid +
                '}';
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


}
