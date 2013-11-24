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
public class BasicOperators {

   public static void main(String[] args) {
      int number1 = 3;
      int number2 = 5;

      int sum = number1 + number2;
      int product = number1 * number2;
      int difference = number1 - number2;
      int division = number1 / number2;

      System.out.println("sum = " + sum);
      System.out.println("product = " + product);
      System.out.println("difference = " + difference);
      System.out.println("division = " + division);

      double newDivision1 = (double) number1 / number2;
      double newDivision2 = number1 / (double) number2;

      System.out.println("division = " + newDivision1);
      System.out.println("division = " + newDivision2);

      int modular = number2 % number1;
      double power = Math.pow(number1, number2);

      System.out.println("modular = " + modular);
      System.out.println("power = " + power);

      double orderOfPresedence = 3 + 4 / 2 * 7 - 2;
      double withParanthesis = ((3 + 4) / (double) 2) * (7 - 2);

      System.out.println("orderOfPresedence = " + orderOfPresedence);
      System.out.println("withParanthesis = " + withParanthesis);
   }

}
