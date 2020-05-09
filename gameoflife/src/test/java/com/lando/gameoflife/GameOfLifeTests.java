package com.lando.gameoflife;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.junit.jupiter.api.Test;

public class GameOfLifeTests {
    final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    final MockGameOfLife mockGameOfLife = new MockGameOfLife();
    final Runnable gameThread = new Runnable() {
        @Override
        public void run() {
            mockGameOfLife.run();
        }
    };

    @Test
    public void testGameOfLifeRun() throws InterruptedException {

        scheduler.execute(gameThread);
        Thread.sleep(mockGameOfLife.getDoubleUpdateIntervalInMilliseconds());
        mockGameOfLife.stop();

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