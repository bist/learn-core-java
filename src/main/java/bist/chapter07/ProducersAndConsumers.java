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
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 */
public class ProducersAndConsumers {
   public static void main(String[] args) {
      Wire cable = new Coax();
//      Wire cable = new Fiber();
//      Wire cable = new Infiniband();
//      Wire cable = new TenG();
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

class Infiniband implements Wire {
   private String data;
   private boolean hasValue = false;

   public synchronized String getData() throws Exception {
      while (!hasValue) {
         // there is no value to consume
         wait();
      }

      hasValue = false; // 'coz we are consuming now
      notifyAll();

      return data;
   }

   public synchronized void setData(String data) throws Exception {
      while (hasValue) {
         // we cannot put another value, it's not consumed yet
         wait();
      }

      hasValue = true; // now they can consume
      this.data = data;

      notifyAll();
   }
}

class TenG implements Wire {
   private String data;
   private boolean hasValue = false;

   private final Lock key = new ReentrantLock();
   private final Condition canWrite = key.newCondition();
   private final Condition canRead = key.newCondition();

   @Override
   public String getData() throws Exception {
      String dataRead = null;

      key.lock();
      try {
         while(!hasValue) {
            canRead.await();
         }

         hasValue = false;
         dataRead = this.data;

         canWrite.signal();
      } finally {
         key.unlock();
      }

      return dataRead;
   }

   @Override
   public void setData(String data) throws Exception {
      key.lock();
      try {
         while(hasValue) {
            canWrite.await();
         }

         hasValue = true;
         this.data = data;

         canRead.signal();
      } finally {
         key.unlock();
      }
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
