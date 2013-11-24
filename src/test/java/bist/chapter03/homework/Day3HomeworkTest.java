/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter03.homework;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @version 1.0
 */
public class Day3HomeworkTest {

   @Test
   public void getCacheSize_ShouldReturnZero_WhenCacheIsEmpty() throws Exception {
      // Arrange
      Day3Homework sut = new Day3Homework(10);

      // Act
      int actual = sut.getCacheSize();

      // Assert
      assertThat(actual, is(equalTo(0)));
   }

   @Test
   public void addElement_ShouldAddElementToCache_WhenValidElementGiven() throws Exception {
      // Arrange
      String validItem = "VALID_ELEMENT";
      Day3Homework sut = new Day3Homework(10);

      // Act
      boolean actual = sut.addElement(validItem);

      // Assert
      assertThat(sut.getCacheSize(), is(equalTo(1)));
      assertThat(actual, is(true));
   }

   @Test
   public void addElement_ShouldNotAddElementToCache_WhenCacheIsFull() throws Exception {
      // Arrange
      String validItem = "VALID_ELEMENT";
      Day3Homework sut = new Day3Homework(0);

      // Act
      boolean actual = sut.addElement(validItem);

      // Assert
      assertThat(sut.getCacheSize(), is(equalTo(0)));
      assertThat(actual, is(false));
   }

   @Test
   public void getItem_ShouldReturnLastItem_WhenMultipleElementsAddedToCache() throws Exception {
      // Arrange
      String anItem = "A_VALID_ELEMENT";
      String lastItem = "LAST_ELEMENT";

      Day3Homework sut = new Day3Homework(10);
      sut.addElement(anItem);
      sut.addElement(lastItem);

      // Act
      String actual = sut.getItem();

      // Assert
      assertThat(actual, is(equalTo(lastItem)));
   }

   @SuppressWarnings("UnusedDeclaration")
   @Test
   public void getItem_ShouldReduceCacheSize_WhenMultipleElementsAddedToCache() throws Exception {
      // Arrange
      String anItem = "A_VALID_ELEMENT";
      String lastItem = "LAST_ELEMENT";

      Day3Homework sut = new Day3Homework(10);
      sut.addElement(anItem);
      sut.addElement(lastItem);

      // Act
      String actual = sut.getItem();

      // Assert
      assertThat(sut.getCacheSize(), is(equalTo(1)));
   }

   @Test
   public void getItem_ShouldReturnNothing_WhenCacheIsEmpty() throws Exception {
      // Arrange
      Day3Homework sut = new Day3Homework(10);

      // Act
      String actual = sut.getItem();

      // Assert
      assertThat(actual, is(equalTo(null)));
   }

   @Test
   public void flushCache_ShouldRemoveAllElementsFromCache() throws Exception {
      // Arrange
      String validItem = "VALID_ELEMENT";

      Day3Homework sut = new Day3Homework(10);
      sut.addElement(validItem);

      // Act
      sut.flushCache();

      // Assert
      assertThat(sut.getCacheSize(), is(equalTo(0)));
   }

}
