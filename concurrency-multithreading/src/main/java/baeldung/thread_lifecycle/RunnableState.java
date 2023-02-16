package baeldung.thread_lifecycle;

public class RunnableState {
    public static void main(String[] args) {
        DemoRunnableState demoRunnableState = new DemoRunnableState();
        Thread thread = new Thread(demoRunnableState);
        thread.start();
        System.out.println(thread.getState());
    }
}

class DemoRunnableState implements Runnable {

    @Override
    public void run() {

    }
}
