package org.udemy.lambda.expession.ch1;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Chlng2 {
    public static void main(String[] args) {

        Function<String, String> result = source -> {
            StringBuilder returnValues = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnValues.append(source.charAt(i));
                }
            }
            return returnValues.toString();
        };


        String res = result.apply("This is the second challenge");
        System.out.println(res);

        System.out.println(everySecondCharacter(source -> IntStream.range(0, source.length())
                        .filter(i -> i % 2 == 1)
                        .mapToObj(i -> String.valueOf(source.charAt(i)))
                        .collect(Collectors.joining()),
                "1234567890"));


        System.out.println(concat(() -> "iLoveJava"));
    }

    public static String concat(Supplier<String> supplier) {
        return supplier.get().replace("i", "I").replace("L", "l");
    }

    public static String everySecondCharacter(Function<String, String> uo, String source) {
        return uo.apply(source);
    }
}
