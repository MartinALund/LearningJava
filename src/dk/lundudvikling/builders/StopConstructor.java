package dk.lundudvikling.builders;

public class StopConstructor {

    /* Default normal constructor
    public StopConstructor(){
        System.out.println("Constructor");
    }
    */

    //Private constructor to prevent class from being instantiated

    private StopConstructor(){
        throw new AssertionError();
    }
}
