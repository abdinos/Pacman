package gameengine.physicsengine;


import java.util.ArrayList;

public class PhysicsEngine {
    public ArrayList<PhysicEntity> entities = new ArrayList<>();
    private int entitiesNumber = 0;
    ArrayList<PhysicEntity> collidedEntities = new ArrayList<>();


    public void entitiesCollision(){
        for (int i = 0; i < entitiesNumber; i++){
            for (PhysicEntity physicEntity : entities){
                if (checkCollision(i))
                    collidedEntities.add(physicEntity);
            }
        }
    }
    public void moveentities() {
        for (int i = 0; i < entitiesNumber; i++) {
            for (PhysicEntity physicEntity : entities) {
                if (physicEntity.isMovable()) {
                    physicEntity.move();
                }
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

    public void checkPhysicalPrediction(PhysicEntity physicEntity, Direction directionX, Direction directionY) {
        for (int i = 0; i < getEntitiesNumber(); i++) {
            boolean predictionX = entities.get(i).getX() == physicEntity.newPosition(directionX).getX();
            boolean predictionY = entities.get(i).getY() == physicEntity.newPosition(directionY).getY();
            if (predictionX || predictionY)
                collidedEntities.add(physicEntity);
        }
    }

    public void checkCollidedEntities(){
        for (PhysicEntity collidingPhysicEntity : collidedEntities) {
            System.out.print(collidingPhysicEntity);
        }
    }

    public void checkEntities(){
        for (PhysicEntity physicEntity : entities) {
            System.out.print(physicEntity);
        }
    }

    public void removeEntity(PhysicEntity physicEntity){
        entities.remove(physicEntity);
        entitiesNumber--;
    }

    public void spawnEntity(PhysicEntity physicEntity){
        entities.add(physicEntity);
        entitiesNumber++;
    }
    public PhysicEntity getEntity(int nb){
        return entities.get(nb);
    }

    public int getEntitiesNumber(){
        return  entitiesNumber;
    }
}
