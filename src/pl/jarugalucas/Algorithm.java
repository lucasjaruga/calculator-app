package pl.jarugalucas;

import javax.swing.*;

/**
 * The {@code Algorithm} class provides methods to calculate amount of food which user should give a cat.
 * It uses some base values from Gussto and Feringa labels (cat food producers).
 * This class should only be used while calculating food for adult cat. It's not prepared for kittens.
 *
 * @version 1.0
 * @author Lucas Jaruga
 */
public final class Algorithm {

    private final Integer minCatWeight = 2000;
    // TODO remove maxCatWeight or redesign it
    private final Integer maxCatWeight = 20000;
    private final Integer baseAmountOfWet = 150;
    private final Integer baseAmountOfDry = 40;
    private final Double wetFoodMultiplier = 0.025;
    private final Double dryFoodMultiplier = 0.01;

    /**
     * Method to calculate wet food based on catWeight
     *
     * @param catWeight - an Integer value which represents cat's weight in grams
     * @return a Double value which represents amount of wet food for cat per day
     */
    public Double calculateWetFood(Integer catWeight){

        Double result = 0.0;
        Integer weightDifference = catWeight - minCatWeight;
        Double amountToAdd = weightDifference * wetFoodMultiplier;
        Double amountOfFood = baseAmountOfWet + amountToAdd;
        result = amountOfFood;

        return result;
    }

    /**
     * Method to calculate dry food based on catWeight and noMeals
     *
     * @param catWeight - an Integer value which represents cat's weight in grams
     * @return a Double value which represents amount of dry food for cat per day
     */
    public Double calculateDryFood(Integer catWeight){

        Double result = 0.0;
        Integer weightDifference = catWeight - minCatWeight;
        Double amountToAdd = weightDifference * dryFoodMultiplier;
        Double amountOfFood = baseAmountOfDry + amountToAdd;
        result = amountOfFood;

        return result;
    }

    /**
     * Method to calculate how much a dry food should get a cat based on amount of a wet food which user want to give a cat
     *
     * @param wetResult - a Double value which represents how much wet food should get cat if it only get wet food
     * @param dryResult  - a Double value which represents how much dry food should get cat if it only get dry food
     * @param wetFoodText - a JTextField object which stores String user input value of how much wet food owner wants to give to a cat
     * @return a Double which represents amount of dry food to give a cat per day
     */
    public Double calculatePercentOfDryFood(Double wetResult, Double dryResult, JTextField wetFoodText){

        Double result = 0.0;
        Double amountOfWet = Double.parseDouble(wetFoodText.getText());
        Double dailyNeeds = amountOfWet / wetResult;
        Double percentOfDryFood = 1.0 - dailyNeeds;
        result = dryResult * percentOfDryFood;

        return result;
    }
}