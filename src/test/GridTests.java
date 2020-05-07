package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;

import org.junit.Test;

import app.components.grid.model.Grid;
import app.components.grid.model.LifeState;

public class GridTests {

    @Test
    public void testGetNeighbours() {
        Grid grid = new Grid(3, 3);

        ArrayList<LifeState> topLeftNeighbours = grid.getNeighbours(0, 0);
        ArrayList<LifeState> topMidNeighbours = grid.getNeighbours(0, 1);
        ArrayList<LifeState> topRightNeighbours = grid.getNeighbours(0, 2);
        ArrayList<LifeState> midLeftNeighbours = grid.getNeighbours(1, 0);
        ArrayList<LifeState> midNeighbours = grid.getNeighbours(1, 1);
        ArrayList<LifeState> midRightNeighbours = grid.getNeighbours(1, 2);
        ArrayList<LifeState> botLeftNeighbours = grid.getNeighbours(2, 0);
        ArrayList<LifeState> botMidNeighbours = grid.getNeighbours(2, 1);
        ArrayList<LifeState> botRightNeighbours = grid.getNeighbours(2, 2);

        assertEquals(3, topLeftNeighbours.size());
        assertEquals(5, topMidNeighbours.size());
        assertEquals(3, topRightNeighbours.size());
        assertEquals(5, midLeftNeighbours.size());
        assertEquals(8, midNeighbours.size());
        assertEquals(5, midRightNeighbours.size());
        assertEquals(3, botLeftNeighbours.size());
        assertEquals(5, botMidNeighbours.size());
        assertEquals(3, botRightNeighbours.size());
    }

    @Test
    public void testGetNeighboursInvalidInput() {
        Grid grid = new Grid(2, 2);

        assertThrows(IllegalArgumentException.class, () -> {
            grid.getNeighbours(-1, 1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            grid.getNeighbours(2, 1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            grid.getNeighbours(1, -1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            grid.getNeighbours(1, 2);
        });
    }

    @Test
    public void testGetLifeState() {
        Grid grid = new Grid(2, 2);

        grid.setLifeState(0, 0, LifeState.ALIVE);
        grid.setLifeState(0, 1, LifeState.DEAD);
        grid.setLifeState(1, 0, LifeState.ALIVE);
        grid.setLifeState(1, 1, LifeState.DEAD);

        assertEquals(LifeState.ALIVE, grid.getLifeState(0, 0));
        assertEquals(LifeState.DEAD, grid.getLifeState(0, 1));
        assertEquals(LifeState.ALIVE, grid.getLifeState(1, 0));
        assertEquals(LifeState.DEAD, grid.getLifeState(1, 1));
    }

    @Test
    public void testGetLifeStateInvalidInput() {
        Grid grid = new Grid(2, 2);

        assertThrows(IllegalArgumentException.class, () -> {
            grid.getLifeState(-1, 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            grid.getLifeState(2, 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            grid.getLifeState(1, -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            grid.getLifeState(1, 2);
        });
    }

    @Test
    public void setLifeState() {
        Grid grid = new Grid(2, 2);

        grid.setLifeState(0, 0, LifeState.ALIVE);
        grid.setLifeState(0, 1, LifeState.DEAD);
        grid.setLifeState(1, 0, LifeState.ALIVE);
        grid.setLifeState(1, 1, LifeState.DEAD);

        assertEquals(LifeState.ALIVE, grid.getLifeState(0, 0));
        assertEquals(LifeState.DEAD, grid.getLifeState(0, 1));
        assertEquals(LifeState.ALIVE, grid.getLifeState(1, 0));
        assertEquals(LifeState.DEAD, grid.getLifeState(1, 1));

    }

    @Test
    public void testSetLifeStateInvalidInput() {
        Grid grid = new Grid(2, 2);

        assertThrows(IllegalArgumentException.class, () -> {
            grid.setLifeState(-1, 1, LifeState.ALIVE);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            grid.setLifeState(2, 1, LifeState.ALIVE);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            grid.setLifeState(1, -1, LifeState.ALIVE);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            grid.setLifeState(1, 2, LifeState.ALIVE);
        });
    }
}