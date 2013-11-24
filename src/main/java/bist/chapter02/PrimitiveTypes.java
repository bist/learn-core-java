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
public class PrimitiveTypes {

   public static void main(String[] args) {
      // Primitive bytes
      byte aByte = 3;
      byte minByte = Byte.MIN_VALUE;
      byte maxByte = Byte.MAX_VALUE;

      System.out.println("aByte = " + aByte);
      System.out.println("minByte = " + minByte);
      System.out.println("maxByte = " + maxByte);

      // Primitive shorts
      short aShort = 3;
      short minShort = Short.MIN_VALUE;
      short maxShort = Short.MAX_VALUE;

      System.out.println("aShort = " + aShort);
      System.out.println("minShort = " + minShort);
      System.out.println("maxShort = " + maxShort);

      // Primitive integers
      int anInteger = 3;
      int minInteger = Integer.MIN_VALUE;
      int maxInteger = Integer.MAX_VALUE;

      System.out.println("anInteger = " + anInteger);
      System.out.println("minInteger = " + minInteger);
      System.out.println("maxInteger = " + maxInteger);

      // Primitive longs
      long aLong = 3L;
      long minLong = Long.MIN_VALUE;
      long maxLong = Long.MAX_VALUE;

      System.out.println("aLong = " + aLong);
      System.out.println("minLong = " + minLong);
      System.out.println("maxLong = " + maxLong);

      // Primitive floats
      float aFloat = 2.3f;
      float minFloat = Float.MIN_VALUE;
      float maxFloat = Float.MAX_VALUE;

      System.out.println("aFloat = " + aFloat);
      System.out.println("minFloat = " + minFloat);
      System.out.println("maxFloat = " + maxFloat);

      // Primitive double
      double aDouble = 2.3D;
      double minDouble = Double.MIN_VALUE;
      double maxDouble = Double.MAX_VALUE;

      System.out.println("aDouble = " + aDouble);
      System.out.println("minDouble = " + minDouble);
      System.out.println("maxDouble = " + maxDouble);

      // Primitive booleans
      boolean trueBoolean = true;
      boolean falseBoolean = false;

      System.out.println("trueBoolean = " + trueBoolean);
      System.out.println("falseBoolean = " + falseBoolean);

      // Primitive char
      char aChar = 'c';
      char otherChar = 65;
      char anotherChar = '\u2661';

      System.out.println("aChar = " + aChar);
      System.out.println("otherChar = " + otherChar);
      System.out.println("anotherChar = " + anotherChar);

      // Default values
      byte defaultByte; // will be 0
      short defaultShort; // will be 0
      int defaultInt; // will be 0
      long defaultLong; // will be 0L
      float defaultFloat; // will be 0.0f
      double defaultDouble; // will be 0.0D
      boolean defaultBoolean; // will be false
      char defaultChar; // will be \u0000

      // You can use _ for thousand seperator
      int sample = 30_000;
   }

}
