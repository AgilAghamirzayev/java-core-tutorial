package udemy_master_class.section_2.task1;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CreateInterfaceImplementation {
    public static void main(String[] args) {
        implementedInterface(A.class);
        implementedInterface(B.class);
    }

    public static <T> void implementedInterface(Class<T> clazz) {
        T instance = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[] {clazz},
                (proxy, method, args) -> proxy);

        Method[] declaredMethods = instance.getClass().getDeclaredMethods();

        Arrays.stream(declaredMethods).forEach(method -> System.out.println(method.getName()));
    }

    public interface B {
        void a();

        void b();
        void e();
        void f();

        void c();

    }

    public interface A {
        void a();

        void b();

        void c();

    }
}
