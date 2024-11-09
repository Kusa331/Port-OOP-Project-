import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AdminInterface extends JFrame {
    private final JPanel homePanel;
    private CardLayout cardLayout;

    public AdminInterface() {
        setTitle("Admin Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the main panel with CardLayout for view switching
        JPanel mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        // Create the home panel with BoxLayout (vertical alignment)
        homePanel = new HomePanel(); // Assuming you have a HomePanel class
        mainPanel.add(homePanel, "Home");
        mainPanel.add(new DashboardPanel(), "Dashboard");
        mainPanel.add(new TicketPanel(), "Ticket");
        mainPanel.add(new SchedulePanel(), "Schedule");
        mainPanel.add(new ManagerPanel(), "Manager");

        // Add the mainPanel to the JFrame
        add(mainPanel, BorderLayout.CENTER);

        // Create a JToolBar for the navigation bar
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setBackground(new Color(200, 255, 200)); // Set soft green background color

        // Load logo icon
        ImageIcon logoIcon = loadLogoIcon("port2.logo.png");
        JLabel logoLabel = new JLabel(logoIcon);
        toolBar.add(logoLabel);

        // Create a panel to center the buttons with a soft green background
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(200, 255, 200)); // Set soft green background color

        // Create and add buttons to the button panel
            JButton homeButton = new JButton("Home");
            JButton dashboardButton = new JButton("Dashboard");
            JButton ticketButton = new JButton("Ticket");
            JButton scheduleButton = new JButton("Schedule");
            JButton managerButton = new JButton("Manager");
            JButton logoutButton = new JButton("Logout");

        // Add buttons to the button panel
        buttonPanel.add(homeButton);
        buttonPanel.add(dashboardButton);
        buttonPanel.add(ticketButton);
        buttonPanel.add(scheduleButton);
        buttonPanel.add(managerButton);
        buttonPanel.add(logoutButton);

        // Add the button panel to the toolbar
        toolBar.add(buttonPanel);

        // Add action listeners to the buttons to switch between panels
        homeButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
        dashboardButton.addActionListener(e -> cardLayout.show(mainPanel, "Dashboard"));
        ticketButton.addActionListener(e -> cardLayout.show(mainPanel, "Ticket"));
        scheduleButton.addActionListener(e -> cardLayout.show(mainPanel, "Schedule"));
        managerButton.addActionListener(e -> cardLayout.show(mainPanel, "Manager"));

        // Logout button functionality
        logoutButton.addActionListener(e -> {
            int confirmResult = JOptionPane.showConfirmDialog(
                    AdminInterface.this,
                    "Are you sure you want to logout?",
                    "Confirm Logout",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (confirmResult == JOptionPane.YES_OPTION) {
                new AdminUI(); // Return to the login screen
                dispose(); // Close the AdminInterface window
            }
        });

        // Add the toolbar to the main window
        add(toolBar, BorderLayout.NORTH);

        // Set the frame size to full screen
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizes the frame to full screen
        setLocationRelativeTo(null); // Center the frame

        // Make the frame visible
        setVisible(true);
    }

    private ImageIcon loadLogoIcon(String path) {
        File file = new File(path);
        if (file.exists()) {
            ImageIcon icon = new ImageIcon(path);
            // Resize the icon if necessary (e.g., to fit the toolbar)
            Image image = icon.getImage().getScaledInstance(100,50, Image.SCALE_SMOOTH); // Adjust size as needed
            return new ImageIcon(image);
        } else {
            System.out.println("Logo not found at: " + path);
            // Return a placeholder or an empty icon
            return new ImageIcon(); // Placeholder icon
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AdminInterface::new);
    }
}