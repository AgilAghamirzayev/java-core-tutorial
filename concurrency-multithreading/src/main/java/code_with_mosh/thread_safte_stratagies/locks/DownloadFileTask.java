package code_with_mosh.thread_safte_stratagies.locks;

public class DownloadFileTask implements Runnable {

    private DownloadStatus status;

    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());

        for (int i = 0; i < 10_000; i++) {
            if (Thread.currentThread().isInterrupted()) return;
            status.incrementTotalByte();
        }

        System.out.println("Download completed: " + Thread.currentThread().getName());
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
