import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUI gui = new GUI("Rougelike");
            gui.pack();
            gui.setLocationRelativeTo(null);
            gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            gui.setVisible(true);
        });
    }
}
