package Game;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private JFrame frame;
    private JPanel gamePanel;
    private JPanel colorChoosePanel;
    public Window(){
        initGamePanel();

        initFrame();
    }
    void initFrame(){
        frame = new JFrame();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Chess");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }
    void initGamePanel() {
        gamePanel = new JPanel();
        gamePanel.setPreferredSize(new Dimension(Config.CELL_SIZE * Config.FIELD_SIZE,
                Config.CELL_SIZE * Config.FIELD_SIZE));
        add(gamePanel);
    }
}
