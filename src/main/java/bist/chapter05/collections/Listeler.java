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

public class Listeler {


        /*
        *
        * All: Can have DUPLICATE elements
        *
        *
        * list Algorithms
        * sort — sorts a List using a merge sort algorithm, which provides a fast, stable sort.
        *         (A stable sort is one that does not reorder equal elements.)
        * shuffle — randomly permutes the elements in a List.
        * reverse — reverses the order of the elements in a List.
        * rotate — rotates all the elements in a List by a specified distance.
        * swap — swaps the elements at specified positions in a List.
        * replaceAll — replaces all occurrences of one specified value with another.
        * fill — overwrites every element in a List with the specified value.
        * copy — copies the source List into the destination List.
        * binarySearch — searches for an element in an ordered List using the binary search algorithm.
        * indexOfSubList — returns the index of the first sublist of one List that is equal to another.
        * lastIndexOfSubList — returns the index of the last sublist of one List that is equal to another.
        * */

   public static void main(String[] args) {
      List<Integer> myList = new ArrayList<Integer>();
      myList.add(1);
      myList.add(20);
      myList.add(2);
      myList.add(111);
      myList.add(3);

      System.out.println("Min : " + Collections.min(myList));
      System.out.println("Max : " + Collections.max(myList));
      System.out.println("Size: " + myList.size());

      //Sorting
      displayAll(myList);
      Collections.sort(myList);
      System.out.println("Sorted:" + myList);

      //Copying
      List<Integer> myNewList = new ArrayList(myList);
      System.out.println("Copied List:" + myNewList);

      //Disjoint
      System.out.println("Disjoint : " + Collections.disjoint(myList, myNewList));


      //Unmodifieble list
      List<Integer> immutablelist = Collections.unmodifiableList(myNewList);
      //Try to add some value to the list:
      //immutablelist.add(222);
      System.out.println("Immutable List:" + myNewList);


      //Reverse
      Collections.reverse(myList);
      System.out.println("Reverse:" + myList);

      //Frequency
      System.out.println("Frequency:" + Collections.frequency(myList, 111));


      //Remove
      myList.remove(1);
      myList.remove(Integer.valueOf(3));
      System.out.println(myList);

      //Fill
      Collections.fill(myList, 300);
      System.out.println("Filled with :" + myList);

      String[] chars = {"A", "B", "C", "D", "E"};
      List<String> charList = Arrays.asList(chars);

      //Shuffled:
      Collections.shuffle(charList);
      System.out.println("charList : " + charList);


      List lnkLst = new LinkedList();
      lnkLst.add("element1");
      lnkLst.add("element2");
      lnkLst.add("element3");
      lnkLst.add("element4");

      //add an element to a special position:
      lnkLst.add(0, "element0");


      System.out.print("LinkedList:");
      displayAll(lnkLst);

      List aryLst = new ArrayList();
      aryLst.add("x");
      aryLst.add("y");
      aryLst.add("z");
      aryLst.add("w");

      if (aryLst.contains("x")) System.out.println("x mevcut");

      System.out.print("ArrayList:");
      displayAll(aryLst);


   }

   static void displayAll(Collection col) {
      for (Object obj : col) {
         System.out.print(obj + " ");
      }
      System.out.println();
   }


}
