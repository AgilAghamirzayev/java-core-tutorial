package code_with_mosh.second;

import code_with_mosh.first.DownloadFileTask;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo {

    @SneakyThrows
    public static void main(String[] args) {
        var status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTask2(status));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(status.getTotalBytes());
    }
}
