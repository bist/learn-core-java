/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter05.generics;

public class BoundedWithInterface {

   public static void main(String a[]) {

      //Creating object of implementation class X called Y and
      //passing it to BoundExmp as a type parameter.
      BoundExmp<Y> bey = new BoundExmp<Y>(new Y());
      bey.doRunTest();
      //Creating object of implementation class X called Z and
      //passing it to BoundExmp as a type parameter.
      BoundExmp<Z> bez = new BoundExmp<Z>(new Z());
      bez.doRunTest();
      //If you uncomment below code it will throw compiler error
      //becasue we restricted to only of type X  implementation classes.
      //BoundExmp<String> bes = new BoundExmp<String>(new String());
      //bea.doRunTest();
   }
}

class BoundExmp<T extends X> {

   private T objRef;

   public BoundExmp(T obj) {
      this.objRef = obj;
   }

   public void doRunTest() {
      this.objRef.printClass();
   }
}

interface X {
   public void printClass();
}

class Y implements X {
   public void printClass() {
      System.out.println("I am in class Y");
   }
}

class Z implements X {
   public void printClass() {
      System.out.println("I am in class Z");
   }
}
