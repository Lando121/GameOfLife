
package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import app.components.grid.model.LifeEntityState;
import app.rules.Evolution;
public class EvolutionTests {

    @Test
    public void testAliveEvolutionRule() {
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.ALIVE, -1));
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.ALIVE, 0));
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.ALIVE, 1));
        assertEquals(LifeEntityState.ALIVE, Evolution.getEvolutionStep(LifeEntityState.ALIVE, 2));
        assertEquals(LifeEntityState.ALIVE, Evolution.getEvolutionStep(LifeEntityState.ALIVE, 3));
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.ALIVE, 4));
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.ALIVE, 5));
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.ALIVE, 6));
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.ALIVE, 7));
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.ALIVE, 8));
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.ALIVE, 9));
    }

    @Test
    public void testDeadEvolutionRule() {
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.DEAD, -1));
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.DEAD, 0));
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.DEAD, 1));
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.DEAD, 2));
        assertEquals(LifeEntityState.ALIVE, Evolution.getEvolutionStep(LifeEntityState.DEAD, 3));
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.DEAD, 4));
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.DEAD, 5));
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.DEAD, 6));
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.DEAD, 7));
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.DEAD, 8));
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.DEAD, 9));
        assertEquals(LifeEntityState.DEAD, Evolution.getEvolutionStep(LifeEntityState.DEAD, 9));

    }
}
