import engine.physicsengine.Direction;
import engine.physicsengine.MovablePhysicEntity;
import engine.physicsengine.StaticPhysicEntity;
import entity.IEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HitboxTest {
    MovablePhysicEntity physicEntity1 = new MovablePhysicEntity(3, 3, 15, 20, 20, null,true);
    MovablePhysicEntity physicEntity2 = new MovablePhysicEntity(23, 23, 15, 25, 25, null,true);
    StaticPhysicEntity physicEntity3 = new StaticPhysicEntity(50, 40, 20, 30);

    @Test
    public void iscollidingTest() {
        physicEntity1.moveToWantedDirection(Direction.RIGHT);
        physicEntity1.moveToWantedDirection(Direction.UP);
        assertTrue(physicEntity1.getHitbox().intersects(physicEntity2.getHitbox()), physicEntity1 + " " + physicEntity2);

    }
    @Test
    public void iscollidingTest2() {
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
    public void iscollidingTest4() {
        assertFalse(physicEntity1.getHitbox().intersects(physicEntity2.getHitbox()), physicEntity1 + " " + physicEntity2);

}
}
