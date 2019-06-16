import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Actor{
    protected BufferedImage img;
    public Actor(){
        img = null;
    }

    public boolean isPickup(){return false;}

    public boolean isHitable(){return false;}

    public boolean isEnemy(){return false;}


    public void draw(Graphics g, int y, int x){
        if(img!=null)g.drawImage(img, x*64, y*64, null);
    }

    public  boolean hit(){
        return false;
    };
}
