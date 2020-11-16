package pl.jarugalucas;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private final TypeOfFoodPanel typeOfFoodPanel;
    private static UserDataPanel userDataPanel;

    public MainFrame() {

        ImageIcon appIcon = new ImageIcon("resources/cat.png");

        // settings for MainFrame of application
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);
        this.setLayout(null);
        this.setTitle("Cat Food Calculator");
        this.setIconImage(appIcon.getImage());
        this.setLocation(650, 350);
        this.setResizable(false);


        typeOfFoodPanel = new TypeOfFoodPanel();
        userDataPanel = new UserDataPanel();

        this.add(typeOfFoodPanel);
        this.add(userDataPanel);

        this.setVisible(true);
    }

    public static UserDataPanel getUserDataPanel() {
        return userDataPanel;
    }

}