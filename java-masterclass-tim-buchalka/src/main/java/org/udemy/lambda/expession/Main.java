package org.udemy.lambda.expession;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        int result1 = calculator((a, b) -> a + b, 5, 2);
        int result2 = calculator((a, b) -> a - b, 5, 2);

    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }
}
