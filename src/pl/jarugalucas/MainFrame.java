package pl.jarugalucas;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private TypeOfFoodPanel typeOfFoodPanel;
    private UserDataPanel userDataPanel;

    public MainFrame(){

        ImageIcon appIcon = new ImageIcon("resources/cat.png");

        // settings for MainFrame of application
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);
        this.setTitle("Cat Food Calculator");
        this.setIconImage(appIcon.getImage());
        this.setLocation(650,350);
        this.setVisible(true);
        this.setResizable(false);

        typeOfFoodPanel = new TypeOfFoodPanel();
        userDataPanel = new UserDataPanel();

        this.add(typeOfFoodPanel);
        this.add(userDataPanel);

    }
}