package jenkov.com.classes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        System.out.println("---------------------> Class Name <---------------------");
        Class<A> aClass = A.class;
        System.out.println(aClass.getName());

        System.out.println("---------------------> Methods <---------------------");
        Method[] methods = A.class.getMethods();
        Arrays.stream(methods).forEach(System.out::println);

        System.out.println("---------------------> Fields <---------------------");
        Field[] fields = aClass.getFields();
        Arrays.stream(fields).forEach(System.out::println);

        System.out.println("---------------------> Class modifiers <---------------------");
        System.out.println(aClass.getModifiers());


    }

}


class A {

    private static final String privateStaticFinalString = "a";
    private final String privateFinalString;
    final String finalString;
    private String privateString;
    String string;
    public String publicString;
    protected String protectedString;

    A(String privateFinalString, String finalString) {
        this.privateFinalString = privateFinalString;
        this.finalString = finalString;
    }


    private static void privateStaticMethod() {}
    private void privateMethod() {}
    public static void  publicStaticMethod() {}
    public void  publicMethod() {}
    protected static void  protectedStaticMethod(){}
    protected void  protectedMethod(){}
    static void defaultStaticMethod() {}
    void defaultMethod() {}

}
