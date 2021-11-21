package src.main.java.PhysicsEngine;

import java.awt.*;


public class Entity {
    private double x;
    private double y;
    private double velocity;
    private Hitbox hitbox;
    private double size;


    public Entity(double x, double y, double speed,double size) {
        this.x = x;
        this.y = y;
        this.velocity = speed;
        this.size = size;
        this.hitbox = new Hitbox((int)x,(int)y,(int)size);

    }


    public Entity() {
        this.x = 0;
        this.y = 0;
        this.velocity = 0;
        this.hitbox = new Hitbox();
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

    public Hitbox getHitbox() {return hitbox;}


    public void setSpeed(double speed) {
        this.velocity = speed;
    }

    public double getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}