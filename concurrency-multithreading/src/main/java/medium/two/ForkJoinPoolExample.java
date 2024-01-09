package medium.two;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolExample {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(ForkJoinPool.commonPool().getParallelism());
    }
}
