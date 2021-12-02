package gameengine.gamecore;


import gameengine.graphicEngine.GraphicEngine;
import gameengine.graphicEngine.GraphicEntity;
import gameengine.input.InputEngine;
import gameengine.physicsengine.Direction;
import gameengine.physicsengine.PhysicEntity;
import gameengine.physicsengine.PhysicsEngine;
import gameplay.GamePlay;

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

    public GameCore(int width, int height, int unit) {
        this.graphicEngine = new GraphicEngine(width, height);
        this.physicsEngine = new PhysicsEngine();
        this.genericEntities = new ArrayList<>();

        this.CONVERSION_UNIT = unit;
        this.input= new InputEngine(null,this.graphicEngine.getFrame(),this);
    }

    public InputEngine getInput() {
        return input;
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
    public HashMap<GenericEntity,ArrayList<GenericEntity>> computeCollisions(){

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
                System.out.println(graphicEntity.getX() +" "+ graphicEntity.getY());
                graphicEntity.setX(physicEntity.getX());
                graphicEntity.setY(physicEntity.getY());
                System.out.println(graphicEntity.getX() +" "+ graphicEntity.getY());
            }
        }
        graphicEngine.repaint();
    }

    public GenericEntity getPac(){
        for (GenericEntity entity:getGenericEntities()){
            if (entity.getId()==1991){
                return entity;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        GameCore gameCore = new GameCore(600,600,20);
        GenericEntity entity = new GenericEntity(new PhysicEntity(1,1,40,40,5,Direction.DOWN,true,true),new GraphicEntity(1  ,1, ImageIO.read(new File("src\\main\\resources\\Images\\PAC1.png")),40,40));
        GenericEntity entity1 = new GenericEntity(new PhysicEntity(400,400,40,70,2,null,false,true),new GraphicEntity(400,400, ImageIO.read(new File("src\\main\\resources\\Images\\WALL.png")),40,70));
       // gameCore.addGenericEntity(entity);
        //gameCore.addGenericEntity(entity1);
     GamePlay gamePlay = new GamePlay(29,20,1,gameCore);
     gamePlay.generateMap("FinalMap.txt");
     gamePlay.resolveMap();
     gameCore.computeCollisions();
     gameCore.getInput().setSprite(gameCore.getGenericEntities().get(0));
     gameCore.getInput().setSprite(gameCore.getPac());
     gameCore.refresh();
    }
}

