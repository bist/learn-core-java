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

public class Mapler {

    /*
    * Implementations:
    *  - java.util.HashMap          :Does not guarantee any order of the elements stored internally in the map
    *  - java.util.Hashtable
    *  - java.util.EnumMap
    *  - java.util.IdentityHashMap
    *  - java.util.LinkedHashMap
    *  - java.util.Properties
    *  - java.util.TreeMap          :Order is in which keys or values are iterated
    *  - java.util.WeakHashMap
    *
    * */


   public static void main(String[] args) {

      Map mapA = new HashMap();
      Map mapB = new TreeMap();


      mapA.put("key1", "element 1");
      mapA.put("key2", "element 2");
      mapA.put("key3", "element 3");

      String element1 = (String) mapA.get("key1");
      System.out.println("element1 : " + element1);

      // key iterator
      Iterator keyIterator = mapA.keySet().iterator();

      // value iterator
      Iterator valueIterator = mapA.values().iterator();

      // Iterationg with keys:
      while (keyIterator.hasNext()) {
         Object key = keyIterator.next();
         Object value = mapA.get(key);
         System.out.println(key + "-" + value);
      }

      //access via new for-loop
      for (Object key : mapA.keySet()) {
         Object value = mapA.get(key);
         System.out.println(key + "--" + value);
      }

      // Iterationg with values:
      while (valueIterator.hasNext()) {
         System.out.println(valueIterator.next());
      }

      //Treemap definition with Generics:
      SortedMap<String, String> map2 = new TreeMap<String, String>();
      map2.put("key1", "J");
      map2.put("key4", "M");
      map2.put("key3", "L");
      map2.put("key2", "K");

      System.out.print("TreeMap Keys:");
      displayAll(map2.keySet());
      System.out.print("TreeMap Values:");
      displayAll(map2.values());

      LinkedHashMap map3 = new LinkedHashMap();
      map3.put("key1", "JJJ");
      map3.put("key4", "MMM");
      map3.put("key2", "KKK");
      map3.put("key3", "LLL");
      System.out.print("LinkedHashMap Keys:");
      displayAll(map3.keySet());
      System.out.print("LinkedHashMap Values:");
      displayAll(map3.values());


   }

   static void displayAll(Collection col) {
      Iterator itr = col.iterator();
      while (itr.hasNext()) {
         String str = (String) itr.next();
         System.out.print(str + " ");
      }
      System.out.println();
   }

}
