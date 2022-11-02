package udemy_master_class.section_5.task;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestingFramework {

    public static void main(String[] args) throws Throwable {
        runTestSuite(PaymentServiceTest.class);
    }


    public static void runTestSuite(Class<?> testClass) throws Throwable {
        Method[] methods = testClass.getMethods();

        Method beforeClassMethod = findMethodByName(methods, "beforeClass");
        if (beforeClassMethod != null) {
            beforeClassMethod.invoke(null);
        }

        Method setupTestMethod = findMethodByName(methods, "setupTest");
        if (setupTestMethod == null) {
            return;
        }

        List<Method> methodsWithPrefixTest = findMethodsByPrefix(methods, "test");

        for (Method method : methodsWithPrefixTest) {
            Object testObject = testClass.getDeclaredConstructor().newInstance();
            setupTestMethod.invoke(testObject);
            method.invoke(testObject);
        }

        Method afterClassMethod = findMethodByName(methods, "afterClass");

        if (afterClassMethod != null) {
            afterClassMethod.invoke(null);
        }

    }

    private static Method findMethodByName(Method[] methods, String name) {
        for (Method method : methods) {
            if (method.getName().equals(name) && method.getParameterCount() == 0
                    && method.getReturnType() == void.class) {
                return method;
            }
        }

        return null;
    }

    private static List<Method> findMethodsByPrefix(Method[] methods, String prefix) {
        List<Method> methodsWithSamePrefix = new ArrayList<>();

        for (Method method : methods) {
            if (method.getName().startsWith(prefix) && method.getParameterCount() == 0
                    && method.getReturnType() == void.class) {
                methodsWithSamePrefix.add(method);
            }
        }

        return methodsWithSamePrefix;
    }
}
