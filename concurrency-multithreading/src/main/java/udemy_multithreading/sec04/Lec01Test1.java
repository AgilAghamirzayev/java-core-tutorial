package udemy_multithreading.sec04;

public class Lec01Test1 {
    public static void main(String [] args) {
        SharedClass sharedObject = new SharedClass();

        Thread thread1 = new Thread(() -> {
            while (true) {
                sharedObject.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                sharedObject.increment();
            }
        });

        thread1.setName("thread-1");
        thread2.setName("thread-2");

        thread1.start();
        thread2.start();
    }

    static class SharedClass {
        private int counter = 0;

        public synchronized void increment()  {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            }catch (Exception ignored) {
            }

            this.counter++;
            System.out.println(counter);
        }
    }
}
