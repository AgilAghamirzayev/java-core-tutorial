package code_with_mosh.thread_safte_stratagies.confinement;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTask> tasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            DownloadFileTask task = new DownloadFileTask();
            tasks.add(task);
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        Optional<Integer> totalBytes = tasks.stream()
                .map(t -> t.getStatus().getTotalBytes())
                .reduce(Integer::sum);

        System.out.println(totalBytes);
    }
}
