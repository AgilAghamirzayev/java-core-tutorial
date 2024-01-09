package org.example.week2;

import java.util.concurrent.RecursiveTask;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Fibonacci extends RecursiveTask<Integer> {
    private final int n;

    @Override
    public Integer compute() {
        if (n <= 1) return n;
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        return f2.compute() + f1.join();
    }
}