package com.coursera.week1;

import java.util.Random;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BowLoop implements Runnable{
    private final Friend bower;
    private final Friend bowee;

    @Override
    public void run() {
        Random random = new Random();
        for (; ; ) {
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException ignored) {
            }
            bowee.bow(bower);
        }
    }
}
