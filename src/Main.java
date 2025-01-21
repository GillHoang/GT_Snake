import Controller.LoginController;
import View.LoginPanel;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main() {
        super("Snake"); // Ten cua project

        JPanel cardPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        LoginPanel loginPanel = new LoginPanel(cardPanel, cardLayout);
        cardPanel.add(loginPanel, "GS");
        new LoginController(loginPanel, cardPanel, cardLayout);

        this.add(cardPanel);

        // setup screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}