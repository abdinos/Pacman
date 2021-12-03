package engine.physicsengine;


import entity.IEntity;

import java.util.ArrayList;
import java.util.HashMap;

public class StaticPhysicsEngine implements IPhysicsEngine {
    public ArrayList<IEntity> entities = new ArrayList<>();
    private int entitiesNumber = 0;
    private StaticPhysicEntity sprite;
    HashMap<StaticPhysicEntity, ArrayList<StaticPhysicEntity>> collidedEntities = new HashMap<>();

    public StaticPhysicsEngine(ArrayList<IEntity> entities, int entitiesNumber, StaticPhysicEntity sprite, HashMap<StaticPhysicEntity, ArrayList<StaticPhysicEntity>> collidedEntities) {
        this.entities = entities;
        this.entitiesNumber = entitiesNumber;
        this.sprite = sprite;
        this.collidedEntities = collidedEntities;
    }

    public StaticPhysicsEngine() {
        this.entities = new ArrayList<>();
        this.entitiesNumber = 0;
        this.collidedEntities = new HashMap<>();
    }

    @Override
    public ArrayList<IEntity> getEntities() {
        return entities;
    }

    @Override
    public void setEntities(ArrayList<IEntity> entities) {
        this.entities = entities;
    }

    @Override
    public void setEntitiesNumber(int entitiesNumber) {
        this.entitiesNumber = entitiesNumber;
    }


    @Override
    public void checkEntities() {
        for (IEntity physicEntity : entities) {
            System.out.print(physicEntity);
        }
    }

    @Override
    public void removeEntity(IEntity physicEntity) {
        entities.remove(physicEntity);
        entitiesNumber--;
    }

    @Override
    public void addEntity(IEntity physicEntity) {
        entities.add(physicEntity);
        entitiesNumber++;
    }

    public StaticPhysicEntity getEntity(int nb) {
        return (StaticPhysicEntity) entities.get(nb);
    }

    public int getEntitiesNumber() {
        return entitiesNumber;
    }
}
