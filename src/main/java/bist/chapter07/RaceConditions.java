/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter07;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 */
public class RaceConditions {
   public static void main(String[] args) throws Exception {
      SharedObject so = new SharedObject();

      ExecutorService service = Executors.newCachedThreadPool();
      Writer w1 = new Writer("WRITER1", so);
      Writer w2 = new Writer("WRITER2", so);

      service.execute(w1);
      service.execute(w2);

      service.shutdown();

      if (service.awaitTermination(10, TimeUnit.SECONDS))
         so.printContents();
   }
}

class SharedObject {
   private int index = 0;
   private final Map<String, Integer> data = new HashMap<>();

//   public synchronized void add(int value) {
   public void add(int value) {
      String key = "key" + index;

      try {
         Thread.sleep(1_000);
      } catch (InterruptedException ignored) { }

      index++;
      data.put(key, value);
   }

   public void printContents() {
      System.out.println("----------");
      for (Integer value : data.values()) {
         System.out.print(MessageFormat.format("{0},", value));
      }
      System.out.println("\n----------");
   }
}

class Writer implements Runnable {
   private final String name;
   private final SharedObject shared;

   Writer(String name, SharedObject shared) {
      this.name = name;
      this.shared = shared;
   }

   @Override
   public void run() {
      for (int i=0; i < 3; i++) {
         final Random randomizer = new Random();
         final int value = randomizer.nextInt(100);

         System.out.println(MessageFormat.format("{0} is now writing the value = {1}", name, value));

         this.shared.add(value);
      }
   }

}
