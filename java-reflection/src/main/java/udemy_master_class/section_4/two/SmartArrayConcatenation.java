package udemy_master_class.section_4.two;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmartArrayConcatenation {
    public static void main(String[] args) {
        Integer [] result1 = concat(Integer.class, 1,2,3,4,5);
        int [] result2 = concat(int.class, 1, 2, 3, new int[] {4, 5, 6}, 7);
        String [] result3 = concat(String.class, new String[]{"a", "b"}, "c", new String[] {"d", "e"});

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));


    }

    public static <T> T concat(Class<?> type, Object... arguments) {

        if (arguments.length == 0) {
            return null;
        }

        List<Object> elements = new ArrayList<>();

        for (Object arg : arguments) {
            if (arg.getClass().isArray()) {
                int length = Array.getLength(arg);
                for (int i = 0; i < length; i++) {
                    elements.add(Array.get(arg, i));
                }
            } else {
                elements.add(arg);
            }
        }

        Object flattenedArray = Array.newInstance(type, elements.size());

        for (int i = 0; i < elements.size(); i++) {
            Array.set(flattenedArray,i,elements.get(i));
        }

        return (T) flattenedArray;
    }

}
