import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {
    private Timer timer = new Timer(40, this);
    private Actor[][] map;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
        }
    }

    public Board(){
        setPreferredSize(new Dimension(640, 640));
        timer.start();
    }

    public void paintComponent(Graphics g) {
        requestFocusInWindow();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.WHITE);
        g.drawImage(AssetLoader.bg, 0, 0, null);
        /*for (Actor[] a1 : map
                ) {
            for(Actor actor: a1){

            }
        }*/
        repaint();
    }
}
