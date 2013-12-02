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

public class Setler {

    /*
    *  Implementations:
    *   - java.util.HashSet
    *   - java.util.LinkedHashSet
    *   - java.util.TreeSet
    *
    *      All: No-DUBLICATE elements
    *      TreeSet : SORTED elements
    *      HashSet : No order guarantied. Faster than TreeSet
    *      LinkedHashSet: UNSORTED but insertion-ordered. Performance Between HashSet and TreeSet
    * */


   public static void main(String[] args) {


      Set hashSet = new HashSet();
      hashSet.add("set3");
      hashSet.add("set4");
      hashSet.add("set1");
      hashSet.add("set2");

      System.out.print("HashSet:");
      displayAll(hashSet);

      //Sorted Set:
      SortedSet treeSet = new TreeSet();
      treeSet.add("1");
      treeSet.add("1");
      treeSet.add("4");
      treeSet.add("2");
      treeSet.add("3");
      System.out.print("TreeSet:");
      displayAll(treeSet);


      LinkedHashSet lnkHashset = new LinkedHashSet();
      lnkHashset.add("four");
      lnkHashset.add("one");
      lnkHashset.add("two");
      lnkHashset.add("three");


      System.out.print("LinkedHashSet:");
      displayAll(lnkHashset);

      //Removing from hashset:
      lnkHashset.remove("one");
      displayAll(lnkHashset);


      // why it throws and error ?
      SortedSet<StringBuffer> s = new TreeSet<StringBuffer>();
      s.add(new StringBuffer("Red"));
      s.add(new StringBuffer("White"));
      s.add(new StringBuffer("Blue"));
      System.out.println(s.first());


   }

   static void displayAll(Collection col) {

      //access via new for-loop
      for (Object object : col) {
         System.out.print(object + " ");
      }
      System.out.println();
   }


}
