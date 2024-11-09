import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePanel extends JPanel {
    public HomePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(200, 255, 200)); // Soft green background

        JLabel welcomeLabel = new JLabel("Welcome, Admin!");
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 48));
        welcomeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(welcomeLabel);
        add(Box.createVerticalStrut(20));

        JLabel timeLabel = new JLabel();
        timeLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        timeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(timeLabel);

        // Update the time label every second
        Timer timer = new Timer(1000, e -> {
            SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss");
            timeLabel.setText(formatter.format(new Date()));
        });
        timer.start();
    }
}
