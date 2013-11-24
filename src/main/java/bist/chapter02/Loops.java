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
public class Loops {

   public static void main(String[] args) {

      for (int i = 1; i <= 10; i++) {
         System.out.println("i = " + i);
      }

      for (int i = 1; i <= 10; ) {
         System.out.println("i++ = " + i++);
      }

      int i = 1;
      for (; i < 10; ) {
         System.out.println("++i = " + ++i);
      }

      for (int j = 0, k = 1; j < k && k < 10; j++, k++) {
         System.out.println("j = " + j);
         System.out.println("k = " + k);
      }

      int z = 0;
      while (z < 10) {
         System.out.println("++z = " + ++z);
      }

      do {
         System.out.println("print this first and then quit");
      } while (false);

      int j = 0;
      for (;;) {
         j++;

         if (j < 3) {
            continue;
         }

         System.out.println("j = " + j);

         if (j > 10) {
            break;
         }
      }
   }

}
