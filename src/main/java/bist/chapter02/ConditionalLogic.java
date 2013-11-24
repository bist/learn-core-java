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
public class ConditionalLogic {

   public static void main(String[] args) {
      int age = 20;

      if (age > 10) {
         System.out.println("Wooow");
      }

      double salary = 30_000;

      if (age < 30 || salary > 10_000) {
         System.out.println("Salary = " + salary);
      }

      if (salary > 50_000) {
         System.out.println("Boooo");
      } else {
         System.out.println("Yeap");
      }

      if (age > 10 && salary > 40_000) {
         System.out.println("Nah!");
      } else if (age < 30) {
         System.out.println("Correct age");
      }

      switch (age) {
         case 20:
            System.out.println("age2 = " + age);
            break;
         case 30:
            System.out.println("another case");
         default:
            System.out.println("By default!");
      }
   }

}
