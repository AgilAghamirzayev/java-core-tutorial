package hashmap;

import java.util.HashMap;

public class Test {
    public static void test(int a, int b) {
        try {
            int i = a / b;
        } finally {
            System.out.println("test");
        }
    }
    public static void main(String[] args) {

        try {
            test(11,0);
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}
