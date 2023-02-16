package code_with_mosh.second;

import lombok.SneakyThrows;

public class DownloadFileTask2 implements Runnable {

    private DownloadStatus status;

    public DownloadFileTask2(DownloadStatus status) {
        this.status = status;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());

        for (int i = 0; i < 10_000; i++) {
            if (Thread.currentThread().isInterrupted()) return;
            status.incrementTotalByte();
        }

        System.out.println("Download completed: " + Thread.currentThread().getName());
    }

}
