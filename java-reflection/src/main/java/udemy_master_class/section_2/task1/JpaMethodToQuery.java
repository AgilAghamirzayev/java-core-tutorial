package udemy_master_class.section_2.task1;

import java.lang.reflect.Proxy;

public class JpaMethodToQuery {

    public static void main(String[] args) {
        interfaceMethodImpl();
    }

    static void interfaceMethodImpl() {
        TestInterface instance = (TestInterface) Proxy.newProxyInstance(TestInterface.class.getClassLoader(),
                new Class<?>[]{TestInterface.class}, (proxy, method, args) -> {
                    String regex = "get(([0-9]*)(minus|plus)([0-9]*))";
                    String arg1 = method.getName().replaceAll(regex, "$2");
                    String operator = method.getName().replaceAll(regex, "$3");
                    String arg3 = method.getName().replaceAll(regex, "$4");

                    switch (operator) {
                        case "plus":
                            return Integer.parseInt(arg1) + Integer.parseInt(arg3);
                        case "minus":
                            return Integer.parseInt(arg1) - Integer.parseInt(arg3);
                        default:
                            return null;
                    }
                });


        System.out.println(instance.get5plus6());
        System.out.println(instance.get8minus3());
    }

    interface TestInterface {
        int get5plus6();
        int get8minus3();
    }

}
