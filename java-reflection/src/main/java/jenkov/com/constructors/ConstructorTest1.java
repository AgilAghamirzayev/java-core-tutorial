package jenkov.com.constructors;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ConstructorTest1 {
    public static void main(String[] args)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<MyObject> constructor = MyObject.class.getConstructor(String.class);
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Arrays.stream(parameterTypes).forEach(aClass -> System.out.println(aClass.getSimpleName()));

        MyObject myObject = constructor.newInstance("const-args-1");
        System.out.println(myObject);
    }
}
