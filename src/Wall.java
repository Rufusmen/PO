public class Wall extends Actor{

    private int hp;

    public Wall(){
        super();
        hp = 3;
        img = AssetLoader.wall1;
    }

    @Override
    public boolean isHitable() {
        return true;
    }

    @Override
    public boolean hit() {
        hp--;
        if(hp == 0)return true;
        return false;
    }
}
