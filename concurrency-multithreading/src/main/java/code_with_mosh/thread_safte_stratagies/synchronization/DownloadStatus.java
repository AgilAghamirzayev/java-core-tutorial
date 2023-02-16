package code_with_mosh.thread_safte_stratagies.synchronization;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private int totalBytes;
    private int totalFiles;

    private Object totalBytesLock = new Object();
    private Object totalFilesLock = new Object();

    public int getTotalBytes() {
        return totalBytes;
    }

    public int getTotalFiles() {
        return totalFiles;
    }

    // Bad practice
    public void incrementTotalByteV1() {
        synchronized (this) {
            totalBytes++;
        }
    }

    // Bad practice
    public synchronized void incrementTotalByteV2() {
        synchronized (this) {
            totalBytes++;
        }
    }

    public void incrementTotalFiles() {
        synchronized (totalFilesLock) {
            totalFiles++;
        }
    }
}
