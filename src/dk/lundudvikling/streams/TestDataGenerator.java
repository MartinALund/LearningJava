package dk.lundudvikling.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestDataGenerator {


    public List<TestData> getData(int amount){
        List<TestData> testData = new ArrayList<>();
        for (int i = 0; i < amount; i++){
            testData.add(new TestData(UUID.randomUUID().toString(), 1, String.valueOf(i)));
        }
        return testData;
    }
}
