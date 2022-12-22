import javax.swing.*;
import java.awt.*;

public class Result extends JLabel {
    Result(){
        super();
        setBounds(10, 49, 235, 35);
        setForeground(Color.BLACK);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        setText("0");
        setFont(new Font("Arial", Font.BOLD, 31));
    }
}
