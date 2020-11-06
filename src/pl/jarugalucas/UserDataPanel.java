package pl.jarugalucas;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class UserDataPanel extends JPanel {

    private JLabel step2Text;
    private JLabel catWeightLabel;
    private JLabel wetFoodLabel;
    private JLabel noMealsLabel;
    private JTextField wetFoodText;
    private JTextField catWeightText;
    private JTextField noMealsText;
    private JLabel resultOneFoodText;
    private JLabel resultMixFoodText;

    private JButton calculateButton;

    public UserDataPanel(){

        // basic settings for UserDataPanel
        this.setLayout(null);
        this.setBackground(Color.darkGray);
        this.setBounds(300, 0, 485, 462);

        // ------------------- text labels start -------------------------- //

        //Step2 text settings
        step2Text = new JLabel("Step 2) Wprowadz dane dot. kota i karmy");
        step2Text.setBounds(15, 10, 300, 40);
        step2Text.setForeground(Color.green);

        //waga kota text settings
        catWeightLabel = new JLabel("weight of cat");
        catWeightLabel.setBounds(15, 35, 100, 40);
        catWeightLabel.setForeground(Color.yellow);

        //ilosc mokrej text settings
        wetFoodLabel = new JLabel("ilosc mokrej");
        wetFoodLabel.setBounds(15, 85, 100, 40);
        wetFoodLabel.setForeground(Color.yellow);

        //ilosc posilkow text settings
        noMealsLabel = new JLabel("ilosc posilkow");
        noMealsLabel.setBounds(15, 135, 100, 40);
        noMealsLabel.setForeground(Color.yellow);

        // ------------------- text labels end -------------------------- //



        // ------------------- text fields start -------------------------- //

        //waga kota field settings
        catWeightText = new JTextField();
        catWeightText.setBounds(15, 65,150,20);

        //ilosc mokrej field settings
        wetFoodText = new JTextField();
        wetFoodText.setBounds(15, 115,150,20);

        //ilosc posilkow field settings
        noMealsText = new JTextField();
        noMealsText.setBounds(15, 165,150,20);

        // wynik obliczen
        resultOneFoodText = new JLabel();
        resultOneFoodText.setBounds(15, 240, 200, 30);
        resultOneFoodText.setText("Wynik to: " + "40" + " g");
        resultOneFoodText.setForeground(Color.yellow);
        resultOneFoodText.setFont(new Font("Calibri", Font.BOLD, 20));
        resultOneFoodText.setVisible(false);

        resultMixFoodText = new JLabel();
        resultMixFoodText.setBounds(15, 240, 200, 30);
        resultMixFoodText.setText("Wynik to: " + "60" + " g");
        resultMixFoodText.setForeground(Color.yellow);
        resultMixFoodText.setFont(new Font("Calibri", Font.BOLD, 20));
        resultMixFoodText.setVisible(true);

        // ------------------- text fields end -------------------------- //


        // Calculate button settings
        calculateButton = new JButton("Oblicz");
        calculateButton.setFocusable(false);
        calculateButton.setBounds(40, 200, 70, 30);

        // adding components to TypeOfFoodPanel
        this.add(step2Text);

        this.add(catWeightLabel);
        this.add(catWeightText);

        this.add(wetFoodLabel);
        this.add(wetFoodText);

        this.add(noMealsLabel);
        this.add(noMealsText);

        this.add(resultOneFoodText);
        this.add(resultMixFoodText);

        this.add(calculateButton);
    }
}