import gameengine.physicsengine.Direction;
import gameengine.physicsengine.PhysicEntity;
import gameengine.physicsengine.PhysicsEngine;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PhysicEngineTest {
    PhysicsEngine physicsEngine = new PhysicsEngine();
    PhysicEntity physicEntity1 =  new PhysicEntity(20,20,30,40,0,null,false,true);
    PhysicEntity physicEntity2 = new PhysicEntity(20,40,90,100,0,null,false,true);
    PhysicEntity physicEntity3 = new PhysicEntity(20,30,40,80,0,null,false,true);
    PhysicEntity physicEntity4 = new PhysicEntity(-80,-60,1,1,0,null,false,true);
    PhysicEntity physicEntity5 = new PhysicEntity(15,1,20,20,30, Direction.UP,true,true);
    @Test
    public void entitiesCollisionsTest(){
        physicsEngine.addEntity(physicEntity1);
        physicsEngine.addEntity(physicEntity2);
        physicsEngine.addEntity(physicEntity3);
        ArrayList<PhysicEntity> collidingEntities = physicsEngine.entitiesCollision(physicEntity3);
        assertTrue(collidingEntities.contains(physicEntity2)&&collidingEntities.contains(physicEntity1)&& collidingEntities.size() ==2,"size "+collidingEntities.size()+" entities "+collidingEntities.toString());
    }
    @Test
    public void entitiesCollisionsTest2(){
        physicsEngine.addEntity(physicEntity1);
        physicsEngine.addEntity(physicEntity2);
        physicsEngine.addEntity(physicEntity3);
        physicsEngine.addEntity(physicEntity4);
        ArrayList<PhysicEntity> collidingEntities = physicsEngine.entitiesCollision(physicEntity3);
        assertFalse(collidingEntities.contains(physicEntity2)&&collidingEntities.contains(physicEntity1)&& collidingEntities.contains(physicEntity4)&& collidingEntities.size() ==3,"size "+collidingEntities.size()+" entities "+collidingEntities.toString());
    }
    @Test
    public void setCollisionDataTest(){
        physicsEngine.addEntity(physicEntity1);
        physicsEngine.addEntity(physicEntity2);
        physicsEngine.addEntity(physicEntity3);
        physicsEngine.addEntity(physicEntity4);
        ArrayList<PhysicEntity> collidingentities = new ArrayList<>();
        collidingentities.add(physicEntity1);
        collidingentities.add(physicEntity2);
        physicsEngine.setcollisionData();
        assertEquals(physicsEngine.entitiesCollision(physicEntity3),collidingentities);

    }


}