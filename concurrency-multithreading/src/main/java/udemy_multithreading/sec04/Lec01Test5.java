package udemy_multithreading.sec04;

public class Lec01Test5 {
    public static void main(String [] args) {
        SharedClass sharedObject1 = new SharedClass();
        SharedClass sharedObject2 = new SharedClass();

        Thread thread1 = new Thread(() -> {
            int a = 10;
            while (a > 0) {
                sharedObject1.increment();
                a--;
            }
        });

        Thread thread2 = new Thread(() -> {
            int a = 10;
            while (a > 0) {
                sharedObject2.increment();
                a--;
            }
        });

        thread1.setName("thread-1");
        thread2.setName("thread-2");

        thread1.start();
        thread2.start();

        System.out.println(sharedObject1.counter);
        System.out.println(sharedObject2.counter);
    }

    static class SharedClass {
        private int counter = 0;

        public void increment()  {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                }catch (Exception ignored) {
                }

                this.counter++;
                System.out.println(counter);
            }
        }
    }
}
