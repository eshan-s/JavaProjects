package inheritance;

public class inheritancedemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();   // Inherited from Animal
        dog.bark();  // Specific to Dog
    }
}

// Parent class
class Animal {
    void eat() {
        System.out.println("This animal eats food.");
    }
}

// Child class extends Animal
class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks.");
    }
}