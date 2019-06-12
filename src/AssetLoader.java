import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AssetLoader {
    public static BufferedImage bg,player,enemy1,enemy2,pickup,wall1,wall2,wall3;
    public AssetLoader(){
        try {
            bg = ImageIO.read(new File("C:\\Users\\Rufus\\IdeaProjects\\Java2017_2018\\PO\\BG.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static AssetLoader ourInstance = new AssetLoader();

    public static AssetLoader getInstance() {
        return ourInstance;
    }
}
