/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter05.generics;


import java.util.ArrayList;
import java.util.List;

public class GenericsBasics {

    /*
    * Parametric Polymorphism :
    *    Parameters when defining classes, interfaces and methods
    *    Provides a way for you to re-use the same code with different input types
    *
    *    Benefits:
    *     - Stronger type checks at compile time.
    *     - Elimination of casts.
    *     - Helps to implement generic algorithms.
    *
    *   The most commonly used type parameter names are:
    *       E - Element (used extensively by the Java Collections Framework)
    *       K - Key
    *       N - Number
    *       T - Type
    *       V - Value
    *       S,U,V etc. - 2nd, 3rd, 4th types
    *
    *
    * */

   public static void main(String[] args) {
      List myIntList = new ArrayList(); // ==> No Type definition
      myIntList.add(new Integer(0));
      Integer x = (Integer) myIntList.get(0); // ==> Casting required


      List<Integer> myNewIntList = new ArrayList<Integer>(); // Integer type defined
      myNewIntList.add(new Integer(0));
      Integer y = myNewIntList.get(0); // ==> No casting


   }


}
