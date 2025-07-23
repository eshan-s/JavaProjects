package collectionsframework;

import java.util.*;

public class listexample {
    public static void main(String[] args) {
        listInterfaceExample();
        abstractListExample();
        abstractSequentialListExample();
        arrayListExample();
        vectorExample();
        stackExample();
        linkedListExample();
    }

    static void listInterfaceExample() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        System.out.println("List Interface: " + fruits);
    }

    static void abstractListExample() {
        MyList<String> myList = new MyList<>();
        myList.add("Eshan");
        myList.add("Alex");
        System.out.println("AbstractList subclass: " + myList);
    }

    static void abstractSequentialListExample() {
        MySequentialList<String> mySeqList = new MySequentialList<>();
        mySeqList.add("Java");
        mySeqList.add("Python");
        for(String lang : mySeqList) {
            System.out.println("AbstractSequentialList subclass: " + lang);
        }
    }

    static void arrayListExample() {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        System.out.println("ArrayList: " + colors);
    }

    static void vectorExample() {
        Vector<Integer> numbers = new Vector<>();
        numbers.add(1);
        numbers.add(2);
        System.out.println("Vector: " + numbers);
    }

    static void stackExample() {
        Stack<String> stack = new Stack<>();
        stack.push("First");
        stack.push("Second");
        System.out.println("Stack: " + stack);
        System.out.println("Popped: " + stack.pop());
    }

    static void linkedListExample() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Monday");
        list.add("Tuesday");
        System.out.println("LinkedList: " + list);
    }
}

// Abstract Class Examples

class MyList<E> extends AbstractList<E> {
    private ArrayList<E> internalList = new ArrayList<>();

    @Override
    public E get(int index) { return internalList.get(index); }

    @Override
    public int size() { return internalList.size(); }

    @Override
    public boolean add(E e) { return internalList.add(e); }
}

class MySequentialList<E> extends AbstractSequentialList<E> {
    private LinkedList<E> internalList = new LinkedList<>();

    @Override
    public java.util.ListIterator<E> listIterator(int index) {
        return internalList.listIterator(index);
    }

    @Override
    public int size() { return internalList.size(); }

    @Override
    public void add(int index, E element) { internalList.add(index, element); }
}