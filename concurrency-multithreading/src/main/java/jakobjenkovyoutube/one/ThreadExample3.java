package jakobjenkovyoutube.one;

public class ThreadExample3 {

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("MyThread running");
            System.out.println("MyThread finished");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.run();
    }
}
