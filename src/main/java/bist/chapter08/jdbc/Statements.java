/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter08.jdbc;

import java.sql.*;
import java.text.MessageFormat;

/**
 * @version 1.0
 */
public class Statements {
   public static void main(String[] args) {
      loadDriver();

      Connection connection = null;

      try {
         connection = DriverManager.getConnection("jdbc:hsqldb:file:demo.db");
         Statement statement = connection.createStatement();

         dropTable(statement);
         createTable(statement);

         insertTable(statement);
         queryTable(statement);

         updateTable(statement);
         queryTable(statement);

         preparedStatements(connection, "9th Symphony", "Beethoven");
         queryTable(statement);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         if (connection != null) {
            try {
               connection.close();
            } catch (SQLException ignored) { }
         }
      }
   }

   private static void preparedStatements(Connection connection, String newTitle, String composer) throws SQLException {
      String updateQuery = "update album set title=? where composer=?";
      PreparedStatement prepared = connection.prepareStatement(updateQuery);
      prepared.setString(1, newTitle);
      prepared.setString(2, composer);
      prepared.executeUpdate();
   }

   private static void updateTable(Statement statement) throws SQLException {
      statement.executeUpdate("update album set composer='Beethoven'");
   }

   private static void queryTable(Statement statement) throws SQLException {
      // query tables
      ResultSet resultSet = statement.executeQuery("SELECT * FROM album");
      while (resultSet.next()) {
         String title = resultSet.getString("title");
         String composer = resultSet.getString("composer");
         Date date = resultSet.getDate("published");

         System.out.println(
            MessageFormat.format(
                  "Title: {0}, Composer: {1}, Published Date: {2}",
                  title, composer, date
            )
         );
      }
   }

   private static void insertTable(Statement statement) throws SQLException {
      // insert table, update table, etc statements
      statement.executeUpdate(
         "INSERT INTO album (title, composer, published)" +
               "VALUES ('Fur Elise', 'Mozart', '1955-12-05')"
      );
   }

   private static void createTable(Statement statement) throws SQLException {
      // create table, alter table, etc statements
      statement.executeUpdate(
         "CREATE TABLE album (title VARCHAR(80), composer VARCHAR(120), published DATE)"
      );
   }

   private static void dropTable(Statement statement) throws SQLException {
      // drop table, drop column, etc statements
      statement.executeUpdate("DROP TABLE album;");
   }

   private static void loadDriver() {
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver").newInstance();
      } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ignored) { }
   }
}
