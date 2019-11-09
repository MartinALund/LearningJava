package dk.lundudvikling;

import java.util.UUID;

public enum UUIDGenerator {

    INSTANCE;

    public String getRandomUUID(){
        return UUID.randomUUID().toString();
    }
}
