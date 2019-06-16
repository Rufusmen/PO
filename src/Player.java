public class Player extends Actor {

    public Player(){
        super();
        img = AssetLoader.player;
    }


    @Override
    public boolean hit() {
        return false;
    }
}
