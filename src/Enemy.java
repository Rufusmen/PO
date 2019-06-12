import java.util.Random;

public class Enemy extends Actor {
    private int type;
    public Enemy(){
        super();
        type = new Random().nextInt(2);
        if(type == 0)img = AssetLoader.enemy1;
        else img = AssetLoader.enemy2;
    }
}
