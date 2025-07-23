package encapsulation;

public class encapsulationdemo {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Eshan");
        p.setAge(22);
        
        System.out.println(p.getName() + " is " + p.getAge() + " years old.");
        
        p.setAge(-5);  // Should be ignored
        System.out.println("After invalid age set attempt: " + p.getAge());
    }
}

class Person {
    private String name;  
    private int age;

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age with validation (encapsulation logic)
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age. Age must be non-negative.");
        }
    }
}

