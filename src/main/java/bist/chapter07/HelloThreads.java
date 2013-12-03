package bist.chapter07;

/**
 * @version 1.0
 */
public class HelloThreads {
   public static void main(String[] args) throws Exception {
      // Simple threads with Thread base
      Thread t1 = new AThread("THREAD-1");
      Thread t2 = new AThread("THREAD-2");

      t1.join();
      t2.join();

      System.out.println("Created threads..");
      t1.start();
      t2.start();
      System.out.println("Finished app!");

      // Simple threads with Runnable interface
      Thread t3 = new Thread(new BThread("THREAD-3"));
      Thread t4 = new Thread(new BThread("THREAD-4"));

      t3.join();
      t4.join();

      System.out.println("Created threads..");
      t3.start();
      t4.start();
      System.out.println("Finished app!");
   }
}

class AThread extends Thread {
   private String name;

   AThread(String name) {
      this.name = name;
   }

   @Override
   public void run() {
      for (int i=0; i<5; i++) {
         System.out.println("I'm a thread, and my name is" + this.name);
         try {
            Thread.sleep(2 * 1000);
         } catch (InterruptedException ignored) { }
      }
   }
}

class BThread implements Runnable {
   private String name;

   BThread(String name) {
      this.name = name;
   }

   @Override
   public void run() {
      for (int i=0; i<5; i++) {
         System.out.println("I'm a thread, and my name is" + this.name);
         try {
            Thread.sleep(2 * 1000);
         } catch (InterruptedException ignored) { }
      }
   }
}
