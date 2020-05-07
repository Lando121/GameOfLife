package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import app.components.grid.controller.GridController;
import app.components.grid.model.Grid;
import app.components.grid.model.LifeState;

public class GridControllerTests {
    
    @Test
    public void testGridControllerUpdate(){
        Grid grid = new Grid(3, 3);
        
        grid.setLifeState(0, 0, LifeState.ALIVE);
        grid.setLifeState(0, 1, LifeState.ALIVE);
        grid.setLifeState(0, 2, LifeState.ALIVE);
        grid.setLifeState(1, 0, LifeState.DEAD);
        grid.setLifeState(1, 1, LifeState.DEAD);
        grid.setLifeState(1, 2, LifeState.DEAD);
        grid.setLifeState(2, 0, LifeState.DEAD);
        grid.setLifeState(2, 1, LifeState.DEAD);
        grid.setLifeState(2, 2, LifeState.DEAD);

        GridController gridController = new GridController(grid);
        gridController.update();

        assertEquals(LifeState.DEAD, grid.getLifeState(0, 0));
        assertEquals(LifeState.ALIVE, grid.getLifeState(0, 1));
        assertEquals(LifeState.DEAD, grid.getLifeState(0, 2));
        assertEquals(LifeState.DEAD, grid.getLifeState(1, 0));
        assertEquals(LifeState.ALIVE, grid.getLifeState(1, 1));
        assertEquals(LifeState.DEAD, grid.getLifeState(1, 2));
        assertEquals(LifeState.DEAD, grid.getLifeState(2, 0));
        assertEquals(LifeState.DEAD, grid.getLifeState(2, 1));
        assertEquals(LifeState.DEAD, grid.getLifeState(2, 2));

    }
}