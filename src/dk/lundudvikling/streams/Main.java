package dk.lundudvikling.streams;

import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args){
        List<TestData> testData = new ArrayList<>();
        testData.add(new TestData("Dog", 16, "ABC"));
        testData.add(new TestData("Cat", 27, "ABCDE"));
        testData.add(new TestData("Tiger", 9, "UNIKID"));
        testData.add(new TestData("Turtle", 100, "ID"));
        parallelStream(testData);
        getStream(testData);
        filterMethod(testData, "T");
        filterMethod(testData, "Ca");
        sortMethod(testData);
        forEachMethod(testData);
        printFirst(testData);
        summarizeInt(testData);
        stringJoiner(testData);
        findOldestData(testData);
        findById(testData, "ABC");
    }

    private static void getStream(List<TestData> testData){
        Stream<TestData> dataStream = testData.stream();
        System.out.println(dataStream.findFirst());
    }

    private static void parallelStream(List<TestData> testData){
        testData.parallelStream().forEach(Main::print);
    }

    private static void print(TestData testData){
        System.out.println(testData.getName());
    }

    private static void filterMethod(List<TestData> testData, String string){
        System.out.println("Filter data starting with: " + string);
        testData = testData
                .stream()
                .filter(x -> x.name.startsWith(string))
                .collect(Collectors.toList());
        printAllData(testData);
        System.out.println();
    }

    private static void findById(List<TestData> testData, String idToFind){
        System.out.println("Searching for id: " + idToFind);
        TestData data = testData
                .stream()
                .filter(d -> d.getId().equals(idToFind))
                .findAny()
                .orElse(null);

        System.out.println("Found data by id: " + data);
        System.out.println();
    }
    private static void sortMethod(List<TestData> testData){
        System.out.println("Sorting data by name");
        testData = testData
                .stream()
                .sorted()
                .collect(Collectors.toList());
        printAllData(testData);
        System.out.println();
    }

    private static void printAllData(List<TestData> testData){
        testData.forEach(System.out::println);
    }

    private static void forEachMethod(List<TestData> testData){
        System.out.println("For each");
        testData.stream().map(x -> x.maxAge).forEach(System.out::println);
        testData.stream().map(y -> y.name).forEach(System.out::println);
        System.out.println();
    }

    private static void printFirst(List<TestData> testData){
        System.out.println("Print first");
        testData
                .stream()
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println();
    }

    private static void summarizeInt(List<TestData> testData){
        System.out.println("Sum int");
        IntSummaryStatistics ageSummary = testData
                .stream()
                .collect(Collectors.summarizingInt(a -> a.maxAge));

        System.out.println(ageSummary);
        System.out.println(ageSummary.getMax());
        System.out.println();
    }

    private static void stringJoiner(List<TestData> testData){
        System.out.println("StringJoiner");
        Collector<TestData, StringJoiner, String> dataCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),          // supplier
                        (stringJoiner, data) -> stringJoiner.add(data.name.toUpperCase()),  // accumulator
                        StringJoiner::merge,               // combiner
                        StringJoiner::toString);                // finisher

        String names = testData
                .stream()
                .collect(dataCollector);
        System.out.println(names);
        System.out.println();
    }

    private static void findOldestData(List<TestData> testData){
        System.out.println("Find oldest");
        testData
                .stream()
                .reduce((testData1, testData2) -> testData1.maxAge > testData2.maxAge ? testData1 : testData2)
                .ifPresent(System.out::println);
        System.out.println();
    }
}
