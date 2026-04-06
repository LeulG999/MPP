package Lab5.prob2;

public class DecoyDuck extends Duck {

    public DecoyDuck() {
        flyBehavior = new CannotFly();
        quackBehavior = new MuteQuack();
    }

    public void display() {
        System.out.println("displaying");
    }
}
