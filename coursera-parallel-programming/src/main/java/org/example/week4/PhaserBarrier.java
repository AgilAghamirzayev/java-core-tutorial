package org.example.week4;

import java.util.concurrent.Phaser;

public class PhaserBarrier {
    public static void main(String[] args) {
        for (int numRun = 0; numRun < 3; numRun++) {
            System.out.printf("Run %d:\n", numRun);
            Phaser ph0 = new Phaser(1);
            Phaser ph1 = new Phaser(1);
            Phaser ph2 = new Phaser(1);

            Thread t0 = new Thread(() -> {
                doWork(100);
                ph0.arrive();
                ph1.awaitAdvance(0);
                doWork(300);
            });

            Thread t1 = new Thread(() -> {
                doWork(200);
                ph1.arrive();
                ph0.awaitAdvance(0);
                ph2.awaitAdvance(0);
                doWork(200);
            });


            Thread t2 = new Thread(() -> {
                doWork(300);
                ph2.arrive();
                ph1.awaitAdvance(0);
                doWork(100);
            });

            long startTime = System.nanoTime();
            doWork(100);
            doWork(300);

            doWork(200);
            doWork(200);

            doWork(300);
            doWork(100);

            long timeInNanos = System.nanoTime() - startTime;
            System.out.printf("Sequential %8.3f seconds\n", timeInNanos / 1e9);

            startTime = System.nanoTime();

            t0.start();
            t1.start();
            t2.start();

            // wait threads to complete
            try {
                t0.join();
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            timeInNanos = System.nanoTime() - startTime;
            System.out.printf("Parallel %8.3f seconds\n", timeInNanos / 1e9);

        }
    }

    private static void doWork(int millis) {
        try {
            System.out.println(Thread.currentThread().getName() + " - millis: " + millis);
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
