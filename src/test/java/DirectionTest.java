/**import engine.physicsengine.Direction;
import engine.physicsengine.StaticPhysicEntity;
import org.junit.jupiter.api.Test;

class DirectionTest {
    private StaticPhysicEntity testPhysicEntity1 = new StaticPhysicEntity(4, 3, 40,20,15,null,true,true);


    @Test
    public void rightMovementTest() {
        testPhysicEntity1.moveToWantedDirection(Direction.RIGHT);
        assertEquals(19, testPhysicEntity1.getX());

    }
    @Test
    public void leftMovementTest() {
        testPhysicEntity1.moveToWantedDirection(Direction.LEFT);
        assertEquals(-11, testPhysicEntity1.getX());
    }
    @Test
    public void upMovementTest() {
        testPhysicEntity1.moveToWantedDirection(Direction.UP);
        assertEquals(18, testPhysicEntity1.getY());
    }
    @Test
    public void downMovementTest() {
        testPhysicEntity1.moveToWantedDirection(Direction.DOWN);
        assertEquals(-12, testPhysicEntity1.getY());
    }


}*/