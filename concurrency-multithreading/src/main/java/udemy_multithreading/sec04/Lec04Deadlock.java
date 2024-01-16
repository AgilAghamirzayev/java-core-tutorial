package udemy_multithreading.sec04;

import udemy_multithreading.utils.Utils;

import java.util.Random;

public class Lec04Deadlock {

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        Thread thread1 = new Thread(new TrainA(intersection));
        Thread thread2 = new Thread(new TrainB(intersection));

        thread1.start();
        thread2.start();
    }


    public static class TrainA implements Runnable {
        private Intersection intersection;
        private Random random = new Random();

        public TrainA(Intersection intersection) {
            this.intersection = intersection;
        }

        @Override
        public void run() {
            while (true) {
                int sleepingTime = random.nextInt(5);
                Utils.sleep(sleepingTime);
                intersection.takeRoadA();
            }
        }
    }

    public static class TrainB implements Runnable {
        private Intersection intersection;
        private Random random = new Random();

        public TrainB(Intersection intersection) {
            this.intersection = intersection;
        }

        @Override
        public void run() {
            while (true) {
                int sleepingTime = random.nextInt(5);
                Utils.sleep(sleepingTime);
                intersection.takeRoadB();
            }
        }
    }


    public static class Intersection {
        private Object roadA = new Object();
        private Object roadB = new Object();

        public void takeRoadA() {
            synchronized (roadA) {
                System.out.println("Road A is locked by thread: " + Thread.currentThread().getName());
                synchronized (roadB) {
                    System.out.println("Train is passing through road A");
                    Utils.sleep(1);
                }
            }
        }

        public void takeRoadB() {
            synchronized (roadA) {
                System.out.println("Road B is locked by thread: " + Thread.currentThread().getName());
                synchronized (roadB) {
                    System.out.println("Train is passing through road B");
                    Utils.sleep(1);
                }
            }
        }

    }
}
