import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Player extends Actor {

    public Player(){
        super();
        img = AssetLoader.player;
        onAction = AssetLoader.hit;
    }


    @Override
    public boolean hit() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(onAction));
        clip.start();
        return false;
    }
}
