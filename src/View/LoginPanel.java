package View;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JButton loginButton;
    private final JLabel messageLabel;
    private final JPanel cardPanel;
    private final CardLayout cardLayout;
    private final String username = "user";
    private final String password = "pass";

    public LoginPanel(JPanel cardPanel, CardLayout cardLayout) {
        super(new GridBagLayout());

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
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL; //reset gbc fill

        // Message label
        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED); // Để message hiển thị màu đỏ nếu có lỗi
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 2; // Cho phép label trải dài hết 2 cột
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

}
