package jenkov.com.fields;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class TestField {
    public static void main(String[] args)
            throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException,
            IllegalAccessException {
        Class<MyObject> myClass = MyObject.class;
        Field[] fields = myClass.getFields();
        Arrays.stream(fields).forEach(field -> System.out.println(field.getName()));

        MyObject myObject = MyObject.class.getConstructor(String.class).newInstance("Test Email");

        Field name = myClass.getField("name");
        Field email = myClass.getField("email");

        Object emailValue = email.get(myObject);

        name.set(myObject, "Test name");
        email.set(myObject, emailValue);

        System.out.println(myObject);

    }
}

class MyObject {
    public String name;
    public String email;

    public MyObject(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return String.format("MyObject [name: %s, email: %s]", name, email);
    }
}
