package udemy_multithreading.section_2.one;

import java.util.Comparator;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are now in " + Thread.currentThread().getName());
                System.out.println("Current thread priority is: " + Thread.currentThread().getPriority());
            }
        });

        thread.setName("New Worker thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting the new thread");
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting the new thread");
        System.out.println("tets");
    }
}
