package app.version2;

public class LifeEntity extends GameObject {

    public LifeEntityState state;

    public LifeEntity(LifeEntityState state){
        this.state = state;
    }

    @Override
    public void update() {
    }

    public void setState(LifeEntityState state) {
        this.state = state;
    }

    @Override
    public void lateUpdate() {
        // TODO Auto-generated method stub

    }
}
