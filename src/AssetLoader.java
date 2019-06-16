import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AssetLoader {
    public static BufferedImage bg,player,enemy1,enemy2,pickup,wall1,wall2,wall3;
    private AssetLoader(){
        try {
            bg = ImageIO.read(new File("/home/rufus/IdeaProjects/PO/BG.jpg"));
            player = ImageIO.read(new File("/home/rufus/IdeaProjects/PO/player.jpg"));
            enemy1 = ImageIO.read(new File("/home/rufus/IdeaProjects/PO/enemy1.jpg"));
            enemy2 = ImageIO.read(new File("/home/rufus/IdeaProjects/PO/enemy2.jpg"));
            pickup = ImageIO.read(new File("/home/rufus/IdeaProjects/PO/pickup.jpg"));
            wall1 = ImageIO.read(new File("/home/rufus/IdeaProjects/PO/wall1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static AssetLoader ourInstance = new AssetLoader();

    public static AssetLoader getInstance() {
        return ourInstance;
    }
}
