import javax.swing.*;
import java.awt.*;

public class Expression extends JLabel {
    Operation operation = new Operation();
    Expression(){
        super();
        setBounds(10, 10, 235, 40);
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        setText(operation.getExp());
        setFont(new Font("Arial", Font.PLAIN, 20));
    }
}
