package dk.lundudvikling.modernjava.comparator;

import dk.lundudvikling.models.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args){

        List<Person> people = new ArrayList<>();
        people.add(new Person("Martin", "Lund", 29));
        people.add(new Person("Test", "Testesen", 999));
        people.add(new Person("Martin", "Abc", 123));

        people.forEach(p -> System.out.println(p.toString()));
        sortByProperty(people);
        people.forEach(p -> System.out.println(p.toString()));

    }

    private static void sortByProperty(List<Person> listToSort){
        listToSort.sort(Comparator.comparing(Person::getLastName));
    }
}
