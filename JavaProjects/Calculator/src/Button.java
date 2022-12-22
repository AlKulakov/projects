import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Button extends JButton {
    Operation operation = new Operation();
    Expression exp;
    String title;
    public Button(int x, int y, String title){
        super();
        this.title = title;
        setText(title);
        setBounds(x, y, 50, 50);
        setBackground(Color.WHITE);
        class ButtonListener implements java.awt.event.ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                operation.setExp("T");
                exp = new Expression();
                exp.repaint();
            }
        }
        ActionListener actionListener = new ButtonListener();
        addActionListener(actionListener);
    }
}
