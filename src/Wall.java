import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Wall extends Actor{

    private int hp;

    public Wall(){
        super();
        hp = 3;
        img = AssetLoader.wall1;
        onAction = AssetLoader.chop;
    }

    @Override
    public boolean isHitable() {
        return true;
    }

    @Override
    public boolean hit() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(onAction));
        clip.start();
        hp--;
        if(hp == 2)img = AssetLoader.wall2;
        if(hp == 1)img = AssetLoader.wall3;
        if(hp == 0)return true;
        return false;
    }
}
