package udemy_master_class.section_7.task1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise1 {


    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface OpenResources {

    }

    public Set<Method> getAllAnnotatedMethods(Object input) {
        return Arrays.stream(input.getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(OpenResources.class))
                .collect(Collectors.toSet());
    }
}
