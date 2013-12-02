/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter05.generics;

import java.util.List;
import java.util.Set;

public class GenericsRestrictions {

   public static void main(String[] args) {

      //1- Cannot Instantiate Generic Types with Primitive Types
      //Test<int, char> p = new Pair<>(8, 'a');  // compile-time error
      Test<Integer, Character> p = new Test<>(Integer.valueOf(8), new Character('a'));


   }

   //2- Cannot Create Instances of Type Parameters
   public static <E> void append(List<E> list, Class<E> cls) throws IllegalAccessException, InstantiationException {
      //E elem = new E();  // compile-time error
      E elem = cls.newInstance();   // OK
      list.add(elem);

      //3- Cannot Use Casts or instanceof with Parameterized Types
      //if (list instanceof ArrayList<Integer>){}

      //4- Cannot Create Arrays of Parameterized Types
      //List<Integer>[] arrayOfLists = new List<Integer>[2];  // compile-time error


   }


}

//5-Cannot Create, Catch, or Throw Objects of Parameterized Types
// Extends Throwable indirectly
//class MathException<T> extends Exception { /* ... */ }    // compile-time error

// Extends Throwable directly
/*
class QueueFullException<T> {  // compile-time error

    public static <T extends Exception, J> void execute(List<J> jobs) {
        try {
            for (J job : jobs){}
        } catch (T e) {   // compile-time error
            // ...
        }
    }
}*/

//6-Cannot Overload a Method Where the Formal Parameter Types of Each Overload Erase to the Same Raw Type
class Example {
   public void print(Set<String> strSet) {
   }
   //public void print(Set<Integer> intSet) { }
}


class MobileDevice<T> {
   //7-Cannot Declare Static Fields Whose Types are Type Parameters
   //private static T os;

    /*
    MobileDevice<Smartphone> phone = new MobileDevice<>();
    MobileDevice<Pager> pager = new MobileDevice<>();
    MobileDevice<TabletPC> pc = new MobileDevice<>();
    */
}


class Test<K, V> {

   private K key;
   private V value;

   public Test(K key, V value) {
      this.key = key;
      this.value = value;
   }

}
