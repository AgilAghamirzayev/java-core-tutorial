package udemy_master_class.section_7.two;

import static udemy_master_class.section_7.two.annotations.Annotations.DependsOn;
import static udemy_master_class.section_7.two.annotations.Annotations.FinalResult;
import static udemy_master_class.section_7.two.annotations.Annotations.Input;
import static udemy_master_class.section_7.two.annotations.Annotations.Operation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        SqlQueryBuilder sqlQueryBuilder = new SqlQueryBuilder(Arrays.asList("1", "2", "3"),
                10,
                "Movies",
                Arrays.asList("Id", "Name"));

        String execute = execute(sqlQueryBuilder);
        System.out.println(execute);

    }

    public static <T> T execute(Object instance) {
        Class<?> clazz = instance.getClass();
        Method finalResultMethod = findFinalResultMethod(clazz);

        Map<String, Method> operationToMethod = getOperationToMethod(clazz);
        Map<String, Field> inputToField = getInputToField(clazz);

        return (T) executeWithDependencies(instance, finalResultMethod, operationToMethod, inputToField);
    }

    @SneakyThrows
    private static Object executeWithDependencies(Object instance, Method currentMethod,
                                                  Map<String, Method> operationToMethod,
                                                  Map<String, Field> inputToField) {

        ArrayList<Object> parameterValues = new ArrayList<>(currentMethod.getParameterCount());

        Arrays.stream(currentMethod.getParameters())
                .forEach(parameter -> {
                    Object value = null;
                    if (parameter.isAnnotationPresent(DependsOn.class)) {
                        String dependencyOperationName = parameter.getAnnotation(DependsOn.class).value();
                        Method dependencyMethod = operationToMethod.get(dependencyOperationName);
                        value = executeWithDependencies(instance, dependencyMethod, operationToMethod, inputToField);
                    } else if (parameter.isAnnotationPresent(Input.class)) {
                        String inputName = parameter.getAnnotation(Input.class).value();
                        Field inputField = inputToField.get(inputName);
                        inputField.setAccessible(true);
                        try {
                            value = inputField.get(instance);
                        } catch (IllegalAccessException e) {
                            System.out.println("Something went wrong: " + e.getMessage());
                        }
                    }
                    parameterValues.add(value);
                });

        return currentMethod.invoke(instance, parameterValues.toArray());
    }

    private static Map<String, Method> getOperationToMethod(Class<?> clazz) {
        Map<String, Method> operationNameToMethod = new HashMap<>();

        Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Operation.class))
                .forEach(method -> operationNameToMethod.put(method.getAnnotation(Operation.class).value(), method));

        return operationNameToMethod;
    }

    private static Map<String, Field> getInputToField(Class<?> clazz) {
        Map<String, Field> inputToField = new HashMap<>();

        Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Input.class))
                .forEach(field -> inputToField.put(field.getAnnotation(Input.class).value(), field));

        return inputToField;
    }

    private static Method findFinalResultMethod(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(FinalResult.class))
                .findAny()
                .orElseThrow(() -> new RuntimeException("No method found with FinalResult annotation"));
    }

}
