public class PickUP extends Actor {

    public PickUP(){
        super();
        img = AssetLoader.pickup;
    }

    @Override
    public boolean isPickup() {
        return true;
    }

    @Override
    public boolean hit() {
        return false;
    }
}
