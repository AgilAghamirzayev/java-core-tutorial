package udemy_multithreading.section_3.joining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(0L, 34357L, 34352L, 2345678323L, 46554L, 13L, 55646L);

        List<FactorialThread> threads = new ArrayList<>();

        for (Long inputNumber : inputNumbers) {
            threads.add(new FactorialThread(inputNumber));
        }

        for (FactorialThread thread : threads) {
            thread.setDaemon(true);
            thread.start();
        }

        for (FactorialThread thread : threads) {
            thread.join(2000);
        }

        for (int i = 0; i < inputNumbers.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
            } else {
                System.out.println("The calculation for " + inputNumbers.get(i) + " is still in progress");
            }
        }
    }
}
