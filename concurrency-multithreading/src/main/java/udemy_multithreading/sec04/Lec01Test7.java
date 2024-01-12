package udemy_multithreading.sec04;

public class Lec01Test7 {
    public static void main(String[] args) throws InterruptedException {
        SharedClass sharedObject = new SharedClass();

        Thread thread1 = new Thread(() -> {
            while (true) {
                sharedObject.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                sharedObject.decrement();
            }
        });
        thread1.setName("thread-1");
        thread2.setName("thread-2");
        thread1.start();
        thread2.start();

        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
    }

    static class SharedClass {
        private int counter = 0;
        private Object lock1 = new Object();
        private Object lock2 = new Object();
        public void increment() {
//            System.out.println(Thread.currentThread().getName() + " increment start");
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (Exception ignored) {
                }

                this.counter++;
                System.out.println(counter);
            }
//            System.out.println(Thread.currentThread().getName() + " increment end");
        }

        public void decrement() {
//            System.out.println(Thread.currentThread().getName() + " decrement start");
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (Exception ignored) {
                }

                this.counter--;
                System.out.println(counter);
            }
//            System.out.println(Thread.currentThread().getName() + " decrement start end");
        }
    }
}
