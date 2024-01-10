package udemy_multithreading.section_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import udemy_multithreading.section_3.helper.FactorialThread;

public class Lec02ThreadJoin {
    public static void main(String[] args) {
        List<Long> inputNumbers = Arrays.asList(110000000L, 3233L, 100L, 1000L, 452L, 100000L, 100000L);

        ArrayList<FactorialThread> threads = new ArrayList<>();

        inputNumbers.forEach(number -> threads.add(new FactorialThread(number)));
        threads.forEach(thread -> thread.setDaemon(true));
        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

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
