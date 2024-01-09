package java_specialists.two;


public class BankAccountProcess implements Runnable {

    private final BankAccount bankAccount;

    public BankAccountProcess(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            bankAccount.deposit(1);
        }
    }
}
