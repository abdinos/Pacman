package engine.gameplay;

import engine.gamecore.GenericEntity;
import engine.graphicEngine.GraphicEntity;
import engine.physicsengine.StaticPhysicEntity;

public class PacGum extends GenericEntity {
    String use = "";
    int id = 0;


    public PacGum(StaticPhysicEntity physicEntity, GraphicEntity graphicEntity) {
        super(physicEntity, graphicEntity);
    }


    public void setId(int id) {
        this.id = id;
    }

    public void set_Use(String use) {
        this.use = use;
    }




}
