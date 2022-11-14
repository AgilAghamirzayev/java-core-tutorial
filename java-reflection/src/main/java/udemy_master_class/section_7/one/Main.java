package udemy_master_class.section_7.one;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import udemy_master_class.section_7.one.app.annotations.InitializerClass;
import udemy_master_class.section_7.one.app.annotations.InitializerMethod;
import udemy_master_class.section_7.one.app.annotations.RetryOperation;
import udemy_master_class.section_7.one.app.annotations.ScanPackages;

@ScanPackages({"app", "app.databases", "app.http", "app.configs"})
public class Main {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Main.class));

    @SneakyThrows
    public static void main(String[] args) {
        initialize();
    }


    @SneakyThrows
    public static void initialize() {

        ScanPackages scanPackage = Main.class.getAnnotation(ScanPackages.class);

        if (scanPackage == null || scanPackage.value().length == 0) {
            return;
        }

        getAllClasses(scanPackage.value()).stream()
                .filter(clazz -> clazz.isAnnotationPresent(InitializerClass.class))
                .forEach(clazz -> getAllInitializingMethods(clazz).forEach(method -> {
                    try {
                        Object instance = clazz.getDeclaredConstructor().newInstance();
                        callInitializingMethod(instance, method);
                    } catch (IllegalAccessException | InvocationTargetException |
                             NoSuchMethodException | InstantiationException e) {
                        LOGGER.info("Something went wrong.");
                    }
                }));
    }

    @SneakyThrows
    private static void callInitializingMethod(Object instance, Method method) {
        RetryOperation retryOperation = method.getAnnotation(RetryOperation.class);

        int numberOfRetries = retryOperation == null ? 0 : retryOperation.numberOfRetries();

        while (true) {
            try {
                method.invoke(instance);
                break;
            } catch (InvocationTargetException e) {
                Throwable targetException = e.getTargetException();

                if (numberOfRetries > 0 &&
                        Set.of(retryOperation.retryExceptions()).contains(targetException.getClass())) {
                    numberOfRetries--;
                    System.out.println("Retrying ...");
                    Thread.sleep(retryOperation.durationBetweenRetriesMs());
                } else if (retryOperation != null) {
                    throw new Exception(retryOperation.failureMessage(), targetException);
                } else {
                    throw targetException;
                }
            }
        }
    }

    private static List<Method> getAllInitializingMethods(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(InitializerMethod.class))
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public static List<Class<?>> getAllClasses(String[] packageNames) {
        ArrayList<Class<?>> allClasses = new ArrayList<>();

        for (String packageName : packageNames) {
            String packageRelativePath = packageName.replace('.', '/');

            URI packageURI = Main.class.getResource(packageRelativePath).toURI();

            if (packageURI.getScheme().equals("file")) {
                Path packageFullPath = Paths.get(packageURI);
                allClasses.addAll(getAllPackageClasses(packageFullPath, packageName));
            } else if (packageURI.getScheme().equals("jar")) {
                FileSystem fileSystem = FileSystems.newFileSystem(packageURI, Collections.EMPTY_MAP);

                Path packageFullPathInJar = fileSystem.getPath(packageRelativePath);
                allClasses.addAll(getAllPackageClasses(packageFullPathInJar, packageName));
                fileSystem.close();
            }

        }

        return allClasses;
    }

    @SneakyThrows
    private static List<Class<?>> getAllPackageClasses(Path packagePath, String packageName) {
        if (!Files.exists(packagePath)) {
            return Collections.emptyList();
        }

        List<Path> files = Files.list(packagePath)
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());

        ArrayList<Class<?>> classes = new ArrayList<>();

        for (Path filePath : files) {
            String fileName = filePath.getFileName().toString();

            if (fileName.endsWith(".class")) {
                String classFullName = Main.class.getPackageName() + "." + packageName + "."
                        + fileName.replaceFirst("\\.class$", "");
                Class<?> clazz = Class.forName(classFullName);
                classes.add(clazz);
            }

        }

        return classes;
    }

}
