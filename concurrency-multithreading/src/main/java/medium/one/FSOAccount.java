package medium.one;

public class FSOAccount {
    private double balance;

    public FSOAccount(double openingBalance) {
        balance = openingBalance;
    }

    public synchronized boolean withdraw(int amount) {
        if (balance >= amount) {
            balance = balance - amount;
            return true;
        }
        return false;
    }

    public synchronized void deposit(int amount) {
        if (amount < 0) {
            // Throw Exception
            System.out.println("Cannot deposit");
        }
        balance = balance + amount;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized boolean transferTo(FSOAccount other, int amount) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();// Clearing the Interrupt.
        }

        if (withdraw(amount)) {
            other.deposit(amount);
            return true;
        }

        return false;
    }

}