package gameengine.physicsengine;


public class Entity {
    private double x;
    private double y;
    private double width;
    private double height;
    private double velocity;
    private Directions direction;


    public Entity(double x, double y, double width, double height, double velocity, Directions direction) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocity = velocity;
        this.direction = direction;
    }


    public Entity() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
        this.velocity = 0;
        this.direction = null;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Directions getDirection() {
        return direction;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVelocity() {
        return velocity;
    }


    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setVelocity(double speed) {
        this.velocity = speed;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", velocity=" + velocity +
                ", direction=" + direction +
                '}';
    }

    public Directions getWantedDirection(Directions direction) {
        this.setDirection(direction);
        return this.direction;
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

    public void moveToWantedDirection(Directions direction) {
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
    public Entity newPosition(Directions direction){
        this.moveToWantedDirection(direction);
        return this;

    }

    public boolean collisionDetector(Entity collider) {
        if (this.getX() < collider.getX() + collider.getWidth() &&
                this.getX() + this.getWidth() > collider.getX() &&
                this.getY() < collider.getY() + collider.getHeight() &&
                this.getHeight() + this.getY() > collider.getY()) {
            // collision detected!
            System.out.println("there's collision");
            return true;

        } else {
            System.out.println("there's no collision");
            return false;
        }

    }
}