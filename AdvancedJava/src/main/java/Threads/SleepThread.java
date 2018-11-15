package main.java.Threads;

public class SleepThread extends Thread {

    private int threadId;
    private TargetClass target;

    public SleepThread(int threadId, TargetClass target){
        this.threadId = threadId;
        this.target = target;
    }

    @Override
    public void run() {

        synchronized (target){
            try{
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        target.call(threadId);
    }
}
