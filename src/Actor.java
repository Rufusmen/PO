import java.awt.*;
import java.awt.image.BufferedImage;

public class Actor {
    protected BufferedImage img;
    public Actor(){
        img = null;
    }

    public void draw(Graphics g, int y, int x){
        if(img!=null)g.drawImage(img, x*64, y*64, null);
    }
}
