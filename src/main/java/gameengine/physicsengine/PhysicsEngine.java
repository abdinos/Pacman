package gameengine.physicsengine;


import java.util.ArrayList;
import java.util.HashMap;

public class PhysicsEngine {
    public ArrayList<PhysicEntity> entities = new ArrayList<>();
    private int entitiesNumber = 0;
    private PhysicEntity sprite;
    HashMap<PhysicEntity, ArrayList<PhysicEntity>>collidedEntities = new HashMap<>();

    public PhysicsEngine(ArrayList<PhysicEntity> entities, int entitiesNumber, PhysicEntity sprite, HashMap<PhysicEntity, ArrayList<PhysicEntity>> collidedEntities) {
        this.entities = entities;
        this.entitiesNumber = entitiesNumber;
        this.sprite = sprite;
        this.collidedEntities = collidedEntities;
    }

    public PhysicsEngine() {
        this.entities= new ArrayList<>();
        this.entitiesNumber=0;
        this.collidedEntities=new HashMap<>();
    }

    public ArrayList<PhysicEntity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<PhysicEntity> entities) {
        this.entities = entities;
    }

    public void setEntitiesNumber(int entitiesNumber) {
        this.entitiesNumber = entitiesNumber;
    }

    public HashMap<PhysicEntity, ArrayList<PhysicEntity>> getCollidedEntities() {
        return collidedEntities;
    }

    public ArrayList<PhysicEntity> entitiesCollision(PhysicEntity entity){
        ArrayList<PhysicEntity> collidingentities = null;
        for (PhysicEntity physicEntity : entities){
              if(!entity.equals(physicEntity) && entity.getHitbox().intersects(physicEntity.getHitbox())){
                  if (collidingentities == null){
                      collidingentities = new ArrayList<>();
                  }
                  collidingentities.add(physicEntity);
              }

        }

        return collidingentities;
    }
    public void setcollisionData(){
        for (PhysicEntity physicEntity :entities){
           ArrayList<PhysicEntity> collisions = entitiesCollision(physicEntity);
           collidedEntities.put(physicEntity,collisions);
        }
    }

    public void predictPosition(){
        for (PhysicEntity physicEntity :entities){
            if (physicEntity.isMovable()){
                int previousX = physicEntity.getX();
                int previousY = physicEntity.getY();
                physicEntity.move();
                ArrayList<PhysicEntity> collisions = entitiesCollision(physicEntity);
                if (collisions!=null){
                    collidedEntities.put(physicEntity,collisions);
                    for (PhysicEntity collidingitem : collisions){
                        if (collidingitem.isSolid()){
                            physicEntity.setX(previousX);
                            physicEntity.setY(previousY);
                            break;
                        }
                    }

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

    public void checkCollidingEntities(){
        for (PhysicEntity entity : collidedEntities.keySet()){
            System.out.println("entity: "+ entity + " colliding entities: "+collidedEntities.get(entity));
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

    public void addEntity(PhysicEntity physicEntity){
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
