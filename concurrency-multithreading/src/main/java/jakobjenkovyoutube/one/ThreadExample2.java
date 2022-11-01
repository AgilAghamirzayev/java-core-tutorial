package jakobjenkovyoutube.one;

public class ThreadExample2 {

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread running");
            System.out.println("MyThread finished");
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.run();
    }
}
