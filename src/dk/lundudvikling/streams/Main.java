package dk.lundudvikling.streams;

import dk.lundudvikling.Person;

import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Dog", 16));
        animals.add(new Animal("Cat", 27));
        animals.add(new Animal("Tiger", 9));
        animals.add(new Animal("Turtle", 100));
        filterMethod(animals, "T");
        filterMethod(animals, "Ca");
    }

    private static void filterMethod(List<Animal> animals, String string){
        animals = animals
                .stream()
                .filter(x -> x.name.startsWith(string))
                .collect(Collectors.toList());

        for (Animal animal : animals){
            System.out.println(animal);
        }
    }
}
