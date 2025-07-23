package collectionsframework;

import java.util.*;


public class setexample {
    public static void main(String[] args) {
        setInterfaceExample();
        abstractSetExample();
        hashSetExample();
        linkedHashSetExample();
    }

    static void setInterfaceExample() {
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); // duplicate is not added
        System.out.println("Set Interface (HashSet): " + set);
    }

    static void abstractSetExample() {
        MySimpleSet<String> mySet = new MySimpleSet<>();
        mySet.add("One");
        mySet.add("Two");
        mySet.add("Two"); // duplicate
        System.out.println("AbstractSet subclass: " + mySet);
    }

    static void hashSetExample() {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(10); // duplicate
        System.out.println("HashSet: " + hashSet);
    }

    static void linkedHashSetExample() {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("First");
        linkedHashSet.add("Second");
        linkedHashSet.add("First"); // duplicate
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);
    }
}

// Simple AbstractSet subclass
class MySimpleSet<E> extends AbstractSet<E> {
    private HashSet<E> internalSet = new HashSet<>();

    @Override
    public Iterator<E> iterator() {
        return internalSet.iterator();
    }

    @Override
    public int size() {
        return internalSet.size();
    }

    @Override
    public boolean add(E e) {
        return internalSet.add(e);
    }
}