package bist.chapter04;

/**
 * @version 1.0
 */
public class Interfaces {
   public static void main(String[] args) {
      // creating a class that implements an interface
      Duck duck = new Duck();
      duck.swim();

      // creating a class that implements two interfaces
      Goose goose = new Goose();
      goose.swim();
      goose.fly();

      // downcasting a type
      CanSwim downcasted = new Duck();
      downcasted.swim();

      // or
      CanFly downcastedNextGen = new Goose();
      downcastedNextGen.fly();

      // passing to a method
      flyMyGoose(goose);
      swimMyDuck(duck);

      // creating an anonymous class
      CanFly anonymous = new CanFly() {
         @Override
         public void fly() {
            System.out.println("Yeap, I can create classes like this!");
         }
      };
      anonymous.fly();
   }

   private static void swimMyDuck(Duck duck) {
      duck.swim();
   }

   private static void flyMyGoose(CanFly goose) {
      goose.fly();
   }
}

class Duck implements CanSwim {

   @Override
   public void swim() {
      System.out.println("I'm a swimming duck!");
   }

}

class Goose implements CanSwim, CanFly {

   @Override
   public void fly() {
      System.out.println("I believe I can fly!");
   }

   @Override
   public void swim() {
      System.out.println("I belive I can swim!");
   }

}

interface CanFly {
   void fly();
}

interface CanSwim {
   void swim();
}
