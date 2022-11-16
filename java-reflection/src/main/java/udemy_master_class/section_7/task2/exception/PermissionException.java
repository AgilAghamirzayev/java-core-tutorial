package udemy_master_class.section_7.task2.exception;

public class PermissionException extends RuntimeException {
    public PermissionException() {
        super("User does not have the right permissions for the operation");
    }
}