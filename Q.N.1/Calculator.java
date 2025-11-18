//Write a Java program that works as a simple calculator. Use a grid layout to arrange buttons for the digits and for the +, -, , % operations. Add a text field to display the result. Handle any possible exceptions like divided by zero.

// Import necessary libraries for GUI components and event handling
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Define the Calculator class that extends JFrame and implements ActionListener
public class Calculator extends JFrame implements ActionListener {
    private JTextField display; // Text field to display input and results
    private double firstNumber, secondNumber, result; // Variables to store numbers and result
    private String operator; // Variable to store the current operator

    // Constructor to initialize the calculator
    public Calculator() {
        setTitle("Calculator"); // Set the title of the window
        setSize(350, 500); // Set the size of the window (increased height for better display)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        setLayout(new BorderLayout()); // Use BorderLayout for the frame

        // Initialize the display text field
        display = new JTextField();
        display.setEditable(false); // Make the display non-editable
        display.setFont(new Font("Arial", Font.PLAIN, 32)); // Increased font size for better readability
        display.setPreferredSize(new Dimension(350, 80)); // Set a larger size for the display
        display.setBackground(Color.LIGHT_GRAY); // Set background color for the display
        display.setHorizontalAlignment(JTextField.RIGHT); // Align text to the right
        add(display, BorderLayout.NORTH); // Add the display to the top of the frame

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5)); // Use a 5x4 grid layout with spacing between buttons

        // Define the buttons for the calculator
        String[] buttons = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+", "C"};
        for (String button : buttons) {
            JButton btn = new JButton(button); // Create a button with the given label
            btn.addActionListener(this); // Add an action listener to the button

            // Set button colors based on their function
            if (button.matches("[0-9.]")) {
                btn.setBackground(Color.WHITE); // Digits and decimal point have white background
            } else if (button.matches("[+\\-*/=]")) {
                btn.setBackground(new Color(255, 165, 0)); // Operators and equals have orange background
                btn.setForeground(Color.WHITE); // White text for better contrast
            } else if (button.equals("C")) {
                btn.setBackground(Color.RED); // Clear button has red background
                btn.setForeground(Color.WHITE); // White text for better contrast
                btn.setFont(new Font("Arial", Font.BOLD, 20)); // Larger font for the Clear button
            }

            btn.setOpaque(true); // Ensure the button background is visible
            btn.setBorderPainted(false); // Remove default border for a cleaner look
            buttonPanel.add(btn); // Add the button to the panel
        }

        add(buttonPanel, BorderLayout.CENTER); // Add the button panel to the center of the frame
    }

    // Method to handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // Get the label of the clicked button

        // Handle digits and decimal point
        if (command.matches("[0-9.]")) {
            display.setText(display.getText() + command); // Append the digit or decimal to the display
        }
        // Handle operators (+, -, *, /)
        else if (command.matches("[+\\-*/]")) {
            if (!display.getText().isEmpty()) {
                firstNumber = Double.parseDouble(display.getText()); // Store the first number
                operator = command; // Store the operator
                display.setText(""); // Clear the display for the second number
            }
        }
        // Handle the equals (=) button to calculate the result
        else if (command.equals("=")) {
            if (!display.getText().isEmpty()) {
                secondNumber = Double.parseDouble(display.getText()); // Store the second number

                // Check for division by zero
                if (operator.equals("/") && secondNumber == 0) {
                    display.setText("Error"); // Display "Error" if division by zero is attempted
                    return;
                }

                // Perform the calculation based on the operator
                switch (operator) {
                    case "+" -> result = firstNumber + secondNumber; // Addition
                    case "-" -> result = firstNumber - secondNumber; // Subtraction
                    case "*" -> result = firstNumber * secondNumber; // Multiplication
                    case "/" -> result = firstNumber / secondNumber; // Division
                }
                display.setText(String.valueOf(result)); // Display the result
            }
        }
        // Handle the Clear (C) button
        else if (command.equals("C")) {
            display.setText(""); // Clear the display
            firstNumber = 0; // Reset the first number
            secondNumber = 0; // Reset the second number
            result = 0; // Reset the result
            operator = ""; // Reset the operator
        }
    }

    // Main method to launch the calculator
    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure the GUI runs on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Calculator().setVisible(true));
    }
}