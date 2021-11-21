import gameengine.physicsengine.Directions;
import gameengine.physicsengine.Entity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollisionTest {
    Entity entity1 = new Entity(3,3,15,20,20,null);
    Entity entity2 = new Entity(23,23,15,20,20,null);
    Entity entity3 = new Entity(50,40,20,30,20,null);

    @Test
    public void iscollidingTest() {
        entity1.moveToWantedDirection(entity1.getWantedDirection(Directions.RIGHT));
        entity1.moveToWantedDirection(entity1.getWantedDirection(Directions.UP));
        assertEquals(true,entity1.collisionDetector(entity2));

    }
    @Test
    public void isNotcollidingTest() {
        entity1.moveToWantedDirection(entity1.getWantedDirection(Directions.LEFT));
        entity1.moveToWantedDirection(entity1.getWantedDirection(Directions.RIGHT));
        assertEquals(false,entity1.collisionDetector(entity3));

    }
    @Test
    public void isNotcollidingTest2() {
        entity1.moveToWantedDirection(entity2.getWantedDirection(Directions.LEFT));
        entity1.moveToWantedDirection(entity2.getWantedDirection(Directions.DOWN));
        assertEquals(false,entity2.collisionDetector(entity3));

    }

}