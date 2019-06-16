import java.util.Random;

public class Enemy extends Actor{
    private int type,hp;

    public boolean moved;

    public Enemy(){
        super();
        moved = false;
        type = new Random().nextInt(2);
        if(type == 0){
            img = AssetLoader.enemy1;
            hp = 1;
        }
        else {
            img = AssetLoader.enemy2;
            hp = 2;
        }
    }

    @Override
    public boolean isHitable() {
        return true;
    }

    @Override
    public boolean isEnemy() {
        return true;
    }

    @Override
    public boolean hit() {
        hp--;
        if(hp==0)return true;
        else return false;
    }
}
