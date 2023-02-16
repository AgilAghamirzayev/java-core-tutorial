package baeldung.thread_lifecycle;

public class NewState {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new DemoNewState();
        Thread thread = new Thread(runnable);

        System.out.println(thread.getState());
    }


}

class DemoNewState implements Runnable {

    @Override
    public void run() {

    }
}