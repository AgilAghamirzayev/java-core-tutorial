package udemy_master_class.section_3.task2;

import java.lang.reflect.Array;

public class ArrayReader {


    public static void main(String[] args) {
        String[] names = new String[] {"John", "Michael", "Joe", "David"};

        System.out.println(getArrayElement(names, -1));
    }

    public static Object getArrayElement(Object array, int index) {
        return index >= 0 ? Array.get(array, index) : Array.get(array, Array.getLength(array) + index);
    }
}