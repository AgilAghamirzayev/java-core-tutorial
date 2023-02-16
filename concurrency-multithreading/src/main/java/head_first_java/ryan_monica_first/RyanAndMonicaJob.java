package head_first_java.ryan_monica_first;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RyanAndMonicaJob implements Runnable {


    private final String name;
    private final BankAccount account;
    private final int amountToSpend;

    @Override
    public void run() {
        goShopping(amountToSpend);
    }

    private void goShopping(int amount) {
        System.out.println(name + " is about to spend");
        account.spent(name, amount);
    }
}
