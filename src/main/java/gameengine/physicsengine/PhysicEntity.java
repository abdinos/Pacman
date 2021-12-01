package gameengine.physicsengine;
public class PhysicEntity {
    private int velocity;
    private Direction direction;
    private Hitbox hitbox;
    private boolean isMovable;
    private boolean isSolid;


    public PhysicEntity(int x,int y, int width , int height,int velocity, Direction direction, boolean isMovable,boolean isSolid) {
        this.velocity = velocity;
        this.direction = direction;
        this.hitbox = new Hitbox(x,y,width,height);
        this.isMovable = isMovable;
        this.isSolid = isSolid;
    }

    public PhysicEntity() {
        this.velocity = 0;
        this.direction = null;
        this.hitbox = new Hitbox();
        this.isMovable = false;
        this.isSolid = true;
    }

    public int getWidth() {
        return (int)hitbox.getWidth();
    }

    public int getHeight() {
        return (int) hitbox.getHeight();
    }

    public Direction getDirection() {return direction;}

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

    public int getVelocity() {
        return velocity;
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

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Hitbox getHitbox() {
        return hitbox;
    }

    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }

    public boolean isMovable() {
        return isMovable;
    }

    public void setMovable(boolean movable) {
        isMovable = movable;
    }

    @Override
    public String toString() {
        return "PhysicEntity{" +
                "velocity=" + velocity +
                ", direction=" + direction +
                ", hitbox=" + hitbox +
                ", isMovable=" + isMovable +
                ", isSolid=" + isSolid +
                '}';
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
    public PhysicEntity newPosition(Direction direction){
        this.moveToWantedDirection(direction);
        return this;

    }
}