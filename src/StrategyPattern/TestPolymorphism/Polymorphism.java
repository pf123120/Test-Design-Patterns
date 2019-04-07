/**
 * 多态测试
 */

package StrategyPattern.TestPolymorphism;

public class Polymorphism {
    public static void main(String[] args) {
        Polymorphism polymorphism = new Polymorphism();

        Duck mallardDuck = new MallardDuck();
        Duck redheadDuck = new RedheadDuck();
        Duck rubberDuck = new RubberDuck();

        //New a DeadDuck.
        Duck deadDuck = new DeadDuck();

        polymorphism.a(mallardDuck);
        polymorphism.a(redheadDuck);
        polymorphism.a(rubberDuck);

        //DeadDuck does something.
        polymorphism.a(deadDuck);
    }

    private void a(Duck duck) {
        duck.swim();
        duck.fly();
        duck.display();
        duck.quack();

    }
}

abstract class Duck {
    public void swim() {
        System.out.println("Pupu.");
    }

    public void fly() {
        System.out.println("Chuachua.");
    }

    public void quack() {
        System.out.println("Gaga.");
    }

    public abstract void display();
}

class MallardDuck extends Duck {
    public void display() {
        System.out.println("Mallard.");
    }
}

class RedheadDuck extends Duck {
    public void display() {
        System.out.println("Redhead.");
    }
}

class RubberDuck extends Duck {
    public void display() {
        System.out.println("Rubber.");
    }

    public void fly() {
        System.out.println("Unable to fly.");
    }

    public void quack() {
        System.out.println("Zhizhi.");
    }
}

/**
 * Add DeadDuck class.
 */
class DeadDuck extends Duck {
    public void display() {
        System.out.println("Dead.");
    }

    public void fly() {
        System.out.println("Unable to fly.");
    }

    public void quack() {
        System.out.println("Unable to quack.");
    }
}