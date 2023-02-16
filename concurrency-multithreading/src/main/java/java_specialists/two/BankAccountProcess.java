package java_specialists.two;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BankAccountProcess implements Runnable {

    private final BankAccount bankAccount;

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            bankAccount.deposit(1);
        }
    }
}
