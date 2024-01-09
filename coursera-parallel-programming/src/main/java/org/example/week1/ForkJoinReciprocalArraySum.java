package org.example.week1;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinReciprocalArraySum {




    public static void main(String[] args) {

        double[] x = new double[1_000_000_00];
        for (int i = 0; i < x.length; i++) {
            x[i] = new Random().nextDouble();
        }

        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "4");
        //37759700
        //32650100
        System.out.println(ForkJoinPool.commonPool().getParallelism());

        for (int i = 0; i < 5; i++) {
            System.out.printf("Run %s\n", i);
            seqArraySum(x);
            parArraySum(x);
        }
    }

    public static double seqArraySum(double[] x) {
        long startTime = System.nanoTime();
        double sum = 0;
        for (double v : x) {
            sum += 1 / v;
        }

        long timeInNanos = System.nanoTime() - startTime;
        printResults("seqArraySum", timeInNanos, sum);
        return sum;
    }

    public static double parArraySum(double[] x) {
        long startTime = System.nanoTime();
        SumArray t = new SumArray(x, 0, x.length);
        ForkJoinPool.commonPool().invoke(t);
        double sum = t.ans;
        long timeInNanos = System.nanoTime() - startTime;
        printResults("parArraySum", timeInNanos, sum);
        return sum;
    }

    private static void printResults(String seqArraySum, long timeInNanos, double sum) {
        System.out.printf(" %s completed in %s milliseconds, with sum = %8.5f \n", seqArraySum, timeInNanos, sum);
    }

    private static class SumArray extends RecursiveAction {
        static int SEQUENTIAL_THRESHOLD = 1000;
        int lo;
        int hi;
        double[] arr;
        double ans = 0;

        public SumArray(double[] arr, int lo, int hi) {
            this.lo = lo;
            this.hi = hi;
            this.arr = arr;
        }

        @Override
        protected void compute() {
            if (hi - lo <= SEQUENTIAL_THRESHOLD) {
                for (int i = lo; i < hi; ++i) {
                    ans += 1 / arr[i];
                }
            } else {
                SumArray left = new SumArray(arr, lo, (hi + lo) / 2);
                SumArray right = new SumArray(arr, (hi + lo) / 2, hi);
                left.fork();
                right.compute();
                left.join();
                ans = left.ans + right.ans;
            }
        }
    }
}
