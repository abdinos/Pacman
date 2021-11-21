package src.test.java;

import src.main.java.PhysicsEngine.Directions;
import src.main.java.PhysicsEngine.Entity;
import src.main.java. PhysicsEngine.Hitbox;
import src.main.java.PhysicsEngine.Mouvements;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollisionTest {
    Entity entity1 = new Entity(4,3,15,30);
    Entity entity2 = new Entity(23,23,15,50);
    Entity entity3 = new Entity(50,40,20,30);

    @Test
    public void iscollidingTest() {
        Mouvements mouvements1 = new Mouvements(entity1, Directions.RIGHT);
        Mouvements mouvements2 = new Mouvements(entity1, Directions.UP);
        assertEquals(true,Hitbox.collisionDetecter(entity1,entity2));

    }

}