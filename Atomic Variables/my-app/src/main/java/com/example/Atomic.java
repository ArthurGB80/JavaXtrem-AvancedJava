package com.example;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {

    /**
     * Atomic variables and concurrency. 
     * @param args an array of command-line arguments passed to the program
     * @throws InterruptedException when a thread is waiting, sleeping, or otherwise
     * occupied, and the thread is interrupted
     */

    public static void main(String[] args) throws InterruptedException {
        /*
         * System.out.println("Start");
         * Thread.sleep(2000);
         * System.out.println("Stop");
         */

        Counter counter = new Counter();

        Thread first = new Thread(counter, "First");
        Thread second = new Thread(counter, "Second");

        first.start();
        second.start();

        first.join();
        second.join();

        System.out.println(counter.count);

    }

    static class Counter extends Thread {
        public AtomicInteger count = new AtomicInteger();

        public void run() {
            for (int i = 0; i < 100_000_000; i++) {
                count.addAndGet(1);
            }
        }
    }

}
