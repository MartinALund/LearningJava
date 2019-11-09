package dk.lundudvikling.builders;

public class Singleton {

    private static final Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }

    public void methodToTest(){
        System.out.println("Test");
    }
}
