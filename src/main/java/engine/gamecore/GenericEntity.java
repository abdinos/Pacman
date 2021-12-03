package engine.gamecore;

import engine.graphicEngine.GraphicEntity;
import engine.physicsengine.Hitbox;
import engine.physicsengine.StaticPhysicEntity;
import entity.IEntity;

public class GenericEntity implements IEntity {
    private static int id_count = 0;
    private int id;
    IEntity physicEntity;
    GraphicEntity graphicEntity;

    public GenericEntity(IEntity physicEntity, GraphicEntity graphicEntity) {
        this.id = id_count++;
        this.physicEntity = physicEntity;
        this.graphicEntity = graphicEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IEntity getPhysicEntity() {
        return physicEntity;
    }

    public void setPhysicEntity(StaticPhysicEntity physicEntity) {
        this.physicEntity = physicEntity;
    }

    public GraphicEntity getGraphicEntity() {
        return graphicEntity;
    }

    public void setGraphicEntity(GraphicEntity graphicEntity) {
        this.graphicEntity = graphicEntity;
    }


    @Override
    public void setSolid(boolean solid) {
        getPhysicEntity().setSolid(solid);
    }

    @Override
    public Hitbox getHitbox() {
        return physicEntity.getHitbox();
    }

    @Override
    public boolean isSolid() {
        return physicEntity.isSolid();
    }

    @Override
    public void setX(int x) {
        getPhysicEntity().setX(x);

    }

    @Override
    public void setY(int x) {
        getPhysicEntity().setY(x);
    }
}
