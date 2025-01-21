package Controller;

import Model.UserData;
import View.RegisterPanel;

import java.awt.event.ActionListener;

public class RegisterController {
    private final RegisterPanel registerPanel;
    private final UserData userData;

    public RegisterController(RegisterPanel registerPanel,  UserData userData) {
        this.userData = userData;
        this.registerPanel = registerPanel;

        registerPanel.getRegisterButton().addActionListener(btnRegister());
    }

    private ActionListener btnRegister() {
        return e -> handleRegister();
    }

    private void handleRegister() {
        String username = registerPanel.getUsernameField().getText();
        String password = String.valueOf(registerPanel.getPasswordField().getPassword());
        String confirmPasswordField = String.valueOf(registerPanel.getConfirmPasswordField().getPassword());
        // Save data
        if (username == null) {
            registerPanel.displayErrorMessage("Please fill all the fields");
        } else if (password.equals(confirmPasswordField)) {
            userData.setUsername(username);
            userData.setPassword(password);
            registerPanel.displayErrorMessage("Done! Please back to login");
        } else {
            registerPanel.displayErrorMessage("Password and Confirm Password do not match");
        }

    }
}
