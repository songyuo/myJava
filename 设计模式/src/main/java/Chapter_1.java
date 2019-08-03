/*
  第一章 设计模式入门
  定义一个鸭子超类，里面有各种方法，让各个鸭子子类继承，但是有的鸭子不会飞，有的鸭子会飞；有的鸭子这样叫，有的那样叫，这就需要重载
  利用超类实现继承, 虽然可以实现代码复用，但是每新增一个子类都要去写覆盖方法，会比较麻烦；
  如果利用接口，让需要实现相关功能的鸭子子类实现该接口，比如定义一个飞行行为接口，让会飞的鸭子子类去实现，但这样会造成代码无法复用；
  所以，可以定义一个接口，再定义几个不同的飞行子类去实现此接口，这样就可以解决复用问题；
  即，在鸭子超类中定义接口，如飞行接口，然后用不同的行为类实现接口
 */

/*
 * 软件开发的不变真理：change
 * 两条设计原则：
 * ①找出应用中可能变化之处，把它们独立出来，不要和不需要变化的代码混在一起
 * ②针对接口编程，而不是针对实现编程
 */
public class Chapter_1 {

    public interface FlyBehavior {
        void fly();
    }

    public interface QuackBehavior {
        void quack();
    }

    public static class FlyNoWay implements FlyBehavior {
        public void fly() {
            System.out.println("我就不飞...");
        }
    }

    public static class FlyWithWings implements FlyBehavior {
        public void fly() {
            System.out.println("飞起来了耶....");
        }
    }

    public static class Quack implements QuackBehavior {
        public void quack() {
            System.out.println("quack...");
        }
    }

    public static class MuteQuack implements QuackBehavior {
        public void quack() {
            System.out.println("我自闭了...");
        }
    }

    public abstract static class Duck {

        FlyBehavior flyBehavior;
        QuackBehavior quackBehavior;


        void performQuack() {
            quackBehavior.quack();
        }

        void performFly() {
            flyBehavior.fly();
        }

        // 下面的两个方法可以实现动态改变鸭子的飞行和鸣叫行为

        void setFlyBehavior(FlyBehavior flyBehavior){
            this.flyBehavior = flyBehavior;
        }

        void setQuackBehavior(QuackBehavior quackBehavior){
            this.quackBehavior = quackBehavior;
        }

        public void swim() {
            System.out.println("ALL DUCK CAN SWIM!!");
        }

        // 更多通用方法略

    }

    public static class MallardDuck extends Duck{
        /**
         * 这里的构造器仍然是针对实现编程（只是暂时，后面的章节会提出新的办法）
         */

        MallardDuck(){
            this.flyBehavior = new FlyNoWay();
            this.quackBehavior = new Quack();
        }

        public static void main(String[] args) {
            Duck duck = new MallardDuck();
            duck.performFly();
            duck.performQuack();
        }
    }

    public static void main(String[] args) {
        // 尝试动态改变鸭子的行为

        Duck duck = new MallardDuck();

        duck.performQuack();
        duck.performFly();

        duck.setFlyBehavior(new FlyWithWings());
        duck.setQuackBehavior(new MuteQuack());

        duck.performQuack();
        duck.performFly();
    }

}
