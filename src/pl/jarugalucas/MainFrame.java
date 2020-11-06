package pl.jarugalucas;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame(){

        ImageIcon appIcon = new ImageIcon("resources/cat.png");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setTitle("Cat Food Calculator");
        this.setIconImage(appIcon.getImage());
        this.setVisible(true);
        this.setResizable(false);



    }
}