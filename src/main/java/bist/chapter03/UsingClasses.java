/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter03;

import bist.chapter03.types.SampleClass;
import bist.chapter03.types.VariadicArguments;

/**
 * @version 1.0
 */
public class UsingClasses {

   public static void main(String[] args) {

      SampleClass myClass = new SampleClass();
      System.out.println(myClass.sampleMethodWithArgumentsAndReturnValue(3));

      VariadicArguments varargs = new VariadicArguments();
      varargs.printAllElements("john", "rambo");
      varargs.printAllElements("superman", "batman", "robin", "cat-woman");

   }

}
