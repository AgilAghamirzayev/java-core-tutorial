package java_specialists.two;

public class StringBufferThreadSafe {

    public static void main(String[] args) throws InterruptedException {
        StringBuffer buffer = new StringBuffer();
        Runnable r1 = append(buffer, "A");
        Runnable r2 = append(buffer, "B");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(buffer);
    }


    private static synchronized Runnable append(StringBuffer buffer, String str) {
        return () -> {
            for (int i = 0; i < 100; i++) {
                buffer.append(str);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
