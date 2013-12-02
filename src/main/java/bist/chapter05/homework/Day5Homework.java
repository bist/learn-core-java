/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter05.homework;

/**
 * @version 1.0
 */
public class Day5Homework {
   /**
    * OBJECTIVE:
    *
    * There are many DAO implementations given. Remove all of them and
    * create a DAO interface that supports various person types like:
    *
    * Person, Student, Manager kinda types. For instance findBy method
    * should return this type when invoked.
    *
    * CAUTION:
    *
    * - Make sure that wildcardFilter method supports wildcard operations like
    * ?e?i => Veli, Zeki, vb
    * Ay* => Ayhan, Aybars
    * *tan* => Istanbul, Dagistan, Tandogan, Katana
    *
    * - Make sure that we are not able to create a generic DAO for all types like
    * String, BigDecimal, etc.. It should be only types where it has id, name, age, title
    * in it.
    *
    */
}
