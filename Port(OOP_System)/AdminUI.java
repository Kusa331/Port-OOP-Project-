import javax.swing.*; // Import Swing components
import java.awt.*; // Import AWT classes

public class AdminUI extends JFrame { // Inheritance: Extend JFrame to create a GUI window

    // Declare UI components
    private JTextField usernameField; // Field for username input
    private JPasswordField passwordField; // Field for password input
    private JButton loginButton; // Button for login action
    private JLabel reportBugLabel; // Label for reporting bugs
    private JCheckBox showPasswordCheckBox; // Checkbox to show/hide password

    // Constructor: Sets up the UI components and layout
    public AdminUI() {
        setTitle("Admin Login"); // Set the title of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit application on close
        setLayout(new BorderLayout(10, 10)); // Set layout manager with gaps

        // Logo Handling: Load logo image and resize it
        ImageIcon logoIcon = new ImageIcon("port_logo.png"); // Load logo image (adjust path if needed)
        if (logoIcon.getIconWidth() == -1) { // Check if the logo is found
            System.out.println("Logo image not found."); // Log error if image not found
        } else {
            // Resize the image
            Image originalImage = logoIcon.getImage(); // Get the original image
            Image resizedImage = originalImage.getScaledInstance(logoIcon.getIconWidth() / 5,
                    logoIcon.getIconHeight() / 5,
                    Image.SCALE_SMOOTH); // Resize the image smoothly
            logoIcon = new ImageIcon(resizedImage); // Create new ImageIcon with resized image
        }

        JLabel logoLabel = new JLabel(logoIcon); // Create label to display the logo

        // Initialize input fields and button
        usernameField = new JTextField(20); // Input field for username
        passwordField = new JPasswordField(20); // Input field for password
        loginButton = new JButton("Login"); // Button for login action
        reportBugLabel = new JLabel("Report a bug?"); // Label for bug reporting
        reportBugLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align the label

        // UI Layout: Set the background color to soft green and configure panels
        Color backgroundColor = new Color(200, 255, 200); // Soft green color
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // North panel with center flow
        northPanel.setBackground(backgroundColor); // Set background for the north panel
        northPanel.add(logoLabel); // Add logo label to north panel
        add(northPanel, BorderLayout.NORTH); // Add north panel to the top of the frame

        JPanel centerPanel = new JPanel(new GridBagLayout()); // Center panel with GridBag layout
        centerPanel.setBackground(backgroundColor); // Set background for the center panel
        GridBagConstraints gbc = new GridBagConstraints(); // Create layout constraints
        gbc.insets = new Insets(5, 5, 5, 5); // Set insets for spacing
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally

        // Input Fields: Username label and field
        gbc.gridx = 0; // Set grid position for the username label
        gbc.gridy = 0; 
        centerPanel.add(new JLabel("Username:"), gbc); // Add username label

        gbc.gridx = 1; // Move to next column
        centerPanel.add(usernameField, gbc); // Add username field

        // Password label and field
        gbc.gridx = 0; // Reset to first column for password label
        gbc.gridy = 1; 
        centerPanel.add(new JLabel("Password:"), gbc); // Add password label

        gbc.gridx = 1; // Move to next column for password field
        centerPanel.add(passwordField, gbc); // Add password field

        // Show Password Feature: Checkbox to toggle password visibility
        showPasswordCheckBox = new JCheckBox("Show Password"); // Create checkbox for showing password
        showPasswordCheckBox.addActionListener(e -> {
            // Toggle password visibility based on checkbox state
            passwordField.setEchoChar(showPasswordCheckBox.isSelected() ? (char) 0 : '*'); // Show or hide password
        });

        gbc.gridx = 1; // Set position for checkbox
        gbc.gridy = 2; 
        centerPanel.add(showPasswordCheckBox, gbc); // Add checkbox to center panel

        // Login Button: Button to initiate login
        gbc.gridx = 1; // Set position for login button
        gbc.gridy = 3; 
        gbc.anchor = GridBagConstraints.EAST; // Align button to the right
        centerPanel.add(loginButton, gbc); // Add button to center panel

        // Add center panel and report bug label to the main frame
        add(centerPanel, BorderLayout.CENTER); // Add center panel to the frame
        add(reportBugLabel, BorderLayout.SOUTH); // Add bug report label to the bottom

        // Action listener for the login button
        loginButton.addActionListener(e -> {
            String username = usernameField.getText().trim(); // Get username input
            String password = new String(passwordField.getPassword()); // Get password input

            // Validation Logic: Validate inputs
            if (username.isEmpty() || password.isEmpty()) { // Check if fields are empty
                // Show warning if fields are empty
                JOptionPane.showMessageDialog(AdminUI.this, "Please enter both username and password.", "Input Error", JOptionPane.WARNING_MESSAGE);
            } else if (isValidCredentials(username, password)) { // Check if credentials are valid
                new AdminInterface(); // Proceed to admin interface
                dispose(); // Close login window
            } else {
                // Show error message for invalid credentials
                JOptionPane.showMessageDialog(AdminUI.this, "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Window Settings: Finalize window settings
        pack(); // Resize frame to fit components
        setLocationRelativeTo(null); // Center the window on screen
        setVisible(true); // Make the window visible
    }

    // Validation Logic: Validate credentials
    private boolean isValidCredentials(String username, String password) {
        return username.equals("admin") && password.equals("123"); // Check for valid credentials
    }

    // Main Method: Entry point of the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(AdminUI::new); // Run the application on the Event Dispatch Thread
    }
}
