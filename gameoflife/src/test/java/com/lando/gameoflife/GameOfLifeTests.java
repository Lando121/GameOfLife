package com.lando.gameoflife;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Timer;
import java.util.TimerTask;

import org.junit.jupiter.api.Test;

public class GameOfLifeTests {

    @Test
    public void testGameOfLifeRun() {
        MockGameOfLife mockGameOfLife = new MockGameOfLife();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                mockGameOfLife.stop();
            }

        }, mockGameOfLife.getDoubleUpdateIntervalInMilliseconds());

        mockGameOfLife.run();
        assertEquals(true, mockGameOfLife.updated);
        assertEquals(true, mockGameOfLife.rendered);
    }

    private class MockGameOfLife extends GameOfLife {
        private boolean updated;
        private boolean rendered;

        @Override
        protected void updateGame() {
            updated = true;
        }

        @Override
        protected void renderGame() {
            rendered = true;
        }

        private int getDoubleUpdateIntervalInMilliseconds() {
            return 2 * (1000 / UPDATES_PER_SECOND);
        }
    }
}