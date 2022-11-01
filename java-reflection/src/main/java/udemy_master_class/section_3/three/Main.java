package udemy_master_class.section_3.three;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {
        double[][] twoDimensionalArray = {{1,2,3}, {4,5,6}};
        inspectArrayValues(twoDimensionalArray);
    }

    public static void inspectArrayValues(Object arrayObject) {
        int arrayLength = Array.getLength(arrayObject);
        System.out.print("[");

        for (int i = 0; i < arrayLength; i++) {
            Object element = Array.get(arrayObject, i);

            if (element.getClass().isArray()) {
                inspectArrayValues(element);
            } else {
                System.out.print(element);
            }

            if (i != arrayLength - 1) {
                System.out.print(" , ");
            }
        }

        System.out.print("]");
    }
}
