package org.example.safe;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterAtomic extends Thread{
        // Atomic counter Variable
      public AtomicInteger count;

        // Constructor of class
        public CounterAtomic()
        {
            count = new AtomicInteger();
        }

        // method which would be called upon
        // the start of execution of a thread
        public void run()
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
                count.addAndGet(1);
            }
        }
}

