package udemy_master_class.section_3.two.data;

import java.util.List;

public class Person {
    private final String name;
    private final boolean employed;
    private final int age;
    private final float salary;

    private final String[] hobbies;

    private final List<Integer> lovelyNumbers;
    private final Address address;
    private final Company company;

    public Person(String name, boolean employed, int age, float salary, String[] hobbies, List<Integer> lovelyNumbers,
                  Address address, Company company) {
        this.name = name;
        this.employed = employed;
        this.age = age;
        this.salary = salary;
        this.hobbies = hobbies;
        this.lovelyNumbers = lovelyNumbers;
        this.address = address;
        this.company = company;
    }
}
