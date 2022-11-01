package jakobjenkovyoutube.one;

public class ThreadExample5 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Runnable running");
            System.out.println("Runnable finished");
        };

        Thread thread = new Thread(runnable);
        thread.start(); 
    }
}
