package gameengine.gamecore;

import gameengine.graphicEngine.GraphicEntity;
import gameengine.physicsengine.PhysicEntity;

public class GenericEntity {
    private static int id_count = 0;
    private int id;
    PhysicEntity physicEntity;
    GraphicEntity graphicEntity;

    public GenericEntity( PhysicEntity physicEntity, GraphicEntity graphicEntity) {
        this.id = id_count++;
        this.physicEntity = physicEntity;
        this.graphicEntity = graphicEntity;
    }

    public int getId() {
        return id;
    }

    public PhysicEntity getPhysicEntity() {
        return physicEntity;
    }

    public void setPhysicEntity(PhysicEntity physicEntity) {
        this.physicEntity = physicEntity;
    }

    public GraphicEntity getGraphicEntity() {
        return graphicEntity;
    }

    public void setGraphicEntity(GraphicEntity graphicEntity) {
        this.graphicEntity = graphicEntity;
    }
}
