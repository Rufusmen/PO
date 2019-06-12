import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
    private JPanel root;
    private JPanel side;
    private JPanel board;
    private JLabel lvlLabel;
    private JPanel stats;
    private JButton restart;
    private int lvl;

    public GUI(String rougelike) {
        super(rougelike);
        lvl = 1;
        setContentPane(root);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() {
        board = new Board();
        // TODO: place custom component creation code here
    }
}
