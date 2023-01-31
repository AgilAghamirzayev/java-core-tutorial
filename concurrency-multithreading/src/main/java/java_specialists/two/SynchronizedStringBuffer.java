package java_specialists.two;

public class SynchronizedStringBuffer {
   private static StringBuffer buffer = new StringBuffer();

   public static void main(String[] args) throws InterruptedException {
      Runnable task1 = () -> {
         synchronized (buffer) {
            for (int i = 0; i < 100; i++) {
               buffer.append("A");
               try {
                  Thread.sleep(1);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            }
         }
      };

      Runnable task2 = () -> {
         synchronized (buffer) {
            for (int i = 0; i < 100; i++) {
               buffer.append("B");
               try {
                  Thread.sleep(1);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            }
         }
      };

      Thread t1 = new Thread(task1);
      Thread t2 = new Thread(task2);
      t1.start();
      t2.start();

      t1.join();
      t2.join();

      System.out.println(buffer.toString());
   }
}
