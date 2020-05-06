
package test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import app.rules.Evolution;
import app.models.LifeEntityState;
public class EvolutionTests {

    @Test
    public void testAliveEvolutionRule() {
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.ALIVE, -1));
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.ALIVE, 0));
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.ALIVE, 1));
        assertEquals(LifeEntityState.ALIVE, Evolution.evolve(LifeEntityState.ALIVE, 2));
        assertEquals(LifeEntityState.ALIVE, Evolution.evolve(LifeEntityState.ALIVE, 3));
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.ALIVE, 4));
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.ALIVE, 5));
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.ALIVE, 6));
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.ALIVE, 7));
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.ALIVE, 8));
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.ALIVE, 9));
    }

    @Test
    public void testDeadEvolutionRule() {
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.DEAD, -1));
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.DEAD, 0));
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.DEAD, 1));
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.DEAD, 2));
        assertEquals(LifeEntityState.ALIVE, Evolution.evolve(LifeEntityState.DEAD, 3));
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.DEAD, 4));
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.DEAD, 5));
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.DEAD, 6));
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.DEAD, 7));
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.DEAD, 8));
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.DEAD, 9));
        assertEquals(LifeEntityState.DEAD, Evolution.evolve(LifeEntityState.DEAD, 9));

    }
}
