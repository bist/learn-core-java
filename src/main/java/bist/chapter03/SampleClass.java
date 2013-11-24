/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter03;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 */
@SuppressWarnings("UnusedDeclaration")
public class SampleClass {
   @Deprecated public final String aFinalField = "A_FINAL_FIELD";
   protected final List<Integer> listOfIntegers;
   int packageProtectedField = 0;
   private Long specificToThisType = 0L;


   public SampleClass() {
      listOfIntegers = new ArrayList<>();
   }

   public SampleClass(@Deprecated List<Integer> listOfIntegers) {
      this.listOfIntegers = listOfIntegers;
   }

   public void sampleMethodWithNoArgs() {

   }

   public String sampleMethodWithArgumentsAndReturnValue(int index) {
      return "";
   }

   @SuppressWarnings("UnusedDeclaration")
   void packageProtectedMethod() {

   }

   protected void inheritanceProtectedMethod() {

   }

   private void specificToThisType() {

   }
}
