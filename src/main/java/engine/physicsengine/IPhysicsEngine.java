package engine.physicsengine;

import entity.IEntity;

import java.util.ArrayList;

public interface IPhysicsEngine {
    ArrayList<IEntity> getEntities();

    void setEntities(ArrayList<IEntity> entities);

    void setEntitiesNumber(int entitiesNumber);

    void checkEntities();

    void removeEntity(IEntity physicEntity);

    void addEntity(IEntity physicEntity);
}
