import javax.swing.*;
import java.awt.*;

class BaseAdminPanel extends JPanel {
    public BaseAdminPanel(String panelName) {
        setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel(panelName + " Content", SwingConstants.CENTER);
        add(titleLabel, BorderLayout.CENTER);
    }
}
