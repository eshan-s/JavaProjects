package abstractvsinterface;

public class interfacedemo {
   public static void main(String[] args) {
        Cat c = new Cat();
        c.makeSound();   
        c.eat();         
    }
}


interface Animals {
    void makeSound(); 
    void eat();       
}

// Class implements the interface
class Cat implements Animals {
    public void makeSound() {
        System.out.println("Cat meows.");
    }

    public void eat() {
        System.out.println("Cat eats fish.");
    }
}


// Abstract class vs Interface:
// Abstract classes can have both defined (concrete) and undefined (abstract) methods, and can hold state (fields).
// Interfaces are 100% abstract (by default) and only define method signatures — they cannot hold state (except constants).
// Use an abstract class for shared code + structure, and an interface when you just want to enforce behavior.