package dk.lundudvikling;

import dk.lundudvikling.Pizza.Topping;

public class Main {

    public static void main(String[] args) {
        // Regular Builder
        NutritionFacts cocaCola = new NutritionFacts.Builder(240,8, "Coca Cola").calories(100).sodium(150).carbohydrate(15).build();
        Person person = new Person.Builder("Martin", "Lund").age(27).phoneNumber("50598384").build();
        System.out.println(person);

        //Abstract Builder
        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.LARGE).addTopping(Topping.ONION).addTopping(Topping.SAUSAGE).build();
        Calzone calzone = new Calzone.Builder().addTopping(Topping.HAM).sauceInside().build();

        Singleton.getInstance().methodToTest();
        EnumSingleton.instance.methodToTest();
    }
}
