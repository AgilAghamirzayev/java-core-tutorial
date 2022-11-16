package udemy_master_class.section_7.task2.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import udemy_master_class.section_7.task2.enums.OperationType;
import udemy_master_class.section_7.task2.enums.Role;

public class Annotations {

    @Target(ElementType.TYPE)
    @Repeatable(PermissionsContainer.class)
    public @interface Permissions {
        Role role();
        OperationType[] allowed();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface PermissionsContainer {
        Permissions [] value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface MethodOperations {
        OperationType[] value();
    }

}
