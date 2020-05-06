package app;

public class LifeEntity {

    public LifeEntityState state;

    public LifeEntity(LifeEntityState state){
        this.state = state;
    }

    public void setState(LifeEntityState state) {
        this.state = state;
    }

    @Override
    public LifeEntity clone() {
        LifeEntity clone = new LifeEntity(state);
        return clone;
    }
}
