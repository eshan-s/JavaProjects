package abstractvsinterface;

public class abstractdemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound(); // specific behavior
        dog.eat();       // shared behavior
    }
}

// Abstract class = blueprint
abstract class Animal {
    abstract void makeSound();

    void eat() {
        System.out.println("This animal eats food.");
    }
}

// Subclass that provides specific sound
class Dog extends Animal {
    void makeSound() {
        System.out.println("Dog barks.");
    }
}