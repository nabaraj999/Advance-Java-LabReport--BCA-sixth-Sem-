// Create a login page in Swing and add events to it on click of login button.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    public Login() {
        setTitle("Login Page");
        setSize(350, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Center the window

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setBackground(new Color(245, 245, 245));

        // Username
        JPanel usernamePanel = createInputPanel("Username:", new JTextField(20));
        formPanel.add(usernamePanel);

        // Password
        JPanel passwordPanel = createInputPanel("Password:", new JPasswordField(20));
        formPanel.add(passwordPanel);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(100, 150, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setFocusPainted(false);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        formPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some space
        formPanel.add(loginButton);

        // Button Action
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = ((JTextField) usernamePanel.getComponent(1)).getText();
                String password = new String(((JPasswordField) passwordPanel.getComponent(1)).getPassword());

                // Simple login validation
                if (username.equals("nabu") && password.equals("Nepal@123")) {
                    JOptionPane.showMessageDialog(Login.this, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(formPanel, BorderLayout.CENTER);
    }

    private JPanel createInputPanel(String labelText, Component inputField) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(245, 245, 245));

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setPreferredSize(new Dimension(80, 25));
        panel.add(label);

        inputField.setPreferredSize(new Dimension(200, 30));
        panel.add(inputField);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}

