package dk.lundudvikling.streams;

import java.util.List;
import java.util.stream.Collectors;

public class MainTest {

    public static void main(String[] args){
        TestDataGenerator testDataGenerator = new TestDataGenerator();
        List<TestData> testData = testDataGenerator.getData(100);
        distinct(testData);
        streamFindById(testData, "99");
        collectionFindById(testData, "101");
    }

    private static void distinct(List<TestData> testData){
        System.out.println("Data id: " + testData.size());
        List<TestData> distinctElements = testData.stream().distinct().collect(Collectors.toList());
        System.out.println("Distinct data id: " + distinctElements.size());

    }

    public static void collectionFindById(List<TestData> testData, String idToFind){
        TestData foundTestData = null;
        for (TestData data : testData){
            if (data.getId().equals(idToFind)){
                foundTestData = data;
                break;
            }
        }
        System.out.println(foundTestData != null ? "Found data: " + foundTestData.getName() :"Did not find data");
    }

    public static void streamFindById(List<TestData> testData, String idToFind){
        TestData data = testData
                .stream()
                .filter(d -> d.getId().equals(idToFind))
                .findAny()
                .orElse(null);
        System.out.println(data != null ? "Found data: " + data.getName() :"Did not find data");
    }
}
