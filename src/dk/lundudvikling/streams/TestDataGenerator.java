package dk.lundudvikling.streams;

import dk.lundudvikling.UUIDGenerator;

import java.util.ArrayList;
import java.util.List;

public class TestDataGenerator {


    public List<TestData> getData(int amount){
        List<TestData> testData = new ArrayList<>();
        for (int i = 0; i < amount; i++){
            testData.add(new TestData(UUIDGenerator.INSTANCE.getRandomUUID(), 1, String.valueOf(i)));
        }
        return testData;
    }
}
