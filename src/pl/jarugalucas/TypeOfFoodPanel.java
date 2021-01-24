package pl.jarugalucas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The {@code TypeOfFoodPanel} class is mainly responsible for allowing user to choose which type of food wants to calculate.
 * It provides two clickable buttons for that purpose.
 *
 * @author Lucas Jaruga
 * @version 1.0
 */
public class TypeOfFoodPanel extends JPanel implements ActionListener {

    private final JButton mixFoodButton;

    public TypeOfFoodPanel(){

        JButton dryWetButton;
        JLabel chooseTypeOfFoodText;
        JLabel step1Text;

        /* Basic settings for {@code TypeOfFoodPanel} class */
        this.setLayout(null);
        this.setBounds(0,0,300, 462);
        this.setBackground(Color.gray);

        /* ================ Text fields settings ================ */

        /* Step 1 text settings */
        step1Text = new JLabel("Step 1)");
        step1Text.setBounds(5, 10, 100, 40);
        step1Text.setForeground(Color.green);

        /* chooseTypeOfFoodText text settings */
        chooseTypeOfFoodText = new JLabel("CHOOSE THE TYPE OF FOOD TO CALCULATE");
        chooseTypeOfFoodText.setBounds(30, 30, 290, 40);
        chooseTypeOfFoodText.setForeground(Color.orange);

        /* ================ Buttons settings ================ */

        /* >>Dry/wet food<< button settings */
        dryWetButton = new JButton();
        dryWetButton.setText("Dry / wet food");
        dryWetButton.setBounds(88,70, 115, 40);
        dryWetButton.setFocusable(false);
        dryWetButton.addActionListener(this);

        /* >>Mix food<< button settings */
        mixFoodButton = new JButton();
        mixFoodButton.setText("Mix food");
        mixFoodButton.setBounds(100,120, 90, 40);
        mixFoodButton.setFocusable(false);
        mixFoodButton.addActionListener(this);

        /* Adding dryWetButton and mixButton to {@code TypeOfFoodPanel} */
        this.add(step1Text);
        this.add(chooseTypeOfFoodText);
        this.add(dryWetButton);
        this.add(mixFoodButton);
    }

    /** Implementation of method from an {@code ActionListener} interface, to allow buttons to react on user actions.
     * Also to control which parts of {@code UserDataPanel} class are showed to user, based on which button was clicked. */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO improve logic here

        /* lines 69 to 82 show user a common information which are the same for Dry/Wet Food and Mix Food.
         * So no need to assign those to concrete button */
        UserDataPanel userDataPanel = MainFrame.getUserDataPanel();
        userDataPanel.getStep2Text().setVisible(true);

        Object whichButton = e.getSource();

        userDataPanel.getCatWeightLabel().setVisible(true);
        userDataPanel.getCatWeightText().setVisible(true);
        userDataPanel.getNoMealsLabel().setVisible(true);
        userDataPanel.getNoMealsText().setVisible(true);
        userDataPanel.getCalculateButton().setVisible(true);
        userDataPanel.getWetMealType().setVisible(true);
        userDataPanel.getDryMealType().setVisible(true);
        userDataPanel.getMinCatWeightLabel().setVisible(true);

        /* based on which button user used, show needed elements from {@code UserDataPanel} class */
        if(whichButton == mixFoodButton) {
            userDataPanel.getWetFoodLabel().setVisible(true);
            userDataPanel.getWetFoodText().setVisible(true);
            userDataPanel.getWetMealType().setVisible(false);
            userDataPanel.getDryMealType().setVisible(false);
            userDataPanel.getResultOneFoodText().setVisible(false);
            userDataPanel.setCalculateDry(false);
            userDataPanel.setCalculateWet(false);
        } else {
            userDataPanel.getJRadioButtons().clearSelection();
            userDataPanel.setCalculateWet(true);
            userDataPanel.getWetFoodLabel().setVisible(false);
            userDataPanel.getWetFoodText().setVisible(false);
            userDataPanel.getResultMixFoodText().setVisible(false);
        }

    }
}