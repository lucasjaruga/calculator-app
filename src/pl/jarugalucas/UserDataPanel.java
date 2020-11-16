package pl.jarugalucas;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserDataPanel extends JPanel implements ActionListener {

    private JLabel step2Text;
    private JLabel catWeightLabel;
    private JLabel wetFoodLabel;
    private JLabel noMealsLabel;
    private JTextField wetFoodText;
    private JTextField catWeightText;
    private JTextField noMealsText;
    private JRadioButton wetMealType;
    private JRadioButton dryMealType;
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
        step2Text = new JLabel("Step 2) PROVIDE INFORMATION ABOUT CAT AND FOOD");
        step2Text.setBounds(15, 10, 320, 40);
        step2Text.setForeground(Color.green);
        step2Text.setVisible(false);

        //waga kota text settings
        catWeightLabel = new JLabel("WEIGHT OF CAT");
        catWeightLabel.setBounds(15, 35, 100, 40);
        catWeightLabel.setForeground(Color.yellow);
        catWeightLabel.setVisible(false);

        //ilosc mokrej text settings
        wetFoodLabel = new JLabel("HOW MUCH WET FOOD");
        wetFoodLabel.setBounds(15, 85, 130, 40);
        wetFoodLabel.setForeground(Color.yellow);
        wetFoodLabel.setVisible(false);

        //ilosc posilkow text settings
        noMealsLabel = new JLabel("NUMBER OF MEALS");
        noMealsLabel.setBounds(15, 135, 120, 40);
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

        //rodzaj karmy
        wetMealType = new JRadioButton();
        wetMealType.setText("WET");
        wetMealType.setBounds(15, 165, 70, 20);
        wetMealType.setVisible(false);
        wetMealType.setFocusable(false);
        wetMealType.addActionListener(this);

        dryMealType = new JRadioButton();
        dryMealType.setText("DRY");
        dryMealType.setBounds(94, 165, 70, 20);
        dryMealType.setVisible(false);
        dryMealType.setFocusable(false);
        dryMealType.addActionListener(this);

        ButtonGroup mealTypeGroup = new ButtonGroup();
        mealTypeGroup.add(wetMealType);
        mealTypeGroup.add(dryMealType);

        //ilosc posilkow field settings
        noMealsText = new JTextField();
        noMealsText.setBounds(15, 190,150,20);
        noMealsText.setVisible(false);
        noMealsText.addActionListener(this);

        // wynik obliczen
        resultOneFoodText = new JLabel();
        resultOneFoodText.setBounds(15, 300, 200, 30);
        resultOneFoodText.setText("Result is: " + "40" + " g");
        resultOneFoodText.setForeground(Color.yellow);
        resultOneFoodText.setFont(new Font("Calibri", Font.BOLD, 20));
        resultOneFoodText.setVisible(false);

        resultMixFoodText = new JLabel();
        resultMixFoodText.setBounds(15, 300, 200, 30);
        resultMixFoodText.setText("Result is: " + "60" + " g");
        resultMixFoodText.setForeground(Color.yellow);
        resultMixFoodText.setFont(new Font("Calibri", Font.BOLD, 20));
        resultMixFoodText.setVisible(false);

        // ------------------- text fields end -------------------------- //


        // Calculate button settings
        calculateButton = new JButton("Calculate");
        calculateButton.setFocusable(false);
        calculateButton.setBounds(25, 260, 120, 30);
        calculateButton.setVisible(false);
        calculateButton.addActionListener(this);

        // adding components to TypeOfFoodPanel
        this.add(step2Text);

        this.add(catWeightLabel);
        this.add(catWeightText);

        this.add(wetFoodLabel);
        this.add(wetFoodText);

        this.add(dryMealType);
        this.add(wetMealType);

        this.add(noMealsLabel);
        this.add(noMealsText);

        this.add(resultOneFoodText);
        this.add(resultMixFoodText);

        this.add(calculateButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == calculateButton){
            //TODO
        } else if(source == dryMealType) {

        } else if(source == wetMealType) {

        }
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

    public JRadioButton getWetMealType() {
        return wetMealType;
    }

    public JRadioButton getDryMealType() {
        return dryMealType;
    }
}