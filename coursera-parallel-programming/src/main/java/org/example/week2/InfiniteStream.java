package org.example.week2;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

public class InfiniteStream {
    public static void main(String[] args) {
//        Stream<Integer> numbers = Stream.iterate(0, n -> n + 1);
//        numbers.forEach(System.out::println);

        Stream<String> words = Stream.of("Java", "Magazine", "is", "the", "best");
        Map<String, Long> letterToCount = words.map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .collect(groupingBy(identity(), counting()));

        System.out.println(letterToCount);
    }
}
