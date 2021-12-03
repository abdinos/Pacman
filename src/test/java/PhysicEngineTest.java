import engine.physicsengine.*;
import entity.IEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PhysicEngineTest {
    MovablePhysicsEngine physicsEngine = new MovablePhysicsEngine();
    IEntity physicEntity1 =  new StaticPhysicEntity(20,20,30,40);
    IEntity physicEntity2 = new StaticPhysicEntity(20,40,90,100);
    IEntity physicEntity3 = new StaticPhysicEntity(20,30,40,80);
    IEntity physicEntity4 = new StaticPhysicEntity(-80,-60,1,1);
    MovablePhysicEntity physicEntity5 = new MovablePhysicEntity(15,1,20,20,30, Direction.UP,true);
    @Test
    public void entitiesCollisionsTest(){
        physicsEngine.addEntity(physicEntity1);
        physicsEngine.addEntity(physicEntity2);
        physicsEngine.addEntity(physicEntity3);
        ArrayList<IEntity> collidingEntities = physicsEngine.entitiesCollision(physicEntity3);
        assertTrue(collidingEntities.contains(physicEntity2)&&collidingEntities.contains(physicEntity1)&& collidingEntities.size() ==2,"size "+collidingEntities.size()+" entities "+collidingEntities.toString());
    }
    @Test
    public void entitiesCollisionsTest2(){
        physicsEngine.addEntity(physicEntity1);
        physicsEngine.addEntity(physicEntity2);
        physicsEngine.addEntity(physicEntity3);
        physicsEngine.addEntity(physicEntity4);
        ArrayList<IEntity> collidingEntities = physicsEngine.entitiesCollision(physicEntity3);
        assertFalse(collidingEntities.contains(physicEntity2)&&collidingEntities.contains(physicEntity1)&& collidingEntities.contains(physicEntity4)&& collidingEntities.size() ==3,"size "+collidingEntities.size()+" entities "+collidingEntities.toString());
    }
    @Test
    public void setCollisionDataTest(){
        physicsEngine.addEntity(physicEntity1);
        physicsEngine.addEntity(physicEntity2);
        physicsEngine.addEntity(physicEntity3);
        physicsEngine.addEntity(physicEntity4);
        ArrayList<IEntity> collidingentities = new ArrayList<>();
        collidingentities.add(physicEntity1);
        collidingentities.add(physicEntity2);
        physicsEngine.setcollisionData();
        assertEquals(physicsEngine.entitiesCollision(physicEntity3),collidingentities);

    }
    @Test
    public void predictPositionTest(){
        physicsEngine.addEntity(physicEntity1);
        physicsEngine.addEntity(physicEntity2);
        physicsEngine.addEntity(physicEntity3);
        physicsEngine.addEntity(physicEntity4);
        physicsEngine.addEntity(physicEntity5);
        ArrayList<IEntity> collidingentities = new ArrayList<>();
        collidingentities.add(physicEntity1);
        collidingentities.add(physicEntity2);
        collidingentities.add(physicEntity3);
        physicsEngine.predictPosition();
        assertEquals(collidingentities,physicsEngine.getCollidedEntities().get(physicEntity5));
        assertTrue(physicEntity5.getX() == 15);
        assertTrue(physicEntity5.getY() == 1);
    }



}