/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter05.generics;

/*
* Generics add a way to specify concrete types to general purpose classes and methods that operated on Object
*
* */


public class GenericClass {

   public static void main(String a[]) {

      //create Box object with String as type parameter
      Box<String> sgs = new Box<String>("HELLO");
      sgs.printType();

      //create Box object with Boolean as type parameter
      Box<Boolean> sgb = new Box<Boolean>(Boolean.TRUE);
      sgb.printType();

      // Diamond Operator <>
      // Java compiler can infer the Integer from the context
      Box<Integer> intBox = new Box<>();
      intBox.setObjReff(2);
      intBox.printType();

      // Raw types:
      // Box is the raw type of the generic type Box<T>
      Box rawBox = new Box();
      Box<Integer> integerBox = new Box<>(222);
      rawBox = integerBox;    // OK
      rawBox.printType();

      try {
         //no compilation error i.e. no type checking at compile time
         OldBox oldStringBox = new OldBox(123);
         ((String) oldStringBox.getObjReff()).toUpperCase();
         //will throw ClassCastException at runtime
      } catch (ClassCastException e) {
         System.out.println("Not a String object stored in the box");
      }

   }
}

/**
 * Here T is a type parameter, and it will be replaced with
 * actual type when the object got created.
 */
class Box<T> {

   //declaration of object type T
   private T objReff = null;

   //constructor to accept type parameter T
   public Box(T param) {
      this.objReff = param;
   }

   public Box() {
   }

   public T getObjReff() {
      return this.objReff;
   }

   void setObjReff(T objReff) {
      this.objReff = objReff;
   }

   //this method prints the holding parameter type
   public void printType() {
      System.out.println("Type: " + objReff.getClass().getName() + " : " + this.objReff);
   }

}

class OldBox {
   private Object objReff = null;

   public OldBox(Object o) {
      this.objReff = o;
   }

   Object getObjReff() {
      return objReff;
   }

   void setObjReff(Object objReff) {
      this.objReff = objReff;
   }
}
