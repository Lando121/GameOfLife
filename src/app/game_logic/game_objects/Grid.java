package app.game_logic.game_objects;

import app.game_logic.LifeEntityState;

public class Grid extends GameObject {
    public static final int GRIDWIDTH = 100;
    public static final int GRIDHEIGHT = 101;
    private LifeEntityState nextState = LifeEntityState.ALIVE;

    public LifeEntity[][] gridOfLifeEntities;

    public Grid() 
    {
        gridOfLifeEntities = new LifeEntity[GRIDWIDTH][GRIDHEIGHT];

        for (int i = 0; i < GRIDWIDTH; i++) {
            for (int j = 0; j < GRIDHEIGHT; j++) {
                gridOfLifeEntities[i][j] = new LifeEntity(nextState);
                if(nextState == LifeEntityState.ALIVE){
                    nextState = LifeEntityState.DEAD;
                } else {
                    nextState = LifeEntityState.ALIVE;
                }
            }
        }
    }

    @Override
    public void update() {
        updateStateOfLifeEntities();
    }

    private void updateStateOfLifeEntities() {
        for (LifeEntity[] row : gridOfLifeEntities) {
            for (LifeEntity lifeEntity : row) {
                checkNeighbours(lifeEntity);
            }
        }
    }

    private void checkNeighbours(LifeEntity lifeEntity) {

    }

    @Override
    public void lateUpdate() {
    }

}