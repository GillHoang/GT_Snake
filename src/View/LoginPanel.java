package View;

import Controller.RegisterController;
import Model.UserData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {

    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JButton loginButton;
    private final JButton registerButton;
    private final JLabel messageLabel;
    private final JPanel cardPanel;
    private final CardLayout cardLayout;
    private final UserData userData;

    public LoginPanel(JPanel cardPanel, CardLayout cardLayout, UserData userData) {
        super(new GridBagLayout());

        this.userData = userData;
        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Game title
        JLabel titleLabel = new JLabel("Welcome to Snake Game");
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
        gbc.gridy++;
        add(usernameLabel, gbc);

        // Password label
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridy++;
        add(passwordLabel, gbc);

        // Username field
        usernameField = new JTextField(20);
        gbc.gridy--;
        gbc.gridx++;
        add(usernameField, gbc);

        // Password Field
        passwordField = new JPasswordField(20);
        gbc.gridy++;
        add(passwordField, gbc);


        // Login button
        loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 2;
        add(loginButton, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL; //reset gbc fill

        // Register button
        registerButton = new JButton("Register");
        registerButton.addActionListener(btnReg());
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(registerButton, gbc);
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

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public JLabel getMessageLabel() {
        return messageLabel;
    }

    // Method để hiển thị thông báo lỗi
    public void displayErrorMessage(String message) {
        messageLabel.setText(message);
    }

    public void clearErrorMessage() {
        messageLabel.setText("");
    }

    private ActionListener btnReg() {
        return e -> {
            resetFields();
            RegisterPanel registerPanel = new RegisterPanel(cardPanel, cardLayout, userData);
            cardPanel.add(registerPanel, "Register");
            new RegisterController(registerPanel, cardPanel, cardLayout, userData);
            cardLayout.show(cardPanel, "Register");
        };
    }

     private void resetFields() {
        clearErrorMessage();
        usernameField.setText("");
        passwordField.setText("");
    }
}
