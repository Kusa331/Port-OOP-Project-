import javax.swing.*;
import java.awt.*;

public class TicketPanel extends JPanel {
    public TicketPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(200, 255, 200)); // Soft green background

        JLabel titleLabel = new JLabel("Ticket Type", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 25));
        titleLabel.setPreferredSize(new Dimension(0, 60)); // Fixed height for title
        add(titleLabel, BorderLayout.NORTH);

        // Create a panel to hold the ticket rows
        JPanel ticketRowsPanel = new JPanel();
        ticketRowsPanel.setLayout(new BoxLayout(ticketRowsPanel, BoxLayout.Y_AXIS));
        ticketRowsPanel.setBackground(new Color(200, 255, 200)); // Soft green background for the ticket rows

        // Add ticket rows
        ticketRowsPanel.add(createTicketRow("Calinan Transit Terminal to Mintal", 30));
        ticketRowsPanel.add(createTicketRow("Calinan Transit Terminal to Mintal", 30));
        ticketRowsPanel.add(createTicketRow("Calinan Transit Terminal to Toril", 35));
        ticketRowsPanel.add(createTicketRow("Calinan Transit Terminal to Calinan", 35));

        add(ticketRowsPanel, BorderLayout.CENTER);

        // Create a panel for the buttons at the bottom
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(200, 255, 200)); // Soft green background
        buttonPanel.setLayout(new FlowLayout());

        JButton editButton = new JButton("Edit Ticket");
        JButton validateButton = new JButton("Validate");

        buttonPanel.add(editButton);
        buttonPanel.add(validateButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createTicketRow(String route, int price) {
        JPanel rowPanel = new JPanel(new BorderLayout());
        rowPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        rowPanel.setBackground(Color.WHITE);
        rowPanel.setPreferredSize(new Dimension(500, 60)); // Compact height for rows

        // Left side (Route info)
        JLabel routeLabel = new JLabel(route);
        routeLabel.setFont(new Font("Serif", Font.PLAIN, 16)); // Slightly larger font for clarity
        rowPanel.add(routeLabel, BorderLayout.WEST);

        // Center (Bus icon and price)
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        centerPanel.setBackground(Color.WHITE);
        
        // Load and resize the bus icon
        ImageIcon busIcon = new ImageIcon("bus.png"); // Replace with the actual path to your bus icon
        Image scaledBusImage = busIcon.getImage().getScaledInstance(56, 56, Image.SCALE_SMOOTH); // Larger size for the icon
        JLabel busLabel = new JLabel(new ImageIcon(scaledBusImage));
        
        // Smaller price label
        JLabel priceLabel = new JLabel("PHP " + price);
        priceLabel.setFont(new Font("Serif", Font.PLAIN, 14)); // Smaller font for price

        centerPanel.add(busLabel);
        centerPanel.add(priceLabel);

        rowPanel.add(centerPanel, BorderLayout.CENTER);

        // Right side (Select button)
        JButton selectButton = new JButton("Select");
        selectButton.setPreferredSize(new Dimension(90, 40)); // Adjusted button size for compact design
        selectButton.setBackground(new Color(169, 221, 169)); // Light green background
        rowPanel.add(selectButton, BorderLayout.EAST);

        return rowPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ticket Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(new TicketPanel());
        frame.setVisible(true);
    }
}
