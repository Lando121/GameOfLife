package app.game_logic.game_objects;

import app.game_logic.LifeEntityState;

public class LifeEntity extends GameObject {

    public LifeEntityState state;

    public LifeEntity(LifeEntityState state){
        this.state = state;
    }

    @Override
    public void update() {
    }

    @Override
    public void lateUpdate() {
    }

    public void setState(LifeEntityState state) {
        this.state = state;
    }
}
