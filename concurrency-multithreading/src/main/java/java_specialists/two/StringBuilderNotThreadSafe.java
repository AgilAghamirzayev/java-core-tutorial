package java_specialists.two;

public class StringBuilderNotThreadSafe {
   public static void main(String[] args) throws InterruptedException {
      StringBuilder builder = new StringBuilder();

      Runnable task1 = () -> {
         for (int i = 0; i < 100; i++) {
            builder.append("A");
            try {
               Thread.sleep(1);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      };

      Runnable task2 = () -> {
         for (int i = 0; i < 100; i++) {
            builder.append("B");
            try {
               Thread.sleep(1);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      };

      Thread t1 = new Thread(task1);
      Thread t2 = new Thread(task2);
      t1.start();
      t2.start();

      t1.join();
      t2.join();

      System.out.println(builder);
   }
}
