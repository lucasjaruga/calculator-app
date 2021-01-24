package pl.jarugalucas;

import javax.swing.*;

/**
 * The {@code MainFrame} class responsible for showing main window of application and to store other panels with more information
 * for users, like choosing type of food to calculate and also fields to provide information about cat, food etc.
 *
 * @author Lucas Jaruga
 * @version 1.0
 */
public class MainFrame extends JFrame {

    // TODO why static???
    private static UserDataPanel userDataPanel;

    public MainFrame() {

        TypeOfFoodPanel typeOfFoodPanel;

        /* MainFrame settings of application */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);
        this.setLayout(null);
        this.setTitle("Cat Food Calculator");
        ImageIcon appIcon = new ImageIcon("resources/cat.png");
        this.setIconImage(appIcon.getImage());
        this.setLocation(650, 350);
        this.setResizable(false);

        /* Adding two panels to MainFrame */
        typeOfFoodPanel = new TypeOfFoodPanel();
        userDataPanel = new UserDataPanel();
        this.add(typeOfFoodPanel);
        this.add(userDataPanel);

        this.setVisible(true);
    }

    // TODO change that method or remove completely
    public static UserDataPanel getUserDataPanel() {
        return userDataPanel;
    }
}