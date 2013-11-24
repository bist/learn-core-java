/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter03.types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 */
@SuppressWarnings({"UnusedDeclaration", "ClassExplicitlyExtendsObject"})
public class SampleClass extends Object implements Serializable {
   @Deprecated public final String aFinalField = "A_FINAL_FIELD";
   protected final List<Integer> listOfIntegers;
   int packageProtectedField = 0;
   private Long specificToThisType = 0L;


   public SampleClass() {
      // constructor delegation
      this(new ArrayList<Integer>());
   }

   public SampleClass(@Deprecated List<Integer> listOfIntegers) {
      this.listOfIntegers = listOfIntegers;
   }

   public void sampleMethodWithNoArgs() {

   }

   public String sampleMethodWithArgumentsAndReturnValue(int index) {
      // method delegation
      return this.sampleMethodWithArgumentsAndReturnValueButOverloaded(index, 0);
   }

   public String sampleMethodWithArgumentsAndReturnValueButOverloaded(int index, int base) {
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
