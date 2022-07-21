interface Animal {
    void eat();

    void sound();
}

interface TiredAnimal extends Animal {
    boolean canUHunt();
}

class Lion implements Animal {
    String name = "Lion";

    Lion(String name) {
        this.name = name;
    }

    void whoAreYou() {
        System.out.println("I am " + name + " a lion");
    }

    @Override
    public void eat() {
        System.out.println("I am eating fleshes");
    }

    public void sound() {
        System.out.println("Roar...");
    }

}

class Snake implements TiredAnimal {

    String name;

    Snake(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("I eat rats and worms");
    }

    public void sound() {
        System.out.println("Pssss");
    }

    public boolean canUHunt() {
        return false;
    }
}

public class prog5 {
    public static void main(String[] args) {
        Lion l1 = new Lion("Sher");
        Snake s1 = new Snake("Anaconda");
        l1.sound();
        l1.eat();
        l1.whoAreYou();
        s1.sound();
        if (s1.canUHunt()) System.out.println("Snake " + s1.name + " can hunt");
        else System.out.println("Snake " + s1.name + " is tired");
    }
}



