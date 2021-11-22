import gameengine.physicsengine.Direction;
import gameengine.physicsengine.Entity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollisionTest {
    Entity entity1 = new Entity(3, 3, 15, 20, 20, null);
    Entity entity2 = new Entity(23, 23, 15, 25, 25, null);
    Entity entity3 = new Entity(50, 40, 20, 30, 0, null);

    @Test
    public void iscollidingTest() {
        entity1.moveToWantedDirection(Direction.RIGHT);
        entity1.moveToWantedDirection(Direction.UP);
        assertTrue(entity1.getHitbox().intersects(entity2.getHitbox()), entity1 + " " + entity2 );

    }
    @Test
    public void iscollidingTest3() {
        entity2.moveToWantedDirection(Direction.RIGHT);
        entity2.moveToWantedDirection(Direction.UP);
        assertTrue(entity2.getHitbox().intersects(entity3.getHitbox()), entity2 + " " + entity3 );

    }


    @Test
    public void isNotcollidingTest() {
        entity1.moveToWantedDirection(Direction.LEFT);
        entity1.moveToWantedDirection(Direction.DOWN);
        assertFalse(entity1.getHitbox().intersects(entity3.getHitbox()), entity1 + " " + entity3 );

    }

    @Test
    public void isNotcollidingTest2() {
        entity2.moveToWantedDirection(Direction.LEFT);
        entity2.moveToWantedDirection(Direction.DOWN);
        assertFalse(entity2.getHitbox().intersects(entity3.getHitbox()), entity2 + " " + entity3 );
    }
    @Test
    public void iscollidingTest2() {
        assertEquals(true, entity1.getHitbox().intersects(entity1.getHitbox()));

    }
}