package udemy_multithreading.sec01.two;

public class Main {
    public static void main(String[] args) {
        Thread thread = new NewThread();
        thread.start();
    }

    private static class NewThread extends Thread {
        @Override
        public void run() {
            this.setName("My second Thread");
            System.out.println("Hello from: " + this.getName());
        }
    }
}
