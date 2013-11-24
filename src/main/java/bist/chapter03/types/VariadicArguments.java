/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter03.types;

import java.util.Arrays;

/**
 * @version 1.0
 */
public class VariadicArguments {

   public void printAllElements(String... args) {
      System.out.println(Arrays.toString(args));
   }

}
