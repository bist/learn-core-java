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
public class Arrays {

   public static void main(String[] args) {
      int[] numbers = new int[]{1, 2, 3};
      int[] emptyArray = new int[0];

      System.out.println("numbers = " + java.util.Arrays.toString(numbers));
      System.out.println("emptyArray = " + java.util.Arrays.toString(emptyArray));

      // emptyArray[0] = 3; // will throw exception
      // System.out.println("emptyArray = " + java.util.Arrays.toString(emptyArray));

      System.out.println("2nd index in numbers = " + numbers[2]);

      for (int i = 0; i < numbers.length; i++) {
         System.out.println("numbers[" + i + "] = " + numbers[i]);
      }

      for (int number : numbers) {
         System.out.println("number = " + number);
      }

      int[][] multi = new int[][] {
            {1, 2},
            {0, 1, 2, 3}
      };

      System.out.println("multi[0][1] = " + multi[0][1]);

      for (int[] arr : multi) {
         System.out.println("arr = " + java.util.Arrays.toString(arr));
      }

   }

}
