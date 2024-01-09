package org.example.week1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] x = new int[1_000_000_000];
        Arrays.fill(x, 1);

        System.out.println("Started");
        long startTime = System.currentTimeMillis();
        ASum aSum = new ASum(x, 0, x.length - 1);
        aSum.compute();
        long timeInNanos = System.currentTimeMillis() - startTime;
        printResults(timeInNanos, aSum.getSUM());

    }

    private static void printResults(long timeInNanos, double sum) {
        System.out.printf("Completed in %s milliseconds, with sum = %8.5f \n", timeInNanos, sum);
    }
}
