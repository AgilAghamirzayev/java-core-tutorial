package head_first_java.ryan_monica_third;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

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
    AtomicInteger balance = new AtomicInteger(0);

    public void increment() {
        balance.incrementAndGet();
    }
}