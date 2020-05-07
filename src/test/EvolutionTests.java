
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import app.components.grid.controller.Evolution;
import app.components.grid.model.LifeState;
public class EvolutionTests {

    @Test
    public void testAliveEvolutionRule() {
        assertEquals(LifeState.DEAD, Evolution.getNextGenerationState(LifeState.ALIVE, 0));
        assertEquals(LifeState.DEAD, Evolution.getNextGenerationState(LifeState.ALIVE, 1));
        assertEquals(LifeState.ALIVE, Evolution.getNextGenerationState(LifeState.ALIVE, 2));
        assertEquals(LifeState.ALIVE, Evolution.getNextGenerationState(LifeState.ALIVE, 3));
        assertEquals(LifeState.DEAD, Evolution.getNextGenerationState(LifeState.ALIVE, 4));
        assertEquals(LifeState.DEAD, Evolution.getNextGenerationState(LifeState.ALIVE, 5));
        assertEquals(LifeState.DEAD, Evolution.getNextGenerationState(LifeState.ALIVE, 6));
        assertEquals(LifeState.DEAD, Evolution.getNextGenerationState(LifeState.ALIVE, 7));
        assertEquals(LifeState.DEAD, Evolution.getNextGenerationState(LifeState.ALIVE, 8));
        assertEquals(LifeState.DEAD, Evolution.getNextGenerationState(LifeState.ALIVE, 9));
    }

    @Test
    public void testDeadEvolutionRule() {
        assertEquals(LifeState.DEAD, Evolution.getNextGenerationState(LifeState.DEAD, 0));
        assertEquals(LifeState.DEAD, Evolution.getNextGenerationState(LifeState.DEAD, 1));
        assertEquals(LifeState.DEAD, Evolution.getNextGenerationState(LifeState.DEAD, 2));
        assertEquals(LifeState.ALIVE, Evolution.getNextGenerationState(LifeState.DEAD, 3));
        assertEquals(LifeState.DEAD, Evolution.getNextGenerationState(LifeState.DEAD, 4));
        assertEquals(LifeState.DEAD, Evolution.getNextGenerationState(LifeState.DEAD, 5));
        assertEquals(LifeState.DEAD, Evolution.getNextGenerationState(LifeState.DEAD, 6));
        assertEquals(LifeState.DEAD, Evolution.getNextGenerationState(LifeState.DEAD, 7));
        assertEquals(LifeState.DEAD, Evolution.getNextGenerationState(LifeState.DEAD, 8));
        assertEquals(LifeState.DEAD, Evolution.getNextGenerationState(LifeState.DEAD, 9));
    }

    @Test
    public void testEvolutionInvalidInput(){
        assertThrows(IllegalArgumentException.class, () -> {
            Evolution.getNextGenerationState(LifeState.ALIVE, -1);
        });
    }
}
