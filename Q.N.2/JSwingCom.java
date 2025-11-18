//	Write a program to demonstrate the use of JSwing Components and add layout managers to it.

import javax.swing.*;
import java.awt.*;

public class JSwingCom extends JFrame {

    public JSwingCom() {
        // Set the title of the JFrame
        setTitle("Swing Components & Layout Managers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null); // Center the frame

        // Set BorderLayout for the JFrame
        setLayout(new BorderLayout(10, 10));

        // NORTH region: Label with FlowLayout
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel headerLabel = new JLabel("Welcome ");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        northPanel.add(headerLabel);
        add(northPanel, BorderLayout.NORTH);

        // CENTER region: Form with GridLayout
        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createTitledBorder("User Information"));

        centerPanel.add(new JLabel("First Name:"));
        JTextField firstNameField = new JTextField();
        centerPanel.add(firstNameField);

        centerPanel.add(new JLabel("Last Name:"));
        JTextField lastNameField = new JTextField();
        centerPanel.add(lastNameField);

        centerPanel.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        centerPanel.add(emailField);

        add(centerPanel, BorderLayout.CENTER);

        // SOUTH region: Buttons with FlowLayout
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");
        southPanel.add(submitButton);
        southPanel.add(cancelButton);
        add(southPanel, BorderLayout.SOUTH);

        // EAST region: List with BoxLayout (vertical)
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
        eastPanel.setBorder(BorderFactory.createTitledBorder("Options"));

        JCheckBox option1 = new JCheckBox("Option 1");
        JCheckBox option2 = new JCheckBox("Option 2");
        JCheckBox option3 = new JCheckBox("Option 3");

        eastPanel.add(option1);
        eastPanel.add(option2);
        eastPanel.add(option3);

        add(eastPanel, BorderLayout.EAST);

        // WEST region: Text area with ScrollPane
        JTextArea textArea = new JTextArea(10, 10);
        textArea.setText("This is a JTextArea");
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Notes"));
        add(scrollPane, BorderLayout.WEST);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run GUI in Event Dispatch Thread for thread safety
        // SwingUtilities.invokeLater(() -> new SwingComponentsDemo());

        JSwingCom obj = new JSwingCom();
    }
}
