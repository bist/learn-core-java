/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter05.collections;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CollectionsBasics {

       /*
        Java arrays have limitations:
        - They cannot dynamically shrink and grow.
        - They have limited type safety.
        - Implementing efficient, complex data structures from scratch would be difficult.

        The Java Collections Framework provides many benefits:
        - Reduces programming effort (already there)
        - Increases performance (tested and optimized)
        - Part of the core API (available, easy to learn)
        - Promotes software reuse (standard interface)
        - Easy to design APIs based on generic collections

        Interfaces:
            Collection  -> Set  -> SortedSet    : A collection that cannot contain duplicate elements
                        -> Listeler             : An ordered collection. Lists can contain duplicate elements
                        -> Queue                : A collection used to hold multiple elements prior to processing.
                                                  Queue provides additional insertion, extraction, and inspection operations.
                        -> Deque                : Deques can be used both as FIFO (first-in, first-out) and LIFO (last-in, first-out)
            Map         -> SortedMap            : Maps keys to values. Cannot contain duplicate keys; each key can map to at most one value.

       Implementations:
            Set         : HashSet, TreeSet, EnumSet, LinkedHashSet
            List        : ArrayList, LinkedList, Vector, Stack
            Map         : HashMap, TreeMap, LinkedHashMap
            Queue-Deque : LinkedList, PriorityQueue, ArrayDeque

       *
       *
       * */

   public static void main(String[] args) {
      String[] myArray = {"a", "b", "c", "d", "e"};
      Collection<String> myList = new ArrayList<String>();

      //addAll : Arrays import to Collections:
      myList.addAll(Arrays.asList(myArray));
      System.out.println(myList);
      //removeAll,

      myList.add("1");
      myList.add("2");

      //Iterators, hasNext,next
      Iterator iterator = myList.iterator();
      while (iterator.hasNext()) {
         Object object = iterator.next();
         System.out.print(object);
      }

      System.out.println("\nsize: " + myList.size());
      //Iterating with for each (
      for (Object object : myList) {
         System.out.print(object);
      }
      System.out.println();

   }


}

