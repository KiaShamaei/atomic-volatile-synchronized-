package org.example;

import org.example.safe.CounterAtomic;
import org.example.safe.CounterSync;
import org.example.safe.CounterVolatile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App 
{
    public static void main ( String[] args ) throws InterruptedException {
        System.out.println( "In this example main is execute " +
                "all condition you dont need springBoot" );
        SpringApplication.run(App.class,args);
        //call in safe thread situation
        //we expect 2000000 but result is different
        // Instance of Counter Class
//        Counter c = new Counter();
//        CounterAtomic c = new CounterAtomic();
//        CounterSync c = new CounterSync();
        CounterVolatile c = new CounterVolatile();

        // Defining Two different threads
        Thread first = new Thread(c, "First");
        Thread second = new Thread(c, "Second");


        // Threads start executing
        first.start();
        second.start();


        // main thread will wait for
        // both threads to get completed
        first.join();
        second.join();

        // Printing final value of count variable
        System.out.println(c.count);


    }
}
