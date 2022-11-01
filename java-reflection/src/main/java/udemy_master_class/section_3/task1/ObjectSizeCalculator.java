package udemy_master_class.section_3.task1;

import java.lang.reflect.Field;
import udemy_master_class.section_3.two.data.Address;
import udemy_master_class.section_3.two.data.Company;

public class ObjectSizeCalculator {
    private static final long HEADER_SIZE = 12;
    private static final long REFERENCE_SIZE = 4;

    public static void main(String[] args) throws IllegalAccessException {
        Company company = new Company("Linkedin", "San Francisco", new Address("Sliconoo", (short) 454));

        long l = sizeOfObject(company);
        System.out.println(l);
    }

    public static long sizeOfObject(Object input) throws IllegalAccessException {

        long sizeOfObject = HEADER_SIZE + REFERENCE_SIZE;

        for (Field field : input.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getType().isPrimitive()) {
                sizeOfObject += sizeOfPrimitiveType(field.getType());
            } else if (field.getType().equals(String.class)) {
                sizeOfObject += sizeOfString(field.get(input).toString());
            } else {
                sizeOfObject += sizeOfObject(field.get(input));
            }
        }

        return sizeOfObject;
    }


    /*************** Helper methods ********************************/
    private static long sizeOfPrimitiveType(Class<?> primitiveType) {
        if (primitiveType.equals(int.class)) {
            return 4;
        } else if (primitiveType.equals(long.class)) {
            return 8;
        } else if (primitiveType.equals(float.class)) {
            return 4;
        } else if (primitiveType.equals(double.class)) {
            return 8;
        } else if (primitiveType.equals(byte.class)) {
            return 1;
        } else if (primitiveType.equals(short.class)) {
            return 2;
        }
        throw new IllegalArgumentException(String.format("Type: %s is not supported", primitiveType));
    }

    private static long sizeOfString(String inputString) {
        int stringBytesSize = inputString.getBytes().length;
        return HEADER_SIZE + REFERENCE_SIZE + stringBytesSize;
    }
}
