package collectionsframework;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class stacksexample {
    public static void main(String[] args) {
        stackClassExample();
        arrayDequeAsStackExample();
    }

    static void stackClassExample() {
        Stack<String> stack = new Stack<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        System.out.println("Stack: " + stack);

        System.out.println("Peek: " + stack.peek());   // Look at top item
        System.out.println("Pop: " + stack.pop());     // Remove top item
        System.out.println("Stack after pop: " + stack);
    }

    static void arrayDequeAsStackExample() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("ArrayDeque as Stack: " + stack);

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack after pop: " + stack);
    }
}