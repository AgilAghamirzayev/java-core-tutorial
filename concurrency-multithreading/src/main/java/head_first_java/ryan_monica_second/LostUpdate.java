package head_first_java.ryan_monica_second;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LostUpdate {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        Balance balance = new Balance();

        for (int i = 0; i < 1_000_000; i++) {
            pool.execute(balance::increment);
        }

        pool.shutdown();

        if (pool.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("balance: " + balance.balance);
        }
    }
}


class Balance {
    int balance = 0;

    public synchronized void increment() {
        balance++;
    }
}