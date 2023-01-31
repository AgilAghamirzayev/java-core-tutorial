package java_specialists.one;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UnsafeSequenceTest {
    public static void main(String[] args) throws InterruptedException {
        final Map<String, String> uniqueNumbers = new ConcurrentHashMap<>();
        final SafeSequence sequence = new SafeSequence();
        Runnable updater = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    int next = sequence.getNext();
                    String result = "value: " + next;
                    uniqueNumbers.put(result, "dummy");
                    System.out.println(result);
                }
            }
        };

        Thread t1 = new Thread(updater, "t1");
        Thread t2 = new Thread(updater, "t2");

        t1.start(); t2.start();
        t1.join(); t2.join();
        System.out.println(uniqueNumbers.size());
    }
}
