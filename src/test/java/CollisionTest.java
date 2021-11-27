import gameengine.physicsengine.Direction;
import gameengine.physicsengine.PhysicEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollisionTest {
    PhysicEntity physicEntity1 = new PhysicEntity(3, 3, 15, 20, 20, null,true);
    PhysicEntity physicEntity2 = new PhysicEntity(23, 23, 15, 25, 25, null,true);
    PhysicEntity physicEntity3 = new PhysicEntity(50, 40, 20, 30, 0, null,false);

    @Test
    public void iscollidingTest() {
        physicEntity1.moveToWantedDirection(Direction.RIGHT);
        physicEntity1.moveToWantedDirection(Direction.UP);
        assertTrue(physicEntity1.getHitbox().intersects(physicEntity2.getHitbox()), physicEntity1 + " " + physicEntity2);

    }
    @Test
    public void iscollidingTest3() {
        physicEntity2.moveToWantedDirection(Direction.RIGHT);
        physicEntity2.moveToWantedDirection(Direction.UP);
        assertTrue(physicEntity2.getHitbox().intersects(physicEntity3.getHitbox()), physicEntity2 + " " + physicEntity3);

    }


    @Test
    public void isNotcollidingTest() {
        physicEntity1.moveToWantedDirection(Direction.LEFT);
        physicEntity1.moveToWantedDirection(Direction.DOWN);
        assertFalse(physicEntity1.getHitbox().intersects(physicEntity3.getHitbox()), physicEntity1 + " " + physicEntity3);

    }

    @Test
    public void isNotcollidingTest2() {
        physicEntity2.moveToWantedDirection(Direction.LEFT);
        physicEntity2.moveToWantedDirection(Direction.DOWN);
        assertFalse(physicEntity2.getHitbox().intersects(physicEntity3.getHitbox()), physicEntity2 + " " + physicEntity3);
    }
    @Test
    public void iscollidingTest2() {
        assertEquals(true, physicEntity1.getHitbox().intersects(physicEntity1.getHitbox()));

    }
}