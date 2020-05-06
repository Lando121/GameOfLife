
package test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import app.rules.Evolution;
import app.utility.LifeEntityState;
public class EvolutionTests {
    
    @Test
    public void testAliveStateEvolution() {
        assertEquals(LifeEntityState.DEAD, Evolution.aliveStateRule(-1));
        assertEquals(LifeEntityState.DEAD, Evolution.aliveStateRule(0));
        assertEquals(LifeEntityState.DEAD, Evolution.aliveStateRule(1));
        assertEquals(LifeEntityState.ALIVE, Evolution.aliveStateRule(2));
        assertEquals(LifeEntityState.ALIVE, Evolution.aliveStateRule(3));
        assertEquals(LifeEntityState.DEAD, Evolution.aliveStateRule(4));
        assertEquals(LifeEntityState.DEAD, Evolution.aliveStateRule(5));
        assertEquals(LifeEntityState.DEAD, Evolution.aliveStateRule(6));
        assertEquals(LifeEntityState.DEAD, Evolution.aliveStateRule(7));
        assertEquals(LifeEntityState.DEAD, Evolution.aliveStateRule(8));
        assertEquals(LifeEntityState.DEAD, Evolution.aliveStateRule(9));
    }

    @Test
    public void testDeadStateEvolution() {
        assertEquals(LifeEntityState.DEAD, Evolution.deadStateRule(-1));
        assertEquals(LifeEntityState.DEAD, Evolution.deadStateRule(0));
        assertEquals(LifeEntityState.DEAD, Evolution.deadStateRule(1));
        assertEquals(LifeEntityState.DEAD, Evolution.deadStateRule(2));
        assertEquals(LifeEntityState.ALIVE, Evolution.deadStateRule(3));
        assertEquals(LifeEntityState.DEAD, Evolution.deadStateRule(4));
        assertEquals(LifeEntityState.DEAD, Evolution.deadStateRule(5));
        assertEquals(LifeEntityState.DEAD, Evolution.deadStateRule(6));
        assertEquals(LifeEntityState.DEAD, Evolution.deadStateRule(7));
        assertEquals(LifeEntityState.DEAD, Evolution.deadStateRule(8));
        assertEquals(LifeEntityState.DEAD, Evolution.deadStateRule(9));
    }
}
