package engine.gamecore;


import engine.graphicEngine.GraphicEngine;
import engine.graphicEngine.GraphicEntity;
import engine.input.InputEngine;
import engine.physicsengine.*;
import engine.gameplay.GamePlay;
import entity.IEntity;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GameCore {
    private final GraphicEngine graphicEngine;
    private MovablePhysicsEngine movablePhysicsEngine;
    private StaticPhysicsEngine staticPhysicsEngine;
    private final ArrayList<IEntity> genericEntities;
    private final int CONVERSION_UNIT;
    private final InputEngine input;

    public GameCore(int width, int height, int unit) {
        this.graphicEngine = new GraphicEngine(width, height);
        this.staticPhysicsEngine=new StaticPhysicsEngine();
        this.genericEntities = new ArrayList<>();
        this.movablePhysicsEngine= new MovablePhysicsEngine();
        this.CONVERSION_UNIT = unit;
        this.input = new InputEngine(null, this.graphicEngine.getFrame(), this);
    }

    public InputEngine getInput() {
        return input;
    }

    public GraphicEngine getGraphicEngine() {
        return graphicEngine;
    }


    public MovablePhysicsEngine getMovablePhysicsEnginePhysicsEngine() {
        return movablePhysicsEngine;
    }
    public StaticPhysicsEngine getStaticPhysicsEngine(){return staticPhysicsEngine;}

    public ArrayList<IEntity> getGenericEntities() {
        return genericEntities;
    }


    public IEntity getGenericFromPhysic(IEntity physicEntity) {
        for (IEntity genericEntity : genericEntities) {
            if (genericEntity instanceof GenericEntity) {
                if ( ((GenericEntity) genericEntity).getPhysicEntity().equals(physicEntity))
                    return genericEntity;
            }
        }
        return null;
    }


    public void addGenericEntity(IEntity newGenericEntity) {
        IEntity genericEntity = newGenericEntity;
        if (genericEntity instanceof GenericEntity){
            genericEntities.add(genericEntity);
            if (((GenericEntity) genericEntity).getPhysicEntity() instanceof MovablePhysicEntity){
                movablePhysicsEngine.addEntity(((GenericEntity) genericEntity).getPhysicEntity());
                graphicEngine.addEntity(((GenericEntity) genericEntity).getGraphicEntity());
            }
            else {
                staticPhysicsEngine.addEntity(((GenericEntity) genericEntity).getPhysicEntity());
                graphicEngine.addEntity(((GenericEntity) genericEntity).getGraphicEntity());
            }

        }

    }

    public void removeGenericEntity(IEntity genericEntity) {
        if (genericEntity != null) {
            if (((GenericEntity)genericEntity).getPhysicEntity() instanceof MovablePhysicEntity){
                movablePhysicsEngine.removeEntity(((GenericEntity)genericEntity).getPhysicEntity());
            }
            else{
                staticPhysicsEngine.removeEntity(((GenericEntity)genericEntity).getPhysicEntity());
            }
            graphicEngine.removeEntity(((GenericEntity)genericEntity).getGraphicEntity());
            genericEntities.remove(genericEntity);

        }
    }

    public HashMap<GenericEntity, ArrayList<GenericEntity>> computeCollisions() {

        HashMap<GenericEntity, ArrayList<GenericEntity>> collidingGenericEntities = new HashMap<>();
        HashMap<IEntity, ArrayList<IEntity>> collidingPhysicEntities = movablePhysicsEngine.getCollidedEntities();

        for (IEntity entity : collidingPhysicEntities.keySet()) {
            GenericEntity temp = (GenericEntity) getGenericFromPhysic(entity);
            collidingGenericEntities.put(temp, new ArrayList<>());

            for (IEntity collidingPhysicEntity : collidingPhysicEntities.get(entity)) {
                collidingGenericEntities.get(getGenericFromPhysic(entity)).add((GenericEntity) getGenericFromPhysic(collidingPhysicEntity));
            }

        }
        return collidingGenericEntities;
    }

    public void refresh() {
        movablePhysicsEngine.predictPosition();
        for (IEntity physicEntity : movablePhysicsEngine.getEntities()) {

                GraphicEntity graphicEntity = ((GenericEntity)getGenericFromPhysic(physicEntity)).getGraphicEntity();
                System.out.println(graphicEntity.getX() + " " + graphicEntity.getY());
                graphicEntity.setX(((MovablePhysicEntity)physicEntity).getX());
                graphicEntity.setY(((MovablePhysicEntity)physicEntity).getY());
                System.out.println(graphicEntity.getX() + " " + graphicEntity.getY());

        }
        graphicEngine.repaint();
    }

    public GenericEntity getPac() {
        for (IEntity entity : getGenericEntities()) {
            if(entity instanceof GenericEntity){
                if (((GenericEntity)entity).getId() == 1991) {
                    return ((GenericEntity)entity);
            }

            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        GameCore gameCore = new GameCore(588, 588, 20);
        GamePlay gamePlay = new GamePlay(20, 20, 1, gameCore);
        gamePlay.generateMap("FinalMap.txt");
        gamePlay.resolveMap();
        gameCore.computeCollisions();
        gameCore.getInput().setSprite(gameCore.getPac());
        gameCore.refresh();
    }
}

