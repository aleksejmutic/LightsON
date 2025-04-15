package view.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LicenceDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public LicenceDialog(JFrame parent) {
        super(parent, "Create a New Licence", true);
        setSize(700, 500);
        setLayout(new BorderLayout());

        // Description panel with explanatory text
        JPanel descriptionPanel = new JPanel();
        JLabel descriptionLabel = new JLabel("<html><b>Create a New Licence</b><br>This licence grants you access to all features. Enter your email and password to activate.</html>");
        descriptionPanel.add(descriptionLabel);

        // Input fields panel (email and password)
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        inputPanel.add(emailLabel);
        inputPanel.add(emailField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        // Buttons panel (submit and cancel buttons)
        JPanel buttonPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                System.out.println(email);
                System.out.println(password);
                // Logic to handle license creation can go here
                JOptionPane.showMessageDialog(LicenceDialog.this, "Licence Created!\nEmail: " + email);
                dispose(); // Close the dialog
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the dialog on cancel
            }
        });

        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        // Add panels to the dialog
        add(descriptionPanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Show the dialog
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}
