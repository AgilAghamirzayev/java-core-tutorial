package udemy_multithreading.section_3.task_1;

import java.math.BigInteger;

public class ComplexCalculation {
    public BigInteger calculateResult(BigInteger base1, BigInteger power1,
                                      BigInteger base2, BigInteger power2) throws InterruptedException {
        BigInteger result;
        PowerCalculatingThread calculatingThread1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread calculatingThread2 = new PowerCalculatingThread(base2, power2);

        calculatingThread1.start();
        calculatingThread2.start();
        calculatingThread1.join();
        calculatingThread2.join();

        result = calculatingThread1.getResult().add(calculatingThread2.getResult());

        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            for (BigInteger i = BigInteger.ZERO;
                 i.compareTo(power) != 0;
                 i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }
        }


        public BigInteger getResult() {
            return result;
        }
    }
}