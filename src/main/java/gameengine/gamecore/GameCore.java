package gameengine.gamecore;


import gameengine.graphicEngine.GraphicEngine;
import gameengine.graphicEngine.GraphicEntity;
import gameengine.physicsengine.Direction;
import gameengine.physicsengine.PhysicEntity;
import gameengine.physicsengine.PhysicsEngine;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GameCore {
    public GraphicEngine graphicEngine;
    public PhysicsEngine physicsEngine;
    private ArrayList<GenericEntity> genericEntities;
    private final int CONVERSION_UNIT;

    public GameCore(int width, int height, int unit) {
        this.graphicEngine = new GraphicEngine(width, height);
        this.physicsEngine = new PhysicsEngine();
        this.genericEntities = new ArrayList<>();
        this.CONVERSION_UNIT = unit;
    }

    public GraphicEngine getGraphicEngine() {
        return graphicEngine;
    }


    public PhysicsEngine getPhysicsEngine() {
        return physicsEngine;
    }

    public ArrayList<GenericEntity> getGenericEntities() {
        return genericEntities;
    }
    public GenericEntity getGenericFromPhysic(PhysicEntity physicEntity){
        for (GenericEntity genericEntity: genericEntities){
            if (genericEntity.getPhysicEntity().equals(physicEntity))
                return genericEntity;
        }
        return null;
    }

    public void addGenericEntity(int x, int y, int width, int height, int velocity, Direction direction, boolean isMovable, boolean isSolid, Image image) {
        EntityCreator entityCreator = new EntityCreator(x, y, width, height, velocity, direction, isMovable, isSolid, image, CONVERSION_UNIT);
        GenericEntity genericEntity = entityCreator.createEntity();
        genericEntities.add(genericEntity);
        physicsEngine.addEntity(genericEntity.getPhysicEntity());
        graphicEngine.addEntity(genericEntity.getGraphicEntity());


    }

    public void addGenericEntity(GenericEntity newGenericEntity) {
        GenericEntity genericEntity = newGenericEntity;
        genericEntities.add(genericEntity);
        physicsEngine.addEntity(genericEntity.getPhysicEntity());
        graphicEngine.addEntity(genericEntity.getGraphicEntity());
    }

    public void removeGenericEntity(GenericEntity genericEntity){
        physicsEngine.removeEntity(genericEntity.getPhysicEntity());
        graphicEngine.removeEntity(genericEntity.getGraphicEntity());
        genericEntities.remove(genericEntity);

    }
    public HashMap<GenericEntity,ArrayList<GenericEntity>> getCollidingEntities(){
        HashMap<GenericEntity,ArrayList<GenericEntity>> collidingGenericEntities = new HashMap<>();
        HashMap<PhysicEntity,ArrayList<PhysicEntity>> collidingPhysicEntities = physicsEngine.getCollidedEntities();
        for (PhysicEntity physicEntity :collidingPhysicEntities.keySet()){
            GenericEntity temp = getGenericFromPhysic(physicEntity);
            collidingGenericEntities.put(temp,new ArrayList<>());
            for (PhysicEntity collidingPhysicEntity : collidingPhysicEntities.get(physicEntity)){
                collidingGenericEntities.get(getGenericFromPhysic(physicEntity)).add(getGenericFromPhysic(collidingPhysicEntity));
            }

        }
        return collidingGenericEntities;
    }
    public void refresh(){
        physicsEngine.predictPosition();
        for (PhysicEntity physicEntity:physicsEngine.getEntities()){
            if (physicEntity.isMovable()){
                GraphicEntity graphicEntity = getGenericFromPhysic(physicEntity).getGraphicEntity();
                graphicEntity.setX(physicEntity.getX()*CONVERSION_UNIT);
                graphicEntity.setY(physicEntity.getY()*CONVERSION_UNIT);
            }
        }
        graphicEngine.repaint();
    }
}

