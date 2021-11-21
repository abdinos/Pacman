package PhysicsEngine;

import java.awt.*;
import java.awt.geom.Point2D;

public class Mouvements {
   private Entity entity;
   private Directions direction;

    public Mouvements(Entity entity, Directions direction) {
        this.entity = entity;
        this.direction = direction;
    }
    public void move(){
        switch (direction){
            case UP :
                entity.setY(entity.getY()+entity.getVelocity());
                break;
            case DOWN:
                entity.setY(entity.getY()-entity.getVelocity());
                break;
            case LEFT:
                entity.setX((entity.getX()-entity.getVelocity()));
                break;
            case RIGHT:
                entity.setX((entity.getX()+entity.getVelocity()));
                break;
            default:
             }
    }
}
