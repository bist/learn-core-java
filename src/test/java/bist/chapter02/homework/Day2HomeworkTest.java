/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter02.homework;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @version 1.0
 */
public class Day2HomeworkTest {

   @Test
   public void findPalindromes_ShouldNotFindAnyPalindromes_WhenInvalidPalindromesGiven() throws Exception {
      // Arrange
      String invalidPalindrome = "NOT_A_PALINDROME";

      // Act
      int actual = Day2Homework.findPalindromes(new String[]{invalidPalindrome});

      // Assert
      assertThat(actual, is(equalTo(0)));
   }

   @Test
   public void findPalindromes_ShouldFindSingleWordPalindromes_WhenValidPalindromesGiven() throws Exception {
      // Arrange
      String validPalindrome = "KAYAK";

      // Act
      int actual = Day2Homework.findPalindromes(new String[]{validPalindrome});

      // Assert
      assertThat(actual, is(equalTo(1)));
   }

   @Test
   public void findPalindromes_ShouldFindTwoWordPalindromes_WhenValidPalindromesGiven() throws Exception {
      // Arrange
      String validPalindrome = "KAYA AYAK";

      // Act
      int actual = Day2Homework.findPalindromes(new String[]{validPalindrome});

      // Assert
      assertThat(actual, is(equalTo(1)));
   }

   @Test
   public void findPalindromes_ShouldFindPalindromes_WhenManyValidPalindromesGiven() throws Exception {
      // Arrange
      String validPalindrome1 = "KAYAK";
      String validPalindrome2 = "ABA";

      // Act
      int actual = Day2Homework.findPalindromes(new String[]{validPalindrome1, validPalindrome2});

      // Assert
      assertThat(actual, is(equalTo(2)));
   }

   @Test
   public void findPalindromes_ShouldFindSingleWordPalindromeWithPunctiations_WhenValidPalindromesGiven() throws Exception {
      // Arrange
      String validPalindrome = "ADANA'DA";

      // Act
      int actual = Day2Homework.findPalindromes(new String[]{validPalindrome});

      // Assert
      assertThat(actual, is(equalTo(1)));
   }

   @Test
   public void findPalindromes_ShouldFindManyWordPalindromesWithPunctiations_WhenValidPalindromesGiven() throws Exception {
      // Arrange
      String validPalindrome = "EY EDIP, ADANA'DA PIDE YE";

      // Act
      int actual = Day2Homework.findPalindromes(new String[]{validPalindrome});

      // Assert
      assertThat(actual, is(equalTo(1)));
   }

   @Test public void findPalindromes_ShouldSolveHomework() throws Exception {
      // Arrange
      String[] homework = {"AMORE, ROMA", "KAYAK", "ABI", "A MAN, A PLAN, A CANAL: PANAMA"};

      // Act
      int actual = Day2Homework.findPalindromes(homework);

      // Assert
      assertThat(actual, is(equalTo(3)));
   }

}
