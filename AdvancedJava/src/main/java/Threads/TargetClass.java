package main.java.Threads;

public class TargetClass {

    public void call(int threadId){
        System.out.println("Calling thread from: " + threadId);
    }
}
