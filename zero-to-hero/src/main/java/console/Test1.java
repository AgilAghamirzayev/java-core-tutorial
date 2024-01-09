package console;

import java.io.Console;
import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {

        Console console = System.console();

        if (console == null) {
            System.out.println("No console available");
            return;
        }

        String username = console.readLine("Username: ");
        char[] password = console.readPassword("Password: ");

        System.out.println("Username: " + username);
        System.out.println("Password: " + Arrays.toString(password));
    }
}
