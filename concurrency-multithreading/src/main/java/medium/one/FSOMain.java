package medium.one;

public class FSOMain {
    public static final int MAX_TRANSFER = 1000;

    public static void main(String[] arr) throws InterruptedException {
        FSOAccount fsoAccountA = new FSOAccount(10_000);
        FSOAccount fsoAccountB = new FSOAccount(10_000);

        Thread tA = new Thread(() -> {
            for (int i = 0; i < MAX_TRANSFER; i = i + 1) {
                boolean ok = fsoAccountA.transferTo(fsoAccountB, 1);
                if (!ok) {
                    System.out.println("Thread A Failed at " + i);
                }
            }
        });

        Thread tB = new Thread(() -> {
            for (int i = 0; i < MAX_TRANSFER; i = i + 1) {
                boolean ok = fsoAccountB.transferTo(fsoAccountA, 1);
                if (!ok) {
                    System.out.println("Thread B Failed at " + i);
                }
            }
        });


        tA.start();
        tB.start();
        tA.join();
        tB.join();

        System.out.println(fsoAccountA.getBalance());
        System.out.println(fsoAccountB.getBalance());
    }
}