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
        sortMethod(animals);
        forEachMethod(animals);
        printFirst(animals);
        summarizeInt(animals);
    }

    private static void filterMethod(List<Animal> animals, String string){
        animals = animals
                .stream()
                .filter(x -> x.name.startsWith(string))
                .collect(Collectors.toList());
        printAllAnimals(animals);
    }
    private static void sortMethod(List<Animal> animals){
        animals = animals
                .stream()
                .sorted()
                .collect(Collectors.toList());
        printAllAnimals(animals);
    }

    private static void printAllAnimals(List<Animal> animals){
        animals.forEach(System.out::println);
    }

    private static void forEachMethod(List<Animal> animals){
        animals.stream().map(x -> x.maxAge).forEach(System.out::println);
        animals.stream().map(y -> y.name).forEach(System.out::println);
    }

    private static void printFirst(List<Animal> animals){
        animals
                .stream()
                .findFirst()
                .ifPresent(System.out::println);

        //Find first, or else return null (if not found)
        Animal animal = animals.stream().findFirst().orElse(null);
        System.out.println(animal.name);
    }

    private static void summarizeInt(List<Animal> animals){
        IntSummaryStatistics ageSummary = animals
                .stream()
                .collect(Collectors.summarizingInt(a -> a.maxAge));

        System.out.println(ageSummary);
        System.out.println(ageSummary.getMax());
    }
}
