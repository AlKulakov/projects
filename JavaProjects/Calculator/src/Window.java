import javax.swing.*;
import java.awt.*;

public class Window implements Runnable {
    private JFrame frame;
    private JPanel panel;
    public void run(){
        initFrame();
        initLabels();
        initButtons();
        initPanel();
    }
    private void initPanel() {
        panel = new JPanel();
        panel.setBounds(0, 95, 270, 325);
        panel.setBackground(Color.LIGHT_GRAY);
        frame.add(panel);
    }
    private void initButtons(){
        frame.add(new Button(20, 120, "+"));
        frame.add(new Button(75, 120, "-"));
        frame.add(new Button(130, 120, "X"));
        frame.add(new Button(185, 120, "/"));
        frame.add(new Button(20, 175, "1"));
        frame.add(new Button(75, 175, "2"));
        frame.add(new Button(130, 175, "3"));
        frame.add(new Button(185, 175, "%"));
        frame.add(new Button(20, 230, "4"));
        frame.add(new Button(75, 230, "5"));
        frame.add(new Button(130, 230, "6"));
        frame.add(new Button(185, 230, "^"));
        frame.add(new Button(20, 285, "7"));
        frame.add(new Button(75, 285, "8"));
        frame.add(new Button(130, 285, "9"));
        frame.add(new Button(185, 285, "x!"));
        frame.add(new Button(20, 340, "-+"));
        frame.add(new Button(75, 340, "0"));
        frame.add(new Button(130, 340, "."));
        frame.add(new Button(185, 340, "="));
    }
    private void initLabels(){
        frame.add(new Expression());
        frame.add(new Result());
    }
    private void initFrame(){
        frame = new JFrame("Калькулятор");
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(270,450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
