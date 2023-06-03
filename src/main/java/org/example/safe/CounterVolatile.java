package org.example.safe;

public class CounterVolatile extends Thread{
    public volatile static int count = 0;

    // method which would be called upon
    // the start of execution of a thread
    public void  run()
    {
        int max = 1_000_0;
        // incrementing counter total of max times
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
