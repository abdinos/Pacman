package gameengine.gamecore;


import gameengine.graphicEngine.GraphicEngine;
import gameengine.graphicEngine.GraphicEntity;
import gameengine.iaengine.Score;
import gameengine.input.InputEngine;
import gameengine.physicsengine.Direction;
import gameengine.physicsengine.PhysicEntity;
import gameengine.physicsengine.PhysicsEngine;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GameCore {
    public GraphicEngine graphicEngine;
    public PhysicsEngine physicsEngine;
    private ArrayList<GenericEntity> genericEntities;
    private final int CONVERSION_UNIT;
    private InputEngine input;
    private Score score;

    public GameCore(int width, int height, int unit) {
        this.graphicEngine = new GraphicEngine(width, height);
        this.physicsEngine = new PhysicsEngine();
        this.genericEntities = new ArrayList<>();
        this.score= new Score("PLAYER",0);

        this.CONVERSION_UNIT = unit;
        this.input = new InputEngine(null, this.graphicEngine.getFrame(), this);
    }

    public InputEngine getInput() {
        return input;
    }

    public Score getScore() {
        return score;
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


    public GenericEntity getGenericFromPhysic(PhysicEntity physicEntity) {
        for (GenericEntity genericEntity : genericEntities) {
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

    public void removeGenericEntity(GenericEntity genericEntity) {
        if (genericEntity != null) {
            physicsEngine.removeEntity(genericEntity.getPhysicEntity());
            graphicEngine.removeEntity(genericEntity.getGraphicEntity());
            genericEntities.remove(genericEntity);
            getScore().setScore(score.getScore()+1);

        }
    }

    public HashMap<GenericEntity, ArrayList<GenericEntity>> computeCollisions() {

        HashMap<GenericEntity, ArrayList<GenericEntity>> collidingGenericEntities = new HashMap<>();
        HashMap<PhysicEntity, ArrayList<PhysicEntity>> collidingPhysicEntities = physicsEngine.getCollidedEntities();

        for (PhysicEntity physicEntity : collidingPhysicEntities.keySet()) {
            GenericEntity temp = getGenericFromPhysic(physicEntity);
            collidingGenericEntities.put(temp, new ArrayList<>());

            for (PhysicEntity collidingPhysicEntity : collidingPhysicEntities.get(physicEntity)) {
                collidingGenericEntities.get(getGenericFromPhysic(physicEntity)).add(getGenericFromPhysic(collidingPhysicEntity));
            }

        }
        return collidingGenericEntities;
    }

    public void refresh() {
        physicsEngine.predictPosition();
        for (PhysicEntity physicEntity : physicsEngine.getEntities()) {
            if (physicEntity.isMovable()) {
                GraphicEntity graphicEntity = getGenericFromPhysic(physicEntity).getGraphicEntity();
  //              System.out.println(graphicEntity.getX() + " " + graphicEntity.getY());
                graphicEntity.setX(physicEntity.getX());
                graphicEntity.setY(physicEntity.getY());
  //              System.out.println(graphicEntity.getX() + " " + graphicEntity.getY());
                System.out.println(getScore().getScore());
            }
        }
        graphicEngine.repaint();
    }

    public GenericEntity getPac() {
        for (GenericEntity entity : getGenericEntities()) {
            if (entity.getId() == 1991) {
                return entity;
            }
        }
        return null;
    }
    public void resolveCollision(GenericEntity entity){

        if(getPhysicsEngine().getCollidedEntities().containsKey(entity.getPhysicEntity())){
            for (PhysicEntity  fruit :getPhysicsEngine().getCollidedEntities().get(entity.getPhysicEntity())) {
                if (!fruit.isSolid() ) {
                    removeGenericEntity(getGenericFromPhysic(fruit));


                }
            }

        }

    }
}


