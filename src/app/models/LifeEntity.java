package app.models;

public class LifeEntity {

    public LifeEntityState state;

    public LifeEntity(LifeEntityState state){
        this.state = state;
    }

    public LifeEntity(LifeEntity original){
        this.state = original.state;
    }
}