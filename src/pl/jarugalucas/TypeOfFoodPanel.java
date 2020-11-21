package pl.jarugalucas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TypeOfFoodPanel extends JPanel implements ActionListener {

    private JButton dryWetButton;
    private JButton mixButton;
    private JLabel chooseTypeOfFoodText;
    private JLabel step1Text;

    public TypeOfFoodPanel(){

        // basic settings for TypeOfFoodPanel
        this.setLayout(null);
        this.setBounds(0,0,300, 462);
        this.setBackground(Color.gray);

        //Step1 text settings
        step1Text = new JLabel("Step 1)");
        step1Text.setBounds(5, 10, 100, 40);
        step1Text.setForeground(Color.green);

        //TypeOfFood text settings
        chooseTypeOfFoodText = new JLabel("CHOOSE THE TYPE OF FOOD TO CALCULATE");
        chooseTypeOfFoodText.setBounds(30, 30, 290, 40);
        chooseTypeOfFoodText.setForeground(Color.orange);

        //dry food button settings
        dryWetButton = new JButton();
        dryWetButton.setText("Dry / wet food");
        dryWetButton.setBounds(88,70, 115, 40);
        dryWetButton.setFocusable(false);
        dryWetButton.addActionListener(this);

        //mix food button settings
        mixButton = new JButton();
        mixButton.setText("Mix food");
        mixButton.setBounds(100,120, 90, 40);
        mixButton.setFocusable(false);
        mixButton.addActionListener(this);

        // adding components to TypeOfFoodPanel

        this.add(step1Text);
        this.add(chooseTypeOfFoodText);
        this.add(dryWetButton);
        this.add(mixButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        UserDataPanel userDataPanel = MainFrame.getUserDataPanel();
        userDataPanel.getStep2Text().setVisible(true);

        Object source = e.getSource();

        userDataPanel.getCatWeightLabel().setVisible(true);
        userDataPanel.getCatWeightText().setVisible(true);
        userDataPanel.getNoMealsLabel().setVisible(true);
        userDataPanel.getNoMealsText().setVisible(true);
        userDataPanel.getCalculateButton().setVisible(true);
        userDataPanel.getWetMealType().setVisible(true);
        userDataPanel.getDryMealType().setVisible(true);

        if(source == mixButton) {
            userDataPanel.getWetFoodLabel().setVisible(true);
            userDataPanel.getWetFoodText().setVisible(true);
            userDataPanel.getWetMealType().setVisible(false);
            userDataPanel.getDryMealType().setVisible(false);
            userDataPanel.getResultOneFoodText().setVisible(false);
            userDataPanel.setCalculateDry(false);
            userDataPanel.setCalculateWet(false);
        } else {
            userDataPanel.getWetFoodLabel().setVisible(false);
            userDataPanel.getWetFoodText().setVisible(false);
            userDataPanel.getResultMixFoodText().setVisible(false);
            userDataPanel.getMinCatWeightLabel().setVisible(true);
        }
    }

}