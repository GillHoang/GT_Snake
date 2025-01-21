package Controller;

import View.GamePanel;
import View.LoginPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginController {

    private final JPanel cardPanel;
    private final CardLayout cardLayout;
    private final LoginPanel loginPanel;
    private final String username = "user";
    private final String password = "pass";

    public LoginController(LoginPanel loginPanel ,JPanel cardPanel, CardLayout cardLayout) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        this.loginPanel = loginPanel;

        loginPanel.getLoginButton().addActionListener(btnLogin());
    }

    private ActionListener btnLogin() {
        return e -> {
            handleLogin();
        };
    }

    private void handleLogin(){
        loginPanel.clearErrorMessage();
        String username = loginPanel.getUsernameField().getText();
        String password = String.valueOf(loginPanel.getPasswordField().getPassword());
        if (validateCredentials(username, password)) {
            cardPanel.add(new GamePanel(), "game");
            cardLayout.show(cardPanel, "game");
        } else {
            loginPanel.displayErrorMessage("Invalid username or password.");
        }
    }

    private boolean validateCredentials(String username, String password){
        return username.equals(this.username) && password.equals(this.password);
    }
}
