package gameengine.physicsengine;
public class PhysicEntity {
    private double velocity;
    private Direction direction;
    private Hitbox hitbox;
    private boolean isMovable;


    public PhysicEntity(double x,double y, double width , double height,double velocity, Direction direction, boolean isMovable) {
        this.velocity = velocity;
        this.direction = direction;
        this.hitbox = new Hitbox(x,y,width,height);
        this.isMovable = isMovable;
    }

    public PhysicEntity() {
        this.velocity = 0;
        this.direction = null;
        this.hitbox = new Hitbox();
        this.isMovable = false;
    }

    public double getWidth() {
        return hitbox.getWidth();
    }

    public double getHeight() {
        return hitbox.getHeight();
    }

    public Direction getDirection() {
        return direction;
    }

    public double getX() {
        return hitbox.getX();
    }

    public void setX(double x) {
        hitbox.setX(x);
    }

    public double getY() {
        return hitbox.getY();
    }

    public void setY(double y) {
        hitbox.setY(y);
    }

    public double getVelocity() {
        return velocity;
    }


    public void setWidth(double width) {
        hitbox.setWidth(width);
    }

    public void setHeight(double height) {
        hitbox.setHeight(height);
    }

    public void setVelocity(double speed) {
        this.velocity = speed;
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
                '}';
    }

    public void move() {
        if (this.isMovable())
            switch (direction) {
                case UP:
                    this.setY(this.getY() + this.getVelocity());
                    break;
                case DOWN:
                    this.setY(this.getY() - this.getVelocity());
                    break;
                case LEFT:
                    this.setX((this.getX() - this.getVelocity()));
                    break;
                case RIGHT:
                    this.setX((this.getX() + this.getVelocity()));
                    break;
                default:
            }
        else System.out.println("this object is not movable");
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