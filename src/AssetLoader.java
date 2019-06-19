import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AssetLoader {
    public static BufferedImage bg,player,enemy1,enemy2,pickup,wall1,wall2,wall3;
    public static File chop,hit,enemyHit;
    private static File pick;

    private AssetLoader(){
        try {
            AudioInputStream musicStream = AudioSystem.getAudioInputStream(new File("music.aif"));
            hit =new File("hit.aif");
            chop = new File("chop.wav");
            pick = new File("pick.aif");
            enemyHit = new File("zombie.wav");
            Clip music = AudioSystem.getClip();
            music.open(musicStream);
            music.loop(Clip.LOOP_CONTINUOUSLY);
            bg = ImageIO.read(new File("BG.png"));
            player = ImageIO.read(new File("player.png"));
            enemy1 = ImageIO.read(new File("enemy1.png"));
            enemy2 = ImageIO.read(new File("enemy2.png"));
            pickup = ImageIO.read(new File("pickup.png"));
            wall1 = ImageIO.read(new File("wall1.png"));
            wall2 = ImageIO.read(new File("wall2.png"));
            wall3 = ImageIO.read(new File("wall3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    private static AssetLoader ourInstance = new AssetLoader();

    public static AssetLoader getInstance() {
        return ourInstance;
    }

    public static void playPick() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(pick));
        clip.start();
    }
}
