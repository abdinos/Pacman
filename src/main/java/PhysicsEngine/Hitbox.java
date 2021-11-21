package PhysicsEngine;

import PhysicsEngine.Entity;

import java.awt.*;

public class Hitbox {
    private Rectangle hitbox;

    public Hitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }

    public Hitbox() {
        this.hitbox = new Rectangle();
    }
    public Hitbox(int x,int y, int size){
        this.hitbox = new Rectangle(x,y,size,size);
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }
    public void setHitbox(Entity entity) {
        this.hitbox = new Rectangle((int)entity.getX(),(int)entity.getY(),(int)entity.getSize(),(int)entity.getSize());

    }
    public static boolean collisionDetecter(Entity collider, Entity collidee) {
        if (collider.getHitbox().getHitbox().x < collidee.getHitbox().getHitbox().x+ collidee.getHitbox().getHitbox().getWidth()&&
                collider.getHitbox().getHitbox().x + collider.getHitbox().getHitbox().getWidth() > collidee.getHitbox().getHitbox().x &&
                collider.getHitbox().getHitbox().y < collidee.getHitbox().getHitbox().y + collidee.getHitbox().getHitbox().getHeight() &&
                collider.getHitbox().getHitbox().getHeight() + collider.getHitbox().getHitbox().y > collidee.getHitbox().getHitbox().y) {
            // collision detected!
            System.out.println("there's collision");
            return true;

        }
        else {
            System.out.println("there's no collision");
            return false;
        }

        }

}
