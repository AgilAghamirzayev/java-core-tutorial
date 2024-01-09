package org.example.week4;

import java.util.concurrent.Phaser;

public class LongRunningAction implements Runnable {

    private final String threadName;
    private final Phaser phaser;

    public LongRunningAction(String threadName, Phaser phaser) {
        this.threadName = threadName;
        this.phaser = phaser;
        randomWait();
        phaser.register();
        System.out.printf("Thread %s registered during phase %s\n", threadName, phaser.getPhase());
    }

    @Override
    public void run() {
        System.out.printf("Thread %s BEFORE long running action in phase %s\n", threadName, phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
        randomWait();
        System.out.printf("Thread %s AFTER long running action in phase %s\n", threadName, phaser.getPhase());
        phaser.arriveAndDeregister();
    }

    // Simulating real work
    private void randomWait() {
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
