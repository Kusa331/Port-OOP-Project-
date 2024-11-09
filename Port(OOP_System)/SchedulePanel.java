import javax.swing.*;
import java.awt.*;

public class SchedulePanel extends JPanel {
    public SchedulePanel() {
        setBackground(new Color(200, 255, 200)); // Soft green background
        JLabel label = new JLabel("Schedule Panel");
        label.setFont(new Font("Serif", Font.BOLD, 25));
        add(label);
    }
}
