package polymorphism;

public class polymorphismdemo {
    public static void main(String[] args) {
        Animal myAnimal = new Dog();  // Parent reference, child object
        myAnimal.speak();             // Calls Dog's overridden speak()

        myAnimal = new Cat();         // Change to a Cat object
        myAnimal.speak();             // Calls Cat's overridden speak()
    }
}

// Parent class
class Animal {
    void speak() {
        System.out.println("Animal speaks.");
    }
}

// Child class 1
class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("Dog barks.");
    }
}

// Child class 2
class Cat extends Animal {
    @Override
    void speak() {
        System.out.println("Cat meows.");
    }
}