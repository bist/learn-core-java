/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter05.generics;

public class GenericMethods {
   // generic method printArray
   public static <E> void printArray(E[] inputArray) {
      // Display array elements
      for (E element : inputArray) {
         System.out.printf("%s ", element);
      }
      System.out.println();
   }

   public static void main(String args[]) {
      // Create arrays of Integer, Double and Character
      Integer[] intArray = {1, 2, 3, 4, 5};
      Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
      Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

      System.out.println("Array integerArray contains:");
      printArray(intArray); // pass an Integer array

      System.out.println("\nArray doubleArray contains:");
      printArray(doubleArray); // pass a Double array

      System.out.println("\nArray characterArray contains:");
      printArray(charArray); // pass a Character array

      Pair<Integer, String> p1 = new Pair<>(1, "apple");
      Pair<Integer, String> p2 = new Pair<>(2, "pear");
      boolean same = Util.<Integer, String>compare(p1, p2);
      System.out.println("Is Same:" + same);

      // type inference:
      // No type definition while calling parameterized method :
      boolean sameAgain = Util.compare(p1, p2);
      System.out.println("Is Same again:" + sameAgain);
   }
}

class Pair<K, V> {

   private K key;
   private V value;

   // Generic constructor
   public Pair(K key, V value) {
      this.key = key;
      this.value = value;
   }

   // Generic methods
   public void setKey(K key) {
      this.key = key;
   }

   public void setValue(V value) {
      this.value = value;
   }

   public K getKey() {
      return key;
   }

   public V getValue() {
      return value;
   }
}

class Util {
   // Generic static method
   public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
      return p1.getKey().equals(p2.getKey()) &&
            p1.getValue().equals(p2.getValue());
   }
}