/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version 1.0
 */
public class ExecutorServiceWay {
   public static void main(String[] args) {
      Task t1 = new Task("TASK1");
      Task t2 = new Task("TASK2");
      Task t3 = new Task("TASK3");

      System.out.println("Tasks are going to be added...");

      ExecutorService service = Executors.newCachedThreadPool();

      service.execute(t1);
      service.execute(t2);
      service.execute(t3);

      service.shutdown(); // finish when all the tasks are done!

      System.out.println("All added, and main ends here!");
   }
}

class Task implements Runnable {
   private String name;

   Task(String name) {
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
