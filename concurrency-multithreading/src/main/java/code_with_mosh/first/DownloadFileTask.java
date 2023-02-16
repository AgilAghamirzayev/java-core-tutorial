package code_with_mosh.first;

import lombok.SneakyThrows;

public class DownloadFileTask implements Runnable{

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("Download completed: " + Thread.currentThread().getName());
        printThreadName();
    }

    public void printThreadName() {
        System.out.println("4 --> " + Thread.currentThread().getName());
    }

}
