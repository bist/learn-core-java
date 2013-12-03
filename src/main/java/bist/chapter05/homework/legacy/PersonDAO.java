/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter05.homework.legacy;

import bist.chapter05.homework.Title;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 */
public class PersonDAO {
   Person findBy(double id) {
      return null;
   }

   List<Person> filterBy(int age) {
      return null;
   }

   List<Person> wildcardFilterBy(String name) {
      return null;
   }

   Map<Integer, List<Person>> groupByAge() {
      return null;
   }

   Map<Title, List<Person>> groupByTitle() {
      return null;
   }
}
