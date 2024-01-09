package org.example.week2;

public class Main {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(42);
        Integer compute = fibonacci.compute();
        System.out.println(compute);
    }
}
