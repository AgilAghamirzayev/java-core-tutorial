package udemy_multithreading.sec04;

public class Lec01Test4 {
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

        public void increment() {
            System.out.println();
//            System.out.println(Thread.currentThread().getName() + " increment start");
            synchronized (SharedClass.class) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (Exception ignored) {
                }

                this.counter++;
                System.out.println(counter);
            }
//            System.out.println(Thread.currentThread().getName() + " increment end");
        }

        public void decrement() {
            System.out.println();

//            System.out.println(Thread.currentThread().getName() + " decrement start");
            synchronized (SharedClass.class) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (Exception ignored) {
                }

                this.counter--;
                System.out.println(counter);
            }
//            System.out.println(Thread.currentThread().getName() + " decrement start end");
        }
    }
}
