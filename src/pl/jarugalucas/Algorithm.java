package pl.jarugalucas;

import javax.swing.*;

public final class Algorithm {

    private final Integer minCatWeight = 2000;
    private final Integer maxCatWeight = 20000;
    private final Integer baseAmountOfWet = 150;
    private final Integer baseAmountOfDry = 40;
    private final Double wetFoodMultiplier = 0.025;
    private final Double dryFoodMultiplier = 0.01;

    public Algorithm() {
    }

    public Double calculateWetFood(Integer catWeight, Integer noMeals){

        Double result = 0.0;

        Integer x = catWeight - minCatWeight;
        Double amountToAdd = x * wetFoodMultiplier;
        Double amountOfFood = baseAmountOfWet + amountToAdd;
        result = amountOfFood;

        return result;
    }

    public Double calculateDryFood(Integer catWeight, Integer noMeals){

        Double result = 0.0;

        Integer x = catWeight - minCatWeight;
        Double amountToAdd = x * dryFoodMultiplier;
        Double amountOfFood = baseAmountOfDry + amountToAdd;
        result = amountOfFood;

        return result;
    }

    //TODO implement mix food method
    public Double calculatePercentOfDryFood(Double wetResult, Double dryResult, JTextField wetFoodText){

        Double result = 0.0;

        //todo
        Double amountOfWet = Double.parseDouble(wetFoodText.getText());
        Double dailyNeeds = amountOfWet / wetResult;
        Double percentOfDryFood = 1.0 - dailyNeeds;

        result = dryResult * percentOfDryFood;


        return result;
    }

}