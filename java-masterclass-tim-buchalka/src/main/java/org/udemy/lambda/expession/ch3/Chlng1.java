package org.udemy.lambda.expession.ch3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Chlng1 {

    private static Random random = new Random();

    private record Person(String first) {
        public String last(String s) {
            return first + " " + s.substring(0, s.indexOf(" "));
        }
    }

    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Tom", "VaLi", "AnDreY", "Anna"};
        Person ali = new Person("Ali");

        List<UnaryOperator<String>> operands = new ArrayList<>(Arrays.asList(
                String::toString,
                s -> s + (" " + getRandomChar('D', 'M') + "."),
                s -> s + (" " + reverse(s, 0, s.indexOf(" "))),
                Chlng1::reverse,
                String::new,
                String::valueOf,
                ali::last,
                (new  Person("MUHAMMED"))::last
        ));

        applyChanges(names, operands);
    }

    public static void applyChanges(String[] names, List<UnaryOperator<String>> stringFunctions) {
        List<String> backedByArray = Arrays.asList(names);
        for (UnaryOperator<String> stringFunction : stringFunctions) {
            backedByArray.replaceAll(s -> s.transform(stringFunction));
            System.out.println(Arrays.toString(names));
        }
    }

    public static char getRandomChar(char start, char end) {
        return (char) random.nextInt(start, (int) end + 1);
    }

    private static String reverse(String name) {
        return new StringBuilder(name).reverse().toString();
    }

    private static String reverse(String name, int start, int end) {
        return new StringBuilder(name.substring(start, end)).reverse().toString();
    }
}
