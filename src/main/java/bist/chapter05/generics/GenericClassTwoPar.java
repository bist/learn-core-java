/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter05.generics;

public class GenericClassTwoPar {

   public static void main(String a[]) {

      NewBox<String, Integer> sample
            = new NewBox<String, Integer>("HELLO", 100);
      sample.printTypes();
   }
}

/**
 * Simple generics class with two type parameters U, V.
 */
class NewBox<U, V> {

   //type U object reference
   private U objUreff;
   //type V object reference
   private V objVreff;

   //constructor to accept object type U and object type V
   public NewBox(U objU, V objV) {
      this.objUreff = objU;
      this.objVreff = objV;
   }

   public void printTypes() {
      System.out.println("U Type: " + this.objUreff.getClass().getName());
      System.out.println("V Type: " + this.objVreff.getClass().getName());
   }
}