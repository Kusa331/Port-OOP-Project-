import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {
    public DashboardPanel() {
        setBackground(new Color(200, 255, 200)); // Soft green background
        JLabel label = new JLabel("Dashboard Panel");
        label.setFont(new Font("Serif", Font.BOLD, 25));
        add(label);
    }
}
