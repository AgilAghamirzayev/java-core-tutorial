package org.example.week4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Demostration {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Phaser phaser = new Phaser(1);

        try {
            executorService.submit(phaser::register);
            // main thread bulk-registers two more parties
            phaser.bulkRegister(2);

            // main thread registering one more party.
            phaser.register();

            // we now have 5 parties registered with the Phaser instance
            // we instantiate four threads and have them arrive at the barrier
            for (int i = 0; i < 4; i++) {
                executorService.submit(() -> {
                    phaser.arriveAndAwaitAdvance();
                    System.out.println(Thread.currentThread().getName() + " moving past barrier.");
                });
            }

            // sleep for a while so that previous threads can arrive at the barrier
            Thread.sleep(2000);

            // before arriving at the barrier, print the counts of parties
            System.out.println(Thread.currentThread().getName() + " just before arrived. \n Arrived parties: " + phaser.getArrivedParties() +
                    "\n Registered parties: " + phaser.getRegisteredParties() +
                    "\n Unarrived parties: " + phaser.getUnarrivedParties());
            phaser.arriveAndAwaitAdvance();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // remember to shutdown the executor in a finally block
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.HOURS);
        }
        Runtime.getRuntime().availableProcessors();
        // main thread prints party counts for the barrier
        System.out.println(Thread.currentThread().getName() + " exiting. \n Arrived parties: " + phaser.getArrivedParties() +
                "\n Registered parties: " + phaser.getRegisteredParties() +
                "\n Unarrived parties: " + phaser.getUnarrivedParties());
    }
}
