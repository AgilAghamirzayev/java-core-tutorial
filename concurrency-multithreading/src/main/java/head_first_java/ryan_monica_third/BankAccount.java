package head_first_java.ryan_monica_third;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {
    private AtomicInteger balance = new AtomicInteger(100);

    public int getBalance() {
        return balance.get();
    }

    public void spent(String name, int amount) {
        int initialBalance = balance.get();

        if (initialBalance >= amount) {
            boolean success = balance.compareAndSet(initialBalance, initialBalance - amount);
            if (!success) {
                System.out.println("Sorry " + name + ", you haven't spent the money.");
            }
        } else {
            System.err.println("Sorry, not enough for " + name);
        }
    }
}
