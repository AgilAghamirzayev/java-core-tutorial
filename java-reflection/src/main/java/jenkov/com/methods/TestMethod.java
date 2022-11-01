package jenkov.com.methods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestMethod {
    public static void main(String[] args)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method[] methods = MyObject.class.getMethods();
        Arrays.stream(methods).forEach(method -> {
            System.out.println("----------------------" + method.getName() + "-------------------");
            System.out.println(Arrays.toString(method.getParameterTypes()));
            System.out.println(method.getReturnType().getSimpleName());
            System.out.println(Arrays.toString(method.getAnnotations()));
            System.out.println();
        });


        Class<MyObject> myObjectClass = MyObject.class;
        Method setName = myObjectClass.getMethod("setName", String.class);
        setName.invoke(setName, "Aqil");

        System.out.println();

    }
}

class MyObject {
    public String name;
    public String email;

    public MyObject(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("MyObject [name: %s, email: %s]", name, email);
    }
}
