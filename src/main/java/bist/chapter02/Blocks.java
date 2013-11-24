/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter02;

/**
 * @version 1.0
 */
public class Blocks {

   {
      int someNumber = 3;
      System.out.println("someNumber = " + someNumber);
   }

   static {
      int staticNumber = 5;
      System.out.println("staticNumber = " + staticNumber);
   }

   public static void main(String[] args) {
      int number = 3;
      System.out.println("number = " + number);

      {
         int number2 = 4;
         System.out.println("number = " + number);
         System.out.println("number2 = " + number2);
      }

      // System.out.println("number2 = " + number2); // cannot do
      // System.out.println("someNumber = " + someNumber); // cannot do

      // new Blocks();
   }

}
