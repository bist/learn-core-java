package bist.chapter05;

public class Strings {

   public static void main(String[] args) {

      // string literal—a series of characters in your code that is enclosed in double quotes
      String greeting = "merhaba dünya!";
      System.out.println(greeting);

      // can create String objects by using the new keyword and a constructor
      char[] helloArray = {'h', 'e', 'l', 'l', 'o'};
      String helloString = new String(helloArray);
      System.out.println(helloString);

      //length
      int len = helloArray.length;
      System.out.println("length:" + len);

      //concat
      String s1 = "My name is ".concat("Erkan");
      String s2 = "My name is " + "Erkan";
      System.out.println("s1: " + s1);
      System.out.println("s2: " + s2);


      //formatting
      float floatVar = 1.305f;
      int intVar = 23;
      String stringVar = "eee";
      String fs;
      fs = String.format("The value of the float " +
            "variable is %f, while " +
            "the value of the " +
            "integer variable is %d, " +
            " and the string is %s",
            floatVar, intVar, stringVar);
      System.out.println(fs);
      //System.out.printf(....) ; hem format hem print bir arada.


      //Conversion: Number -> Strging
      double d = 858.48;
      String s = Double.toString(d);

      //Searching "."
      // indexOf first occurance
      // lastIndexOf last occurance
      int dot = s.indexOf('.');
      System.out.println(dot + " digits " + "before decimal point.");
      System.out.println((s.length() - dot - 1) + " digits after decimal point.");


      //java.lang.NumberFormatException
        /*
        String sInt= "34.4";
        int a = Integer.valueOf(sInt);
        System.out.println("sInt: "+a);
        */

      //find and replace;
      String findReplace = "Merhaba dunyalı ben dostum";
      System.out.println(findReplace.replace('a', 'A'));
      System.out.println(findReplace.replace("dunyalı", "DUNYALI"));

      //Comparing
      String test = "test";
      if ("test".equals(test)) {
         System.out.println("esitler");
      } else {
         System.out.println("esit degiller");
      }
      //Other Compares : endsWith, startsWith, equalsIgnoreCase


      // creates empty builder, capacity 16
      StringBuilder sb = new StringBuilder();
      // adds 9 character string at beginning
      sb.append("Greetings");
      //setLength(int newLength)

      // StringBuilders are
      // like StringBuffers
      // but not synchronized(thread safe), and so faster
      // Mutable

      //Append
      System.out.println(sb.insert(4, "AAA"));

      //Reverse
      System.out.println(sb.reverse());


      //Using String, StringBuffer or StringBuilder


   }


}
