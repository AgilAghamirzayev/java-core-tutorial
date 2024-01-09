package org.udemy.lambda.expession.ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Chlng1 {

    private static Random random = new Random();

    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Tom", "VaLi", "AnDreY", "Anna"};

        Arrays.setAll(names, i -> names[i].toUpperCase());

        System.out.println("-> Transform to uppercase");
        System.out.println(Arrays.toString(names));

        List<String> backedByArray = Arrays.asList(names);
        backedByArray.replaceAll(s -> s + " " + getRandomChar('A', 'D') + ".");
        System.out.println("--> Add random middle initial");
        System.out.println(backedByArray);

        backedByArray.replaceAll(s -> s + " " + getReversedName(s.split(" ")[0]));
        System.out.println("--> Add reversed name as last name");
        System.out.println(backedByArray);

        List<String> newList = new ArrayList<>(List.of(names));
        newList.removeIf(s -> s.substring(0, s.indexOf(" ")).equals(
                s.substring(s.lastIndexOf(" ") + 1)
        ));

        System.out.println(newList);

        System.out.println(Arrays.toString(names));

        Function<Integer, Integer> o = t -> t * 2;
        Integer apply = o.apply(1);
        System.out.println(apply);
    }


    public static char getRandomChar(char start, char end) {
        return (char) random.nextInt((int) start, (int) end + 1);
    }

    private static String getReversedName(String name) {
        return new StringBuilder(name).reverse().toString();
    }
}
