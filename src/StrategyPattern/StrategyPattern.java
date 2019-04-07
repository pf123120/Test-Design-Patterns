/**
 * 策略模式测试
 */

package StrategyPattern;

public class StrategyPattern {
    static public void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        Duck redheadDuck = new RedheadDuck();
        Duck rubberDuck = new RubberDuck();

        //New a DeadDuck.
        Duck deadDuck = new DeadDuck();

        StrategyPattern strategyPattern = new StrategyPattern();
        strategyPattern.a(mallardDuck);
        strategyPattern.a(redheadDuck);
        strategyPattern.a(rubberDuck);

        //DeadDuck does something.
        strategyPattern.a(deadDuck);
    }

    private void a(Duck duck) {
        duck.display();
        duck.performQuack();
        duck.performFly();
        duck.swim();
    }
}

abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void swim() {
        System.out.println("Pupu.");
    }

    public abstract void display();

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}

class MallardDuck extends Duck{
    @Override
    public void display() {
        System.out.println("Green head.");
    }

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
}

class RedheadDuck extends Duck {
    @Override
    public void display() {
        System.out.println("Red head.");
    }

    public RedheadDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
}

class RubberDuck extends Duck {
    @Override
    public void display() {
        System.out.println("Rubber head.");
    }

    public RubberDuck() {
        quackBehavior = new Squeak();
        flyBehavior = new FlyNoWay();
    }
}

/**
 * Add DeadDuck class.
 */
class DeadDuck extends Duck {
    @Override
    public void display() {
        System.out.println("Dead.");
    }

    public DeadDuck() {
        quackBehavior = new MuteQuack();
        flyBehavior = new FlyNoWay();
    }
}

interface FlyBehavior {
    void fly();
}

interface QuackBehavior {
    void quack();
}

class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Chuachua.");
    }
}

class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        // Unable to fly.
    }
}

class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Gaga.");
    }
}

class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Zhizhi.");
    }
}

class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        //Unable to quack.
    }
}