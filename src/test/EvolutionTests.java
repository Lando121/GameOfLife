
package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import app.components.grid.model.LifeState;
import app.rules.Evolution;
public class EvolutionTests {

    @Test
    public void testAliveEvolutionRule() {
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.ALIVE, -1));
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.ALIVE, 0));
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.ALIVE, 1));
        assertEquals(LifeState.ALIVE, Evolution.getEvolutionStep(LifeState.ALIVE, 2));
        assertEquals(LifeState.ALIVE, Evolution.getEvolutionStep(LifeState.ALIVE, 3));
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.ALIVE, 4));
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.ALIVE, 5));
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.ALIVE, 6));
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.ALIVE, 7));
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.ALIVE, 8));
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.ALIVE, 9));
    }

    @Test
    public void testDeadEvolutionRule() {
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.DEAD, -1));
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.DEAD, 0));
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.DEAD, 1));
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.DEAD, 2));
        assertEquals(LifeState.ALIVE, Evolution.getEvolutionStep(LifeState.DEAD, 3));
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.DEAD, 4));
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.DEAD, 5));
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.DEAD, 6));
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.DEAD, 7));
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.DEAD, 8));
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.DEAD, 9));
        assertEquals(LifeState.DEAD, Evolution.getEvolutionStep(LifeState.DEAD, 9));

    }
}
