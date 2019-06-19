import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

public class Board extends JPanel implements ActionListener {
    private Timer timer = new Timer(40, this);
    private Actor[][] map = new Actor[8][8];
    public int hp;
    private int pos_x,pos_y;
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
        g.drawImage(AssetLoader.bg, 0, 0, null);
        for (int i = 0;i<8;i++)
            for(int j=0;j<8;j++){
                if(map[i][j]!=null)map[i][j].draw(g,i+1,j+1);
            }
        if(hp<=0)
            gameOver(g);
        //repaint();
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
        for(int i=0;i<Math.log(lvl);i++){
            map[r.nextInt(8)][r.nextInt(8)] = new Enemy();
        }
        map[0][0] = new Player();
    }

    public void restart(int lvl){
        pos_y = 0; pos_x = 0;
        for (int i = 0;i<8;i++)
            for(int j=0;j<8;j++){
                map[i][j]=null;
            }
        generateMap(lvl);
    }

    private void movePlayer(int x,int y) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if(x<0||y<0||x>7||y>7) return;
        hp--;
        if(map[x][y]==null || map[x][y].isPickup()){
            if(map[x][y]!= null){

                AssetLoader.playPick();
                hp+=10;
            }
            map[x][y] = map[pos_x][pos_y];
            map[pos_x][pos_y] = null;
            pos_x = x;
            pos_y = y;
            return;
        }
        if(map[x][y].isHitable()){
            boolean dead = map[x][y].hit();
            if(dead){
                Random r = new Random();
                if(r.nextInt(10)<=2)map[x][y] = new PickUP();
                else map[x][y] = null;
            }
        }
    }

    private void moveEnemy(int i,int j,int x,int y) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if(map[x][y]==null||map[x][y].isPickup()){
            map[x][y] = map[i][j];
            map[i][j] = null;
            return;
        }
        if(map[x][y].isHitable() && !map[x][y].isEnemy()){
            boolean dead = map[x][y].hit();
            if(dead){
                Random r = new Random();
                if(r.nextInt(10)<=1)map[x][y] = new PickUP();
                else map[x][y] = null;
            }
        }
    }

    private boolean nextToPlayer(int x,int y){
        return (x==pos_x && (y == pos_y-1 || y == pos_y+1)) || (y == pos_y && (x==pos_x-1 || x == pos_x+1));
    }

    private void enemyAI() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        for (int i = 0;i<8;i++)
            for(int j=0;j<8;j++){
                if(map[i][j]!=null && map[i][j].isEnemy() && !((Enemy)map[i][j]).moved){
                    ((Enemy)map[i][j]).moved = true;
                    if(nextToPlayer(i,j)){
                        map[pos_x][pos_y].hit();
                        hp-=10;
                    }
                    else{
                        if(i<pos_x)moveEnemy(i,j,i+1,j);
                        else if(i>pos_x)moveEnemy(i,j,i-1,j);
                        else if(j<pos_y)moveEnemy(i,j,i,j+1);
                        else moveEnemy(i,j,i,j-1);
                    }
                }
            }
        for (int i = 0;i<8;i++)
            for(int j=0;j<8;j++)
                if(map[i][j]!=null && map[i][j].isEnemy())
                    ((Enemy)map[i][j]).moved = false;
    }

    private void gameOver(Graphics g){
        Font font = new Font("Verdana", Font.BOLD, 90);
        g.setFont(font);
        g.setColor(Color.BLUE);
        g.drawString("Game Over",40,320);
        repaint();
    }

    public boolean move(int key) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if(hp<=0)return false;
        switch (key){
            case KeyEvent.VK_DOWN : movePlayer(pos_x+1,pos_y); break;
            case KeyEvent.VK_UP : movePlayer(pos_x-1,pos_y); break;
            case KeyEvent.VK_RIGHT : movePlayer(pos_x,pos_y+1);break;
            case KeyEvent.VK_LEFT : movePlayer(pos_x,pos_y-1);break;
        }
        if (pos_x == 7 && pos_y == 7){
            return true;
        }
        enemyAI();
        if(hp<0)hp=0;
        return false;
    }
}
