package gameplay;

import gameengine.graphicEngine.GraphicEntity;
import gameengine.physicsengine.PhysicEntity;

public class PacGum extends Game.GenericEntity {
    String use = "";
    int id= 0;



    public PacGum(PhysicEntity physicEntity, GraphicEntity graphicEntity) {
        super(physicEntity, graphicEntity);
    }


    public void setId(int id) {
        this.id = id;
    }

    public void set_Use(String use){
        this.use = use;
    }

    public boolean isColliding(PhysicEntity physicEntity) {
        return physicEntity.isMovable();
    }







}
