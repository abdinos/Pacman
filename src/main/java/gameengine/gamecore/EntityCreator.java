package gameengine.gamecore;

import gameengine.graphicEngine.GraphicEntity;
import gameengine.physicsengine.Direction;
import gameengine.physicsengine.PhysicEntity;

import java.awt.*;

public class EntityCreator {
    private int x;
    private int y;
    private int width;
    private int height;
    private int velocity;
    private Direction direction;
    private boolean isMovable;
    private boolean isSolid;
    private Image image;
    private int conversionUnit;

    public EntityCreator(int x, int y, int width, int height, int velocity, Direction direction, boolean isMovable, boolean isSolid, Image image,int conversionUnit) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocity = velocity;
        this.direction = direction;
        this.isMovable = isMovable;
        this.isSolid = isSolid;
        this.image = image;
        this.conversionUnit = conversionUnit;
    }
    public GenericEntity createEntity(){
        GenericEntity entity = new GenericEntity(new PhysicEntity(x,y,width,height,velocity,direction,isMovable,isSolid),new GraphicEntity(x*conversionUnit,y*conversionUnit,image));
    return entity;
    }

}

