import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Actor{
    protected BufferedImage img;
    protected File onAction;
    public Actor(){
        img = null;
        onAction = null;
    }

    public boolean isPickup(){return false;}

    public boolean isHitable(){return false;}

    public boolean isEnemy(){return false;}


    public void draw(Graphics g, int y, int x){
        if(img!=null)g.drawImage(img, x*64, y*64, null);
    }

    public  boolean hit() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        return false;
    };
}
