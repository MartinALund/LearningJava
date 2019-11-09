package dk.lundudvikling.builders;


// Builder Pattern
// Item2
// Giver kun mening at bruge når man har mange parametre, eventuelt med mange optional.
public class NutritionFacts {

    private final String name;
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;


    public static class Builder {
        //Required parameters
        private final int servingSize;
        private final int servings;
        private final String name;

        //optional params - initialized to default value

        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings, String name){
            this.servingSize = servingSize;
            this.servings = servings;
            this.name = name;
        }

        public Builder calories(int val){
            calories = val;
            return this;
        }

        public Builder fat(int val){
            fat = val;
            return this;
        }

        public Builder sodium(int val){
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val){
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
        name = builder.name;
    }

    public String toString(){
        return String.format("%s - serving size: %d, servings: %d", name, servingSize, servings);
    }
}
