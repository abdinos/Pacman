package engine.physicsengine;

import entity.IEntity;

import java.util.ArrayList;
import java.util.HashMap;

public class MovablePhysicsEngine implements IPhysicsEngine{
    public ArrayList<IEntity> entities = new ArrayList<>();
    private int entitiesNumber = 0;
    private MovablePhysicEntity sprite;
    HashMap<IEntity, ArrayList<IEntity>> collidedEntities = new HashMap<>();

    public MovablePhysicsEngine(ArrayList<IEntity> entities, int entitiesNumber, MovablePhysicEntity sprite, HashMap<IEntity, ArrayList<IEntity>> collidedEntities) {
        this.entities = entities;
        this.entitiesNumber = entitiesNumber;
        this.sprite = sprite;
        this.collidedEntities = collidedEntities;
    }

    public MovablePhysicsEngine() {
        this.entities = new ArrayList<>();
        this.entitiesNumber = 0;
        this.collidedEntities = new HashMap<>();
    }

    public ArrayList<IEntity> entitiesCollision(IEntity entity) {
        ArrayList<IEntity> collidingentities = null;
        for (IEntity physicEntity : entities) {
            if (!entity.equals(physicEntity) && entity.getHitbox().intersects(physicEntity.getHitbox())) {
                if (collidingentities == null) {
                    collidingentities = new ArrayList<>();
                }
                collidingentities.add(physicEntity);
            }

        }

        return collidingentities;
    }



    @Override
    public ArrayList<IEntity> getEntities() {
        return entities;
    }

    @Override
    public void setEntities(ArrayList<IEntity> entities) {
        this.entities = entities;
    }

    @Override
    public void setEntitiesNumber(int entitiesNumber) {
        this.entitiesNumber = entitiesNumber;
    }


    @Override
    public void checkEntities() {
        for (IEntity physicEntity : entities) {
            System.out.print(physicEntity);
        }
    }

    @Override
    public void removeEntity(IEntity physicEntity) {
        entities.remove(physicEntity);
        entitiesNumber--;
    }

    @Override
    public void addEntity(IEntity physicEntity) {
        entities.add(physicEntity);
        entitiesNumber++;
    }
    public HashMap<IEntity, ArrayList<IEntity>> getCollidedEntities() {
        return collidedEntities;
    }


    public void setcollisionData() {
        for (IEntity physicEntity : entities) {
            ArrayList<IEntity> collisions = entitiesCollision(physicEntity);
            collidedEntities.put(physicEntity, collisions);
        }
    }

    public void predictPosition() {
        for (IEntity physicEntity : entities) {
                int previousX = ((MovablePhysicEntity)physicEntity).getX();
                int previousY = ((MovablePhysicEntity)physicEntity).getY();
            ((MovablePhysicEntity)physicEntity).move();
                ArrayList<IEntity> collisions = entitiesCollision(physicEntity);
                if (collisions != null) {
                    collidedEntities.put(physicEntity, collisions);
                    for (IEntity collidingitem : collisions) {
                        if (collidingitem.isSolid()) {
                            physicEntity.setX(previousX);
                            physicEntity.setY(previousY);
                            break;
                        }
                    }

                }



        }
    }

    public boolean checkCollision(int index) {
        return false;
    }

    public void checkCollidingEntities() {
    }
}
