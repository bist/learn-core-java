/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter05.generics;

public class BoundedGenerics {

   public static void main(String a[]) {
      //Creating object of sub class C and
      //passing it to BoundEx as a type parameter.
      BoundEx<C> bec = new BoundEx<C>(new C());
      bec.doRunTest();
      //Creating object of sub class B and
      //passing it to BoundEx as a type parameter.
      BoundEx<B> beb = new BoundEx<B>(new B());
      beb.doRunTest();
      //similarly passing super class A
      BoundEx<A> bea = new BoundEx<A>(new A());
      bea.doRunTest();

      //If you uncomment below code it will throw compiler error
      //becasue we restricted to only of type A and its sub classes.
      //BoundEx<String> bes = new BoundEx<String>(new String());
      //bea.doRunTest();

   }
}

/**
 * This class only accepts type parametes as any class
 * which extends class A or class A itself.
 * Passing any other type will cause compiler time error
 */
class BoundEx<T extends A> {

   private T objRef;

   public BoundEx(T obj) {
      this.objRef = obj;
   }

   public void doRunTest() {
      this.objRef.printClass();
   }
}

class A {
   public void printClass() {
      System.out.println("I am in super class A");
   }
}

class B extends A {
   public void printClass() {
      System.out.println("I am in sub class B");
   }
}

class C extends A {
   public void printClass() {
      System.out.println("I am in sub class C");
   }
}
