/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter04.homework;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @version 1.0
 */
public class Day4HomeworkTest {
   @Test
   public void printReceipt_ShouldPrintReceipt_WhenNoImportedGoodsInIt() throws Exception {
      // Arrange
      List<String> basket = Arrays.asList("1 novel at 12.49", "1 DVD at 14.99", "1 puding at 0.85");
      List<String> expected = Arrays.asList("1 novel: 12.49", "1 DVD: 16.49", "1 puding: 0.85", "Tax: 1.50", "Total: 29.83");

      // Act
      Day4Homework sut = new Day4Homework();
      String[] actual = sut.printReceipt(basket.toArray(new String[basket.size()]));

      // Assert
      assertThat(Arrays.asList(actual), equalTo(expected));
   }

   @Test
   public void printReceipt_ShouldPrintReceipt_WhenOnlyImportedGoodsInIt() throws Exception {
      // Arrange
      List<String> basket = Arrays.asList("1 imported puding at 10.00", "1 imported shampoo at 47.50");
      List<String> expected = Arrays.asList("1 imported puding: 10.50", "1 imported shampoo: 54.65", "Tax: 7.65", "Total: 65.15");

      // Act
      Day4Homework sut = new Day4Homework();
      String[] actual = sut.printReceipt(basket.toArray(new String[basket.size()]));

      // Assert
      assertThat(Arrays.asList(actual), equalTo(expected));
   }

   @Test
   public void printReceipt_ShouldPrintReceipt_WhenMixOfNormalAndImportedGoodsInIt() throws Exception {
      // Arrange
      List<String> basket = Arrays.asList("1 imported shampoo at 27.99", "1 shampoo at 18.99", "1 injury bandage at 9.75", "1 imported puding at 11.25");
      List<String> expected = Arrays.asList("1 imported shampoo: 32.19", "1 shampoo: 20.89", "1 injury bandage: 9.75", "1 imported puding: 11.85", "Tax: 6.70", "Total: 74.68");

      // Act
      Day4Homework sut = new Day4Homework();
      String[] actual = sut.printReceipt(basket.toArray(new String[basket.size()]));

      // Assert
      assertThat(Arrays.asList(actual), equalTo(expected));
   }
}
