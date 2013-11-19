/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter01.homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @version 1.0
 */
public class Day1HomeworkTest {
   private final OutputStream outContent = new ByteArrayOutputStream();
   private final OutputStream errContent = new ByteArrayOutputStream();

   @Before
   public void setUp() throws Exception {
      System.setOut(new PrintStream(outContent));
      System.setErr(new PrintStream(errContent));
   }

   @Test
   public void main_ShouldPrintTheFirstArgument_WhenAtLeastOneArgumentGiven() throws Exception {
      // Arrange
      String expected = "ARGUMENT1";
      String[] args = { expected };

      // Act
      Day1Homework.main(args);
      String actual = outContent.toString();

      // Assert
      assertThat(actual.trim(), is(equalTo(expected)));

   }

   @After
   public void tearDown() throws Exception {
      System.setOut(null);
      System.setErr(null);
   }
}
