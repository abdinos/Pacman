package gameengine.physicsengine;


import javafx.geometry.Point2D;

import java.util.ArrayList;

public class GameWorld {
    public ArrayList<Entity> entities = new ArrayList<>();
    private int entitiesNumber = 0;
    ArrayList<Entity> collidedEntities = new ArrayList<>();


    public void entitiesCollision(){
        for (int i = 0; i < entitiesNumber; i++){
            for (Entity entity : entities){
                if (checkCollision(i))
                    collidedEntities.add(entity);
            }
        }
    }
    public boolean checkCollision(int index){
        for (int i = 0;i<entities.size();i++){
            if (i != index && entities.get(index).getHitbox().intersects(entities.get(i).getHitbox()))
                return true;

        }
        return false;
    }

    public void checkPhysicalPrediction(Entity entity, Direction directionX, Direction directionY) {
        for (int i = 0; i < getEntitiesNumber(); i++) {
            boolean predictionX = entities.get(i).getX() == entity.newPosition(directionX).getX();
            boolean predictionY = entities.get(i).getY() == entity.newPosition(directionY).getY();
            if (predictionX || predictionY)
                collidedEntities.add(entity);
        }
    }

    public void checkCollidedEntities(){
        for (Entity collidingEntity : collidedEntities) {
            System.out.print(collidingEntity);
        }
    }

    public void checkEntities(){
        for (Entity entity : entities) {
            System.out.print(entity);
        }
    }

    public void removeEntity(Entity entity){
        entities.remove(entity);
        entitiesNumber--;
    }

    public void spawnEntity(Entity entity){
        entities.add(entity);
        entitiesNumber++;
    }
    public Entity getEntity(int nb){
        return entities.get(nb);
    }

    public int getEntitiesNumber(){
        return  entitiesNumber;
    }







}
