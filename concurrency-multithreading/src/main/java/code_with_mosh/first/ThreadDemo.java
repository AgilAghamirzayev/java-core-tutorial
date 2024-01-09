//package code_with_mosh.first;
//
//import lombok.SneakyThrows;
//
//public class ThreadDemo {
//
//    @SneakyThrows
//    public static void show() {
//        System.out.println("1 --> " + Thread.currentThread().getName());
//        DownloadFileTask downloadFileTask = new DownloadFileTask();
//        Thread thread = new Thread(downloadFileTask);
//        thread.start();
//        System.out.println("2 --> " + Thread.currentThread().getName());
//        downloadFileTask.printThreadName();
//        thread.join();
//        System.out.println("3 --> " + Thread.currentThread().getName());
//        System.out.println("File is ready to be scanned.");
//    }
//}
