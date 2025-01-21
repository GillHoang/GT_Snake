package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JPasswordField confirmPasswordField;
    private final JButton registerButton;
    private final JLabel messageLabel;
    private final JPanel cardPanel;
    private final CardLayout cardLayout;

    public RegisterPanel(JPanel cardPanel, CardLayout cardLayout) {
        super(new GridBagLayout());

        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Game title
        JLabel titleLabel = new JLabel("Register account to play Snake");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 2; // Cho phép label trải dài hết 2 cột
        add(titleLabel, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;

        // Username label
        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(usernameLabel, gbc);

        // Password label
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(passwordLabel, gbc);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(confirmPasswordLabel, gbc);

        // Username field
        usernameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(usernameField, gbc);

        // Password Field
        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(passwordField, gbc);

        confirmPasswordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(confirmPasswordField, gbc);

        // Register button
        registerButton = new JButton("Register");
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 2;
        add(registerButton, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL; //reset gbc fill

        // Login button
        JButton loginButton = new JButton("Back to login");
        loginButton.addActionListener(btnLogin());
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 2;
        add(loginButton, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL; //reset gbc fill

        // Message label
        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED); // Để message hiển thị màu đỏ nếu có lỗi
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(messageLabel, gbc);
    }

    // Getters để Controller có thể lấy dữ liệu từ View
    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JPasswordField getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    // Method để hiển thị thông báo lỗi
    public void displayErrorMessage(String message) {
        messageLabel.setText(message);
    }

    public void clearErrorMessage() {
        messageLabel.setText("");
    }

    private ActionListener btnLogin() {
        return e -> {
            resetFields();
            cardLayout.show(cardPanel, "Login");
        };
    }

    private void resetFields() {
        clearErrorMessage();
        usernameField.setText("");
        passwordField.setText("");
    }
}
