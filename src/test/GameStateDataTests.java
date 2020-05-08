package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;

import org.junit.Test;

import app.GameStateData;
import app.LifeState;

public class GameStateDataTests {

    @Test
    public void testGetNeighbours() {
        GameStateData gameStateData = new GameStateData(3, 3);

        ArrayList<LifeState> topLeftNeighbours = gameStateData.getNeighbours(0, 0);
        ArrayList<LifeState> topMidNeighbours = gameStateData.getNeighbours(0, 1);
        ArrayList<LifeState> topRightNeighbours = gameStateData.getNeighbours(0, 2);
        ArrayList<LifeState> midLeftNeighbours = gameStateData.getNeighbours(1, 0);
        ArrayList<LifeState> midNeighbours = gameStateData.getNeighbours(1, 1);
        ArrayList<LifeState> midRightNeighbours = gameStateData.getNeighbours(1, 2);
        ArrayList<LifeState> botLeftNeighbours = gameStateData.getNeighbours(2, 0);
        ArrayList<LifeState> botMidNeighbours = gameStateData.getNeighbours(2, 1);
        ArrayList<LifeState> botRightNeighbours = gameStateData.getNeighbours(2, 2);

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
        GameStateData gameStateData = new GameStateData(2, 2);

        assertThrows(IllegalArgumentException.class, () -> {
            gameStateData.getNeighbours(-1, 1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            gameStateData.getNeighbours(2, 1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            gameStateData.getNeighbours(1, -1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            gameStateData.getNeighbours(1, 2);
        });
    }

    @Test
    public void testGetLifeState() {
        GameStateData gameStateData = new GameStateData(2, 2);

        gameStateData.setLifeState(0, 0, LifeState.ALIVE);
        gameStateData.setLifeState(0, 1, LifeState.DEAD);
        gameStateData.setLifeState(1, 0, LifeState.ALIVE);
        gameStateData.setLifeState(1, 1, LifeState.DEAD);

        assertEquals(LifeState.ALIVE, gameStateData.getLifeState(0, 0));
        assertEquals(LifeState.DEAD, gameStateData.getLifeState(0, 1));
        assertEquals(LifeState.ALIVE, gameStateData.getLifeState(1, 0));
        assertEquals(LifeState.DEAD, gameStateData.getLifeState(1, 1));
    }

    @Test
    public void testGetLifeStateInvalidInput() {
        GameStateData gameStateData = new GameStateData(2, 2);

        assertThrows(IllegalArgumentException.class, () -> {
            gameStateData.getLifeState(-1, 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            gameStateData.getLifeState(2, 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            gameStateData.getLifeState(1, -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            gameStateData.getLifeState(1, 2);
        });
    }

    @Test
    public void testSetLifeState() {
        GameStateData gameStateData = new GameStateData(2, 2);

        gameStateData.setLifeState(0, 0, LifeState.ALIVE);
        gameStateData.setLifeState(0, 1, LifeState.DEAD);
        gameStateData.setLifeState(1, 0, LifeState.ALIVE);
        gameStateData.setLifeState(1, 1, LifeState.DEAD);

        assertEquals(LifeState.ALIVE, gameStateData.getLifeState(0, 0));
        assertEquals(LifeState.DEAD, gameStateData.getLifeState(0, 1));
        assertEquals(LifeState.ALIVE, gameStateData.getLifeState(1, 0));
        assertEquals(LifeState.DEAD, gameStateData.getLifeState(1, 1));

    }

    @Test
    public void testSetLifeStateInvalidInput() {
        GameStateData gameStateData = new GameStateData(2, 2);

        assertThrows(IllegalArgumentException.class, () -> {
            gameStateData.setLifeState(-1, 1, LifeState.ALIVE);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            gameStateData.setLifeState(2, 1, LifeState.ALIVE);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            gameStateData.setLifeState(1, -1, LifeState.ALIVE);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            gameStateData.setLifeState(1, 2, LifeState.ALIVE);
        });
    }
}