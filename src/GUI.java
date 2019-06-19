import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class GUI extends JFrame{
    private JPanel root;
    private JPanel side;
    private JPanel board;
    private JLabel lvlLabel;
    private JPanel stats;
    private JButton restart;
    private JLabel hpLabel;
    private int lvl;

    public GUI(String rougelike) {
        super(rougelike);
        lvl = 1;
        setContentPane(root);
        lvlLabel.setText("LVL : " + lvl);
        restart.addActionListener(e -> {
            lvl = 1;
            ((Board)board).restart(lvl);
            ((Board)board).hp = 100;
            lvlLabel.setText("LVL : " + lvl);
            hpLabel.setText("HP : " + 100);
        });
        board.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                try {
                    if(((Board)board).move(e.getKeyCode())){
                        lvl++;
                        ((Board)board).restart(lvl);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (LineUnavailableException e1) {
                    e1.printStackTrace();
                } catch (UnsupportedAudioFileException e1) {
                    e1.printStackTrace();
                }
                lvlLabel.setText("LVL : " + lvl);
                hpLabel.setText("HP : " + ((Board)board).hp);
            }
        });
    }


    private void createUIComponents() {
        board = new Board();
        // TODO: place custom component creation code here
    }
}
