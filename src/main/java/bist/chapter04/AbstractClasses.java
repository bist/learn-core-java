/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter04;

/**
 * @version 1.0
 */
public class AbstractClasses {
   public static void main(String[] args) {
      // classical usage of an abstract class with super type
      TemplateMethod a = new A();
      a.doSomething();
      a.someOtherUsefulMethodToAllTypes();

      // another classical usage with inherited type
      B b = new B();
      b.someOtherUsefulMethodToAllTypes();
      b.doSomething();
      b.doingAnAdditionalThing();

      // creating anonymous class with abstract types
      TemplateMethod anonymous = new TemplateMethod() {
         @Override
         void doSomething() {
            System.out.println("Yes, I can do this like Interfaces!");
         }
      };
      anonymous.doSomething();
      anonymous.someOtherUsefulMethodToAllTypes();
   }
}

// abstract class definition
abstract class TemplateMethod {
   abstract void doSomething();

   public void someOtherUsefulMethodToAllTypes() {
      System.out.println("I'm very useful method for everybody who extends from me!");
   }
}

class A extends TemplateMethod {

   @Override
   void doSomething() {
      System.out.println("I'm doing something from A");
   }

}

class B extends TemplateMethod {

   @Override
   void doSomething() {
      System.out.println("I'm doing something from B");
   }

   void doingAnAdditionalThing() {
      System.out.println("I'm also doing something else!");
   }

}