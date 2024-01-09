package org.udemy.lambda.expession.ch1;

import java.util.Arrays;
import java.util.function.Consumer;

public class Chlng1 {
    public static void main(String[] args) {

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                String[] parts = s.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        Consumer<String> consumerLambda = sentence -> {
            Arrays.stream(sentence.split(" "))
                    .forEach(System.out::println);
        };

        consumer.accept("This is a string");
        System.out.println();
        consumerLambda.accept("This is a string");

    }
}
