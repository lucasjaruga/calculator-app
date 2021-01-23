package pl.jarugalucas;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Bidi;

/**
 * The {@code UserDataPanel} class is responsible for providing necessary elements of interface,
 * to allow the user to provide all important information about a cat.
 *
 * @author Lucas Jaruga
 * @version 1.0
 */
public class UserDataPanel extends JPanel implements ActionListener {

    private final JLabel step2Text;
    private final JLabel catWeightLabel;
    private final JLabel minCatWeightLabel;
    private final JLabel wetFoodLabel;
    private final JLabel noMealsLabel;
    private final JTextField wetFoodText;
    private final JTextField catWeightText;
    private final JTextField noMealsText;
    private final JRadioButton wetMealType;
    private final JRadioButton dryMealType;

    private final ButtonGroup jRadioButtons = new ButtonGroup();

    private final JLabel resultOneFoodText;
    private final JLabel resultMixFoodText;
    private final JButton calculateButton;

    private Boolean calculateWet = false;
    private Boolean calculateDry = false;

    private Double wetResult;
    private Double dryResult;
    private Double percentOfDryFood;

    public UserDataPanel(){

        /** Basic settings for {@code UserDataPanel} class */
        this.setLayout(null);
        this.setBackground(Color.darkGray);
        this.setBounds(300, 0, 485, 462);

        /** ================ Text labels settings starts here ================ */

        /** Step 2 text settings */
        step2Text = new JLabel("Step 2) PROVIDE INFORMATION ABOUT CAT AND FOOD");
        step2Text.setBounds(15, 10, 320, 40);
        step2Text.setForeground(Color.green);
        step2Text.setVisible(false);

        /** "WEIGHT OF CAT in grams (g)" text settings */
        catWeightLabel = new JLabel("WEIGHT OF CAT in grams (g)");
        catWeightLabel.setBounds(15, 35, 180, 40);
        catWeightLabel.setForeground(Color.yellow);
        catWeightLabel.setVisible(false);

        /** information for user about minimum weight of cat */
        minCatWeightLabel = new JLabel("value between 2 000 and 20 000");
        minCatWeightLabel.setBounds(180, 55, 200, 40);
        minCatWeightLabel.setForeground(Color.red);
        minCatWeightLabel.setVisible(false);

        /** text about how much food user wants to give to a cat */
        wetFoodLabel = new JLabel("HOW MUCH WET FOOD PER DAY");
        wetFoodLabel.setBounds(15, 85, 200, 40);
        wetFoodLabel.setForeground(Color.yellow);
        wetFoodLabel.setVisible(false);

        /** "NUMBER OF MEALS PER DAY" text settings */
        noMealsLabel = new JLabel("NUMBER OF MEALS PER DAY");
        noMealsLabel.setBounds(15, 135, 180, 40);
        noMealsLabel.setForeground(Color.yellow);
        noMealsLabel.setVisible(false);

        /** ================ Text labels settings ends here ================ */


        /** ================ Text fields settings starts here ================ */

        /** Cat Weight field settings */
        catWeightText = new JTextField();
        catWeightText.setBounds(15, 65,150,20);
        catWeightText.setVisible(false);

        /** Amount of wet food field settings */
        wetFoodText = new JTextField();
        wetFoodText.setBounds(15, 115,150,20);
        wetFoodText.setVisible(false);

        /** Settings for two radio buttons which allow user to define type of food to calculate */
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

        /** Adding both radio buttons to a group. It allows clearing selection any of them when it is necessary.
         * Check {@code TypeOfFoodPanel}, line 96 */
        ButtonGroup mealTypeGroup = new ButtonGroup();
        mealTypeGroup.add(wetMealType);
        mealTypeGroup.add(dryMealType);

        //ilosc posilkow field settings
        /** "Number of meals per day" text field settings */
        noMealsText = new JTextField();
        noMealsText.setBounds(15, 190,150,20);
        noMealsText.setVisible(false);
        noMealsText.addActionListener(this);

        // wynik obliczen
        /** result of calculations - text label settings, information which user gets at the end */
        resultOneFoodText = new JLabel();
        resultOneFoodText.setBounds(15, 300, 240, 30);
        resultOneFoodText.setForeground(Color.yellow);
        resultOneFoodText.setFont(new Font("Calibri", Font.BOLD, 20));
        resultOneFoodText.setVisible(false);

        resultMixFoodText = new JLabel();
        resultMixFoodText.setBounds(15, 300, 450, 30);
        resultMixFoodText.setForeground(Color.yellow);
        resultMixFoodText.setFont(new Font("Calibri", Font.BOLD, 20));
        resultMixFoodText.setVisible(false);

        /** ================ Text fields settings ends here ================ */


        /** >>Calculate<< button settings */
        calculateButton = new JButton("Calculate");
        calculateButton.setFocusable(false);
        calculateButton.setBounds(25, 260, 120, 30);
        calculateButton.setVisible(false);
        calculateButton.addActionListener(this);

        /** ================ Adding all components to {@code UserDataPanel} ================ */
        this.add(step2Text);

        this.add(catWeightLabel);
        this.add(catWeightText);
        this.add(minCatWeightLabel);

        this.add(wetFoodLabel);
        this.add(wetFoodText);

        jRadioButtons.add(dryMealType);
        jRadioButtons.add(wetMealType);
        this.add(dryMealType);
        this.add(wetMealType);

        this.add(noMealsLabel);
        this.add(noMealsText);

        this.add(resultOneFoodText);
        this.add(resultMixFoodText);

        this.add(calculateButton);

    }

    /** Implementation of method from an ActionListener interface,
     * to allow buttons and text fields to react on user actions. */
    @Override
    public void actionPerformed(ActionEvent e) {

        wetResult = 0.0;
        dryResult = 0.0;

        Object source = e.getSource();

        start:
        if(source == calculateButton){
            Algorithm algorithm = new Algorithm();

            String catWeight = catWeightText.getText();
            if(Integer.valueOf(catWeight) < 2000){
                JOptionPane.showMessageDialog(null, "Cat weight too low! Cat weight must be between 2000 g and 20 000 g!", "Weight to low", JOptionPane.WARNING_MESSAGE);
                break start;
            } else if (Integer.valueOf(catWeight) > 20000){
                JOptionPane.showMessageDialog(null, "Cat weight too high! Cat weight must be between 2000 g and 20 000 g!", "Weight to low", JOptionPane.WARNING_MESSAGE);
                break start;
            }

            if(Integer.valueOf(noMealsText.getText()) < 1 || Integer.valueOf(noMealsText.getText()) > 8){
                JOptionPane.showMessageDialog(null, "Number of meals is wrong! It must be at least 1 or maximum 8 meals per day", "Wrong meal number", JOptionPane.WARNING_MESSAGE);
                break start;
            }

            String noMeals = noMealsText.getText();

            if(calculateWet){
                Double finalResult;
                wetResult = algorithm.calculateWetFood(Integer.valueOf(catWeight));
                finalResult = wetResult / Double.valueOf(noMeals);
                finalResult = roundResult(finalResult);
                resultOneFoodText.setText("Result is: " + finalResult + " g per meal.");
                resultOneFoodText.setVisible(true);
            } else if(calculateDry){
                Double finalResult;
                dryResult = algorithm.calculateDryFood(Integer.valueOf(catWeight));
                finalResult = dryResult / Double.valueOf(noMeals);
                finalResult = roundResult(finalResult);
                resultOneFoodText.setText("Result is: " + finalResult + " g per meal.");
                resultOneFoodText.setVisible(true);
            } else {
                wetResult = algorithm.calculateWetFood(Integer.valueOf(catWeight));
                String wetFood = wetFoodText.getText();

                if(Double.valueOf(wetFood) > wetResult){
                    JOptionPane.showMessageDialog(null, "You want to give TOO MUCH wet food to your cat! Lower wet food value. \n\n It must be at most " + wetResult, "Too much wet food", JOptionPane.WARNING_MESSAGE);
                    break start;
                }

                dryResult = algorithm.calculateDryFood(Integer.valueOf(catWeight));
                percentOfDryFood = algorithm.calculatePercentOfDryFood(wetResult, dryResult, wetFoodText);
                resultMixFoodText.setText("Result is: " + roundResult(Double.valueOf(wetFoodText.getText()) / Double.valueOf(noMeals))  + "g wet food and " + roundResult(percentOfDryFood / Double.valueOf(noMeals)) +" g dry food per meal.");
                resultMixFoodText.setVisible(true);
            }

        } else if(source == dryMealType) {
            calculateDry = true;
            calculateWet = false;

        } else if(source == wetMealType) {
            calculateWet = true;
            calculateDry = false;
        }
    }

    // method for rounding results
    private static double roundResult(Double result){
        double roundedValue = Math.round(result);
        return roundedValue;
    }

    public JLabel getStep2Text() {
        return step2Text;
    }

    public JLabel getCatWeightLabel() {
        return catWeightLabel;
    }

    public JLabel getMinCatWeightLabel() {
        return minCatWeightLabel;
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

    public JButton getCalculateButton() {
        return calculateButton;
    }

    public JRadioButton getWetMealType() {
        return wetMealType;
    }

    public JRadioButton getDryMealType() {
        return dryMealType;
    }

    public JLabel getResultMixFoodText() {
        return resultMixFoodText;
    }

    public JLabel getResultOneFoodText() {
        return resultOneFoodText;
    }

    public void setCalculateWet(Boolean calculateWet) {
        this.calculateWet = calculateWet;
    }

    public void setCalculateDry(Boolean calculateDry) {
        this.calculateDry = calculateDry;
    }

    public ButtonGroup getJRadioButtons() {
        return jRadioButtons;
    }
}