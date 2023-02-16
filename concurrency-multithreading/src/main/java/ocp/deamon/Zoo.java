package ocp.deamon;

public class Zoo {
    public static void pause() {
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread finished!");
    }

    public static void main(String[] args) {
        var job = new Thread(Zoo::pause);
        job.setDaemon(true);
        job.start();
        System.out.println("Main method finished!");
    }
}
