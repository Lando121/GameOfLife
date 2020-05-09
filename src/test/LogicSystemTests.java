package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import app.logic.LogicSystem;
import app.models.GameStateData;
import app.models.LifeState;

public class LogicSystemTests {
    
    @Test
    public void testLogicSystemUpdate(){
        GameStateData gameStateData = new GameStateData(3, 3);

        gameStateData.setLifeState(0, 0, LifeState.ALIVE);
        gameStateData.setLifeState(0, 1, LifeState.ALIVE);
        gameStateData.setLifeState(0, 2, LifeState.ALIVE);
        gameStateData.setLifeState(1, 0, LifeState.DEAD);
        gameStateData.setLifeState(1, 1, LifeState.DEAD);
        gameStateData.setLifeState(1, 2, LifeState.DEAD);
        gameStateData.setLifeState(2, 0, LifeState.DEAD);
        gameStateData.setLifeState(2, 1, LifeState.DEAD);
        gameStateData.setLifeState(2, 2, LifeState.DEAD);

        LogicSystem logicSystem = new LogicSystem(gameStateData);
        logicSystem.update();

        assertEquals(LifeState.DEAD, gameStateData.getLifeState(0, 0));
        assertEquals(LifeState.ALIVE, gameStateData.getLifeState(0, 1));
        assertEquals(LifeState.DEAD, gameStateData.getLifeState(0, 2));
        assertEquals(LifeState.DEAD, gameStateData.getLifeState(1, 0));
        assertEquals(LifeState.ALIVE, gameStateData.getLifeState(1, 1));
        assertEquals(LifeState.DEAD, gameStateData.getLifeState(1, 2));
        assertEquals(LifeState.DEAD, gameStateData.getLifeState(2, 0));
        assertEquals(LifeState.DEAD, gameStateData.getLifeState(2, 1));
        assertEquals(LifeState.DEAD, gameStateData.getLifeState(2, 2));
    }
}