package gameengine.physicsengine;


public class Entity {
    private double velocity;
    private Direction direction;
    private Hitbox hitbox;


    public Entity(double positionX, double positionY, double width, double height, double velocity, Direction direction) {

        this.velocity = velocity;
        this.direction = direction;
        this.hitbox = new Hitbox((int)positionX,(int)positionY,width,height);
    }


    public Entity() {
        this.velocity = 0;
        this.direction = null;
        this.hitbox = new Hitbox();
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

    public String toString() {
        return "Entity{" +
                "x=" + hitbox.getX() +
                ", y=" + hitbox.getY() +
                ", width=" + hitbox.getWidth() +
                ", height=" + hitbox.getHeight() +
                ", velocity=" + velocity +
                ", direction=" + direction +
                '}';
    }


    public void move() {
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
    }

    public void moveToWantedDirection(Direction direction) {
        this.setDirection(direction);
        this.move();
    }
    public Entity newPosition(Direction direction){
        this.moveToWantedDirection(direction);
        return this;

    }
}