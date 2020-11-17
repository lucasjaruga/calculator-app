package pl.jarugalucas;

public final class Algorithm {

    private final Integer minCatWeight = 2000;
    private final Integer maxCatWeight = 20000;
    private final Integer baseAmountOfWet = 150;
    private final Integer baseAmountOfDry = 40;
    private final Double wetFoodMultiplier = 0.025;
    private final Double dryFoodMultiplier = 0.01;

    private UserDataPanel userDataPanel;

    public Algorithm() {
        userDataPanel = MainFrame.getUserDataPanel();
    }

    public Double calculateWetFood(Integer catWeight, Integer noMeals){

        Double result = 0.0;

        Integer x = catWeight - minCatWeight;
        Double amountToAdd = x * wetFoodMultiplier;
        Double amountOfFood = baseAmountOfWet + amountToAdd;
        result = amountOfFood / noMeals;

        return result;
    }

    public Double calculateDryFood(Integer catWeight, Integer noMeals){

        Double result = 0.0;

        Integer x = catWeight - minCatWeight;
        Double amountToAdd = x * dryFoodMultiplier;
        Double amountOfFood = baseAmountOfDry + amountToAdd;
        result = amountOfFood / noMeals;

        return result;
    }

    //TODO implement mix food method
    public Integer calculateMixFood(Integer catWeight, Integer noMeals){

        Integer result = 0;

        //todo






        return result;
    }

}