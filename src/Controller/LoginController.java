package Controller;

import Model.UserData;
import View.GamePanel;
import View.LoginPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginController {

    private final JPanel cardPanel;
    private final CardLayout cardLayout;
    private final LoginPanel loginPanel;
    private final UserData userData;

    public LoginController(LoginPanel loginPanel , JPanel cardPanel,CardLayout cardLayout, UserData userData) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        this.loginPanel = loginPanel;
        this.userData = userData;

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
//            cardPanel.add(new GamePanel(), "Game");
//            cardLayout.show(cardPanel, "Game");
            loginPanel.displayErrorMessage("oke roi");
        } else {
            loginPanel.displayErrorMessage("Invalid username or password.");
        }
    }

    private boolean validateCredentials(String username, String password){
        return username.equals(this.userData.getUsername()) && password.equals(this.userData.getPassword());
    }
}
