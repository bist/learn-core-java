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
public class WrapperTypes {

   public static void main(String[] args) {
      // Primitive bytes
      Byte aByte = new Byte("3");
      Byte minByte = Byte.MIN_VALUE;
      Byte maxByte = Byte.MAX_VALUE;

      System.out.println("aByte = " + aByte);
      System.out.println("minByte = " + minByte);
      System.out.println("maxByte = " + maxByte);

      // Primitive shorts
      Short aShort = new Short("3");
      Short minShort = Short.MIN_VALUE;
      Short maxShort = Short.MAX_VALUE;

      System.out.println("aShort = " + aShort);
      System.out.println("minShort = " + minShort);
      System.out.println("maxShort = " + maxShort);

      // Primitive integers
      Integer anInteger = new Integer("3");
      Integer minInteger = Integer.MIN_VALUE;
      Integer maxInteger = Integer.MAX_VALUE;

      System.out.println("anInteger = " + anInteger);
      System.out.println("minInteger = " + minInteger);
      System.out.println("maxInteger = " + maxInteger);

      // Primitive longs
      Long aLong = new Long("3");
      Long minLong = Long.MIN_VALUE;
      Long maxLong = Long.MAX_VALUE;

      System.out.println("aLong = " + aLong);
      System.out.println("minLong = " + minLong);
      System.out.println("maxLong = " + maxLong);

      // Primitive floats
      Float aFloat = new Float("3.3");
      Float minFloat = Float.MIN_VALUE;
      Float maxFloat = Float.MAX_VALUE;

      System.out.println("aFloat = " + aFloat);
      System.out.println("minFloat = " + minFloat);
      System.out.println("maxFloat = " + maxFloat);

      // Primitive double
      Double aDouble = new Double("3.3");
      Double minDouble = Double.MIN_VALUE;
      Double maxDouble = Double.MAX_VALUE;

      System.out.println("aDouble = " + aDouble);
      System.out.println("minDouble = " + minDouble);
      System.out.println("maxDouble = " + maxDouble);

      // Primitive booleans
      Boolean trueBoolean = Boolean.TRUE;
      Boolean falseBoolean = Boolean.FALSE;

      System.out.println("trueBoolean = " + trueBoolean);
      System.out.println("falseBoolean = " + falseBoolean);

      // Primitive char
      Character aChar = 'c';
      Character otherChar = 65;
      Character anotherChar = '\u2661';

      System.out.println("aChar = " + aChar);
      System.out.println("otherChar = " + otherChar);
      System.out.println("anotherChar = " + anotherChar);

      // Default values
      Byte defaultByte; // will be null
      Short defaultShort; // will be null
      Integer defaultInt; // will be null
      Long defaultLong; // will be null
      Float defaultFloat; // will be null
      Double defaultDouble; // will be null
      Boolean defaultBoolean; // will be null
      Character defaultChar; // will be null
   }

}
