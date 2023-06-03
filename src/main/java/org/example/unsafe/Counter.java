package org.example.unsafe;


//we want to use this class in multiple thread so extends thread
public class Counter extends Thread {
    // Counter Variable
    public int count = 0;

    // method which would be called upon
    // the start of execution of a thread
    public void run()
    {
       int max = 1000;

        // incrementing counter
        // total of max times
        for (int i = 0; i < max; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thread name ..."+this.currentThread().getId());
            System.out.println("counter ..." + i);
            count++;
        }
    }
}
