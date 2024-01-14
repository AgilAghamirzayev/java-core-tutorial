package udemy_multithreading.sec04;

import udemy_multithreading.utils.Utils;

import java.util.Random;

public class Lec02Atomic2 {

    public static void main(String[] args) {
        Metrics metrics = new Metrics();
        BusinessLogic businessLogic1 = new BusinessLogic(metrics);
        BusinessLogic businessLogic2 = new BusinessLogic(metrics);
        BusinessLogic businessLogic3 = new BusinessLogic(metrics);
        BusinessLogic businessLogic4 = new BusinessLogic(metrics);
        MetricsPrinter metricsPrinter = new MetricsPrinter(metrics);

        businessLogic1.start();
        businessLogic2.start();
        businessLogic3.start();
        businessLogic4.start();
        metricsPrinter.start();
    }

    public static class MetricsPrinter extends Thread {
        private final Metrics metrics;

        public MetricsPrinter(Metrics metrics) {
            this.metrics = metrics;
        }

        @Override
        public void run() {
            while (true) {
                Utils.sleep(100);
                float average = metrics.getAverage();
                System.out.println("Current average is: " + average);
            }
        }
    }

    public static class BusinessLogic extends Thread {
        private final Metrics metrics;
        private final Random random = new Random();

        public BusinessLogic(Metrics metrics) {
            this.metrics = metrics;
        }

        @Override
        public void run() {
            while (true) {
                long start = System.currentTimeMillis();
                Utils.sleep(random.nextInt(10));
                long end = System.currentTimeMillis();
                metrics.addSample(end - start);
            }
        }
    }

    public static class Metrics {
        private int count = 0;
        private float average = 0.0F;

        public void addSample(long sample) {
            float currentSum = average * count;
            count++;
            average = (currentSum + sample) / count;
        }

        public float getAverage() {
            return average;
        }
    }
}
