package head_first_java.ryan_monica_first;

public class BankAccount {
    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public synchronized void spent(String name, int amount) {
        if (balance >= amount) {
            balance = balance - amount;

            System.out.println(name + " spent " + amount);

            if (balance < 0) {
                System.out.println("Overdrawn!");
            }
        } else {
            System.err.println("Sorry, not enough for " + name);
        }
    }
}
