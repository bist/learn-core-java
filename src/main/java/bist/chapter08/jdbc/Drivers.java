/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter08.jdbc;

/**
 * @version 1.0
 */
public class Drivers {
   /**
    * Driver interface
    */
   public static void main(String[] args) {
      try {
         // we are loading the JDBC driver, and creating an instance of it
         // there are 4 different driver types, this one is Type-4
         Class.forName("org.hsqldb.jdbc.JDBCDriver").newInstance();

         System.out.println("Driver works just fine!");
      } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
         System.out.println("Driver is not loaded!");
      }
   }
}
