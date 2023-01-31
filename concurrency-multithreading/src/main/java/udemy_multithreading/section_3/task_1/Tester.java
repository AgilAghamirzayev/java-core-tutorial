package udemy_multithreading.section_3.task_1;

import java.math.BigInteger;

public class Tester {
    public static void main(String[] args) throws InterruptedException {
        ComplexCalculation complexCalculation = new ComplexCalculation();
        BigInteger bigInteger = complexCalculation.calculateResult(BigInteger.TEN,
                BigInteger.TEN,
                BigInteger.TEN,
                BigInteger.TEN);

        System.out.println(bigInteger);
    }
}
