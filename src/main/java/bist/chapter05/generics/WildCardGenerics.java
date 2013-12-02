/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter05.generics;

import java.util.Arrays;
import java.util.List;

public class WildCardGenerics {

    /*
    * In generic code, the question mark (?), called the wildcard, represents an unknown type.
    *
    * */

   public static void main(String a[]) {

      MyEmployeeUtil<CompAEmp> empA
            = new MyEmployeeUtil<CompAEmp>(new CompAEmp("Ram", 20000));
      MyEmployeeUtil<CompBEmp> empB
            = new MyEmployeeUtil<CompBEmp>(new CompBEmp("Krish", 30000));
      MyEmployeeUtil<CompAEmp> empC
            = new MyEmployeeUtil<CompAEmp>(new CompAEmp("Nagesh", 20000));
      System.out.println("Is salary same? " + empA.isSalaryEqual(empB));
      System.out.println("Is salary same? " + empA.isSalaryEqual(empC));

      List<Integer> li = Arrays.asList(1, 2, 3);
      System.out.println("sum = " + sumOfList(li));

      List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
      System.out.println("sum = " + sumOfList(ld));

   }

   //Upper Bounded Wildcards:
   public static double sumOfList(List<? extends Number> list) {
      double s = 0.0;
      for (Number n : list)
         s += n.doubleValue();
      return s;
   }

   //Lower Bounded Wildcards:
   public static void addNumbers(List<? super Integer> list) {
      for (int i = 1; i <= 10; i++) {
         list.add(i);
      }
   }

}

class MyEmployeeUtil<T extends Emp> {

   private T emp;

   public MyEmployeeUtil(T obj) {
      emp = obj;
   }

   public int getSalary() {
      return emp.getSalary();
   }


   public boolean isSalaryEqual(MyEmployeeUtil<?> otherEmp) {

      if (emp.getSalary() == otherEmp.getSalary()) {
         return true;
      }
      return false;
   }

   //// create some utility methods to do employee functionalities
   //
   //
   //
}

class Emp {

   private String name;
   private int salary;

   public Emp(String name, int sal) {
      this.name = name;
      this.salary = sal;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getSalary() {
      return salary;
   }

   public void setSalary(int salary) {
      this.salary = salary;
   }
}

class CompAEmp extends Emp {

   public CompAEmp(String nm, int sal) {
      super(nm, sal);
   }
}

class CompBEmp extends Emp {

   public CompBEmp(String nm, int sal) {
      super(nm, sal);
   }
}
