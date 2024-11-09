import javax.swing.*;
import java.awt.*;

public class ManagerPanel extends JPanel {
    public ManagerPanel() {
        setBackground(new Color(200, 255, 200)); // Soft green background
        JLabel label = new JLabel("Manager Panel");
        label.setFont(new Font("Serif", Font.BOLD, 25));
        add(label);
       
    }
}
