package integer_cache;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;

public class Test {

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void createIntegerMore127() {
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            Integer a = 1111;
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void createIntegerLess127() {
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            Integer a = 100;
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void createIntMore1() {
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            int a = 2;
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void createIntMore2() {
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            int a = 2;
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void createIntMore3() {
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            int a = 1111;
        }
    }
}
