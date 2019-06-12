import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Board extends JPanel implements ActionListener {
    private Timer timer = new Timer(40, this);
    private Actor[][] map = new Actor[8][8];
    public int hp;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
        }
    }

    public Board(){
        hp = 100;
        setPreferredSize(new Dimension(640, 640));
        timer.start();
        generateMap(1);
    }

    public void paintComponent(Graphics g) {
        requestFocusInWindow();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.WHITE);
        g.drawImage(AssetLoader.bg, 0, 0, null);
        for (int i = 0;i<8;i++)
            for(int j=0;j<8;j++){
                if(map[i][j]!=null)map[i][j].draw(g,i+1,j+1);
            }
        repaint();
    }

    private void generateMap(int lvl){
        Random r = new Random();
        int walls = r.nextInt(9) + 4;
        int pickups = r.nextInt(3)+2;
        for(int i=0;i<pickups;i++){
            map[r.nextInt(8)][r.nextInt(8)] = new PickUP();
        }
        for(int i=0;i<walls;i++){
            map[r.nextInt(8)][r.nextInt(8)] = new Wall();
        }
        for(int i=0;i<Math.log(lvl)+2;i++){
            map[r.nextInt(8)][r.nextInt(8)] = new Enemy();
        }
        map[0][0] = new Player();
    }

    public void restart(){
        hp =100;
        for (int i = 0;i<8;i++)
            for(int j=0;j<8;j++){
                map[i][j]=null;
            }
        generateMap(1);
    }

    public boolean move(int key){
        return false;
    }
}
