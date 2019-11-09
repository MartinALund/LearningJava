package dk.lundudvikling.streams;

import dk.lundudvikling.Person;

import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Dog", 16, "ABC"));
        animals.add(new Animal("Cat", 27, "ABCDE"));
        animals.add(new Animal("Tiger", 9, "UNIKID"));
        animals.add(new Animal("Turtle", 100, "ID"));
        filterMethod(animals, "T");
        filterMethod(animals, "Ca");
        sortMethod(animals);
        forEachMethod(animals);
        printFirst(animals);
        summarizeInt(animals);
        stringJoiner(animals);
        oldestAnimal(animals);
        findById(animals, "ABC");
    }

    private static void filterMethod(List<Animal> animals, String string){
        System.out.println("Filter animals starting with: " + string);
        animals = animals
                .stream()
                .filter(x -> x.name.startsWith(string))
                .collect(Collectors.toList());
        printAllAnimals(animals);
        System.out.println();
    }

    private static void findById(List<Animal> animals, String idToFind){
        System.out.println("Searching for id: " + idToFind);
        Animal animal = animals
                .stream()
                .filter(anim -> anim.getId().equals(idToFind))
                .findAny()
                .orElse(null);

        System.out.println("Found animal by id: " + animal);
        System.out.println();
    }
    private static void sortMethod(List<Animal> animals){
        System.out.println("Sorting animals by name");
        animals = animals
                .stream()
                .sorted()
                .collect(Collectors.toList());
        printAllAnimals(animals);
        System.out.println();
    }

    private static void printAllAnimals(List<Animal> animals){
        animals.forEach(System.out::println);
    }

    private static void forEachMethod(List<Animal> animals){
        System.out.println("For each");
        animals.stream().map(x -> x.maxAge).forEach(System.out::println);
        animals.stream().map(y -> y.name).forEach(System.out::println);
        System.out.println();
    }

    private static void printFirst(List<Animal> animals){
        System.out.println("Print first");
        animals
                .stream()
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println();
    }

    private static void summarizeInt(List<Animal> animals){
        System.out.println("Sum int");
        IntSummaryStatistics ageSummary = animals
                .stream()
                .collect(Collectors.summarizingInt(a -> a.maxAge));

        System.out.println(ageSummary);
        System.out.println(ageSummary.getMax());
        System.out.println();
    }

    private static void stringJoiner(List<Animal> animals){
        System.out.println("StringJoiner");
        Collector<Animal, StringJoiner, String> animalNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),          // supplier
                        (stringJoiner, animal) -> stringJoiner.add(animal.name.toUpperCase()),  // accumulator
                        StringJoiner::merge,               // combiner
                        StringJoiner::toString);                // finisher

        String names = animals
                .stream()
                .collect(animalNameCollector);
        System.out.println(names);
        System.out.println();
    }

    private static void oldestAnimal(List<Animal> animals){
        System.out.println("Find oldest");
        animals
                .stream()
                .reduce((animal1, animal2) -> animal1.maxAge > animal2.maxAge ? animal1 : animal2)
                .ifPresent(System.out::println);
        System.out.println();
    }
}
