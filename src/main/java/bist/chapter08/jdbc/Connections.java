/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter08.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @version 1.0
 */
public class Connections {
   public static void main(String[] args) {
      loadDriver();
      createConnection();
   }

   private static void createConnection() {
      Connection connection = null;

      try {
         System.out.println("Connecting to the database...");

         // connecting the database url given below
         // at this point it creates in-memory database due to the driver we use
         connection = DriverManager.getConnection("jdbc:hsqldb:mem:.");

         System.out.println("Connected.");
      } catch (SQLException e) {
         System.out.println("Cannot get a connection!!!");
      } finally {
         // we have to make sure that the connection is closed after our usage
         if (connection != null) {
            try {
               System.out.println("We're done, closing connection!");
               connection.close();
               System.out.println("Closed.");
            } catch (SQLException e) {
               System.out.println("Cannot close the connection!!!");
            }
         }
      }
   }

   private static void loadDriver() {
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver").newInstance();

         System.out.println("Driver works just fine!");
      } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
         System.out.println("Driver is not loaded!");
      }
   }
}
