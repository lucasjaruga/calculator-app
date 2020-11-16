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
        step2Text.setVisible(false);

        //waga kota text settings
        catWeightLabel = new JLabel("weight of cat");
        catWeightLabel.setBounds(15, 35, 100, 40);
        catWeightLabel.setForeground(Color.yellow);
        catWeightLabel.setVisible(false);

        //ilosc mokrej text settings
        wetFoodLabel = new JLabel("ilosc mokrej");
        wetFoodLabel.setBounds(15, 85, 100, 40);
        wetFoodLabel.setForeground(Color.yellow);
        wetFoodLabel.setVisible(false);

        //ilosc posilkow text settings
        noMealsLabel = new JLabel("ilosc posilkow");
        noMealsLabel.setBounds(15, 135, 100, 40);
        noMealsLabel.setForeground(Color.yellow);
        noMealsLabel.setVisible(false);

        // ------------------- text labels end -------------------------- //



        // ------------------- text fields start -------------------------- //

        //waga kota field settings
        catWeightText = new JTextField();
        catWeightText.setBounds(15, 65,150,20);
        catWeightText.setVisible(false);

        //ilosc mokrej field settings
        wetFoodText = new JTextField();
        wetFoodText.setBounds(15, 115,150,20);
        wetFoodText.setVisible(false);

        //ilosc posilkow field settings
        noMealsText = new JTextField();
        noMealsText.setBounds(15, 165,150,20);
        noMealsText.setVisible(false);

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
        resultMixFoodText.setVisible(false);

        // ------------------- text fields end -------------------------- //


        // Calculate button settings
        calculateButton = new JButton("Oblicz");
        calculateButton.setFocusable(false);
        calculateButton.setBounds(40, 200, 70, 30);
        calculateButton.setVisible(false);

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

    public JLabel getStep2Text() {
        return step2Text;
    }

    public JLabel getCatWeightLabel() {
        return catWeightLabel;
    }

    public JLabel getWetFoodLabel() {
        return wetFoodLabel;
    }

    public JLabel getNoMealsLabel() {
        return noMealsLabel;
    }

    public JTextField getWetFoodText() {
        return wetFoodText;
    }

    public JTextField getCatWeightText() {
        return catWeightText;
    }

    public JTextField getNoMealsText() {
        return noMealsText;
    }

    public JLabel getResultOneFoodText() {
        return resultOneFoodText;
    }

    public JLabel getResultMixFoodText() {
        return resultMixFoodText;
    }

    public JButton getCalculateButton() {
        return calculateButton;
    }
}