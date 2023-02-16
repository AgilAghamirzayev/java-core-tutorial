package code_with_mosh.first;

public class Main {
    public static void main(String[] args) {
//        System.out.println(Thread.activeCount());
//        System.out.println(Runtime.getRuntime().availableProcessors());
        ThreadDemo.show();
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
