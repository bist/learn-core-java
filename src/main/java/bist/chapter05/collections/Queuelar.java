/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter05.collections;

import java.util.*;

public class Queuelar {


    /*
    * Implementations:
    * - java.util.LinkedList
    * - java.util.PriorityQueue
    *
    *   Queue : FIFO
    *   Dequeue : both FIFO, LIFO
    *       Double-Ended queue.
    *
    *   PriorityQueue : class is a priority queue based on the heap data structure.
    *                   This queue orders elements according to the order specified at
    *                   construction time, which can be the elements' natural ordering or
    *                   the ordering imposed by an explicit Comparator
    *
    *   Concurrent Queue Implementations:
    *       in the java.util.concurrent package
    *
    *           - LinkedBlockingQueue — an optionally bounded FIFO blocking queue backed by linked nodes
    *           - ArrayBlockingQueue — a bounded FIFO blocking queue backed by an array
    *           - PriorityBlockingQueue — an unbounded blocking priority queue backed by a heap
    *           - DelayQueue — a time-based scheduling queue backed by a heap
    *           - SynchronousQueue — a simple rendezvous mechanism that uses the BlockingQueue interface
    *           - LinkedBlockingDeque --- is the concurrent implementation of the Deque interface.
    *
    *           - LinkedTransferQueue — an unbounded TransferQueue based on linked nodes
    */

   public static void main(String[] args) {

      Queue queueA = new LinkedList();
      Queue queueB = new PriorityQueue();
      Deque dequeC = new ArrayDeque();

      queueA.add("element 12");
      queueA.add("element 2");
      queueA.add("element 3");


      Object firstElement = queueA.element();
      System.out.println("firstElement : " + firstElement);

      //Removing from queue
      queueA.remove(firstElement);

      //access via new for-loop
      for (Object object : queueA) {
         String element = (String) object;
         System.out.println(element);
      }


      System.out.println("Deque:");
      Deque dequeA = new LinkedList();

      dequeA.add("element 1"); //add element
      dequeA.add("element 2"); //add element
      dequeA.addLast("element 3"); //add element at tail
      dequeA.addFirst("element 0"); //add element at head


      Object siradaki = dequeA.element();
      System.out.println("ilk : " + siradaki);
      Object ilk = dequeA.getFirst();
      System.out.println("ilk : " + ilk);
      Object son = dequeA.getLast();
      System.out.println("son : " + son);

      //Remove
      dequeA.remove(ilk);


      for (Object object : dequeA) {
         String element = (String) object;
         System.out.println(element);
      }


   }


}
