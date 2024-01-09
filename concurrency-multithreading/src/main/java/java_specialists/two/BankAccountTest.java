package java_specialists.two;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankAccountTest {

    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        BankAccountProcess p1a = new BankAccountProcess(account);
        BankAccountProcess p1b = new BankAccountProcess(account);
        BankAccountProcess p2a = new BankAccountProcess(account);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(p1a);
        executor.execute(p1b);
        executor.execute(p2a);

        executor.shutdown();

        Thread.sleep(3000);
        System.out.println(account.getBalance());
    }

}
