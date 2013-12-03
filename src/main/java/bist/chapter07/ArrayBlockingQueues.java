/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter07;

import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version 1.0
 */
public class ArrayBlockingQueues {
   public static void main(String[] args) {
      Wire cable = new Coax();
//      Fiber cable = new Fiber();
      Caller caller = new Caller("CALLER", cable);
      Callee callee = new Callee("CALLEE", cable);

      ExecutorService service = Executors.newCachedThreadPool();
      service.execute(caller);
      service.execute(callee);
      service.shutdown();
   }
}

interface Wire {
   String getData() throws Exception;
   void setData(String data) throws Exception;
}

class Coax implements Wire {
   private String data;

   public String getData() throws Exception {
      return data;
   }

   public void setData(String data) throws Exception {
      this.data = data;
   }
}

class Fiber implements Wire {
   private ArrayBlockingQueue<String> data = new ArrayBlockingQueue<>(1);

   public String getData() throws Exception {
      return data.take();
   }

   public void setData(String data) throws Exception {
      this.data.put(data);
   }
}

class Caller implements Runnable {
   private final String name;
   private final Wire cable;

   Caller(String name, Wire cable) {
      this.name = name;
      this.cable = cable;
   }

   @Override
   public void run() {
      final Random randomizer = new Random();

      String text = "Not so sure if my threads are rocking in a super duper way!";
      System.out.println(text);

      StringTokenizer tokenizer = new StringTokenizer(text, " ");
      while (tokenizer.hasMoreTokens()) {
         try {
            cable.setData(tokenizer.nextToken());

            Thread.sleep(randomizer.nextInt(500));
         } catch (Exception ignored) { }
      }
   }
}

class Callee implements Runnable {
   private final String name;
   private final Wire cable;

   Callee(String name, Wire cable) {
      this.name = name;
      this.cable = cable;
   }

   @Override
   public void run() {
      final Random randomizer = new Random();

      for (int i=0; i < 13; i++) {
         try {
            System.out.print(cable.getData() + " ");

            Thread.sleep(randomizer.nextInt(500));
         } catch (Exception ignored) { }
      }
   }
}
