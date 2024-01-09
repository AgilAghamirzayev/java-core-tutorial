package java_specialists.two;


public class BankAccount {
    private Long balance = 0L;

    public void deposit(int amount) {
        synchronized (balance) {
            balance += amount;

        }
    }

    public Long getBalance() {
        return balance;
    }
}
