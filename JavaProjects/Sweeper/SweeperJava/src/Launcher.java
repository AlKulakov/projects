
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Launcher extends JFrame {
    private Game game;
    private final int IMAGE_SIZE = 50;
    private final int ROWS = 10;
    private final int COLS = 15;
    private final int BOMBS_COUNT = 20;

    private JPanel panel;
    public static void main(String[] args) {
        new Launcher();
    }
    private Launcher(){
        game = new Game(COLS, ROWS, BOMBS_COUNT);
        game.start();
        setImages();
        initilizePanel();
        initilizeFrame();
    }
    private void initilizePanel() {
        panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for(Coord coord : Range.getAllCoords()){
                    g.drawImage((Image)game.getBox(coord).image,
                            coord.x * IMAGE_SIZE,
                            coord.y * IMAGE_SIZE, this );
                }
            }
        };
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX()/IMAGE_SIZE;
                int y = e.getY()/IMAGE_SIZE;
                Coord coord = new Coord(x,y);
                switch(e.getButton()){

                    case MouseEvent.BUTTON1: game.pressLeftButton(coord); break;
                    case MouseEvent.BUTTON2: game.start(); break;
                    case MouseEvent.BUTTON3: game.pressRightButton(coord); break;
                }
                panel.repaint();
            }
        });
        panel.setPreferredSize(new Dimension(IMAGE_SIZE * Range.getSize().x, IMAGE_SIZE * Range.getSize().y));
        add(panel);
    }
    private void initilizeFrame() {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Sweeper");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }
    private void setImages(){
        for (Box box : Box.values())
            box.image = getImage(box.name().toLowerCase());
        setIconImage(getImage("icon"));
    }
    private Image getImage(String imageName) {
        String file_name = "/img/" + imageName + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(file_name));
        return icon.getImage();
    }
}