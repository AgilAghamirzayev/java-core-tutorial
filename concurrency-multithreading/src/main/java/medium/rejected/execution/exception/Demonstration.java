package medium.rejected.execution.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class Demonstration {
    public static void main(String args[]) {
        int i = 0;

        try (ExecutorService executorService = Executors.newFixedThreadPool(10)) {
            for (; i < 1_000; i++) {
                executorService.execute(Demonstration::sleep);
            }
            System.out.println("Submitted all tasks");
        } catch (RejectedExecutionException ree) {
            System.out.println("Task " + i + " was rejected");
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            System.out.println("Task executed by thread " + Thread.currentThread().getName() + " has been interrupted");
        }
    }
}