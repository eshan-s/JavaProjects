package collectionsframework;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class mapexample {
    public static void main(String[] args) {
        mapInterfaceExample();
        treeMapExample();
        abstractMapExample();
        hashMapExample();
        linkedHashMapExample();
        hashTableExample();
    }

    static void mapInterfaceExample() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Eshan", 22);
        map.put("Aman", 30);
        System.out.println("Map Interface (using HashMap): " + map);
    }

    static void treeMapExample() {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Banana", 3);
        treeMap.put("Apple", 5);
        treeMap.put("Orange", 2);
        System.out.println("TreeMap (sorted keys): " + treeMap);
    }

    static void abstractMapExample() {
        // AbstractMap is abstract; you can't instantiate it directly.
        MySimpleMap<String, String> myMap = new MySimpleMap<>();
        myMap.put("Key1", "Value1");
        myMap.put("Key2", "Value2");
        System.out.println("AbstractMap subclass: " + myMap);
    }

    static void hashMapExample() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        System.out.println("HashMap: " + hashMap);
    }

    static void linkedHashMapExample() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("first", "Eshan");
        linkedHashMap.put("second", "Aman");
        linkedHashMap.put("third", "Arjun");
        System.out.println("LinkedHashMap (insertion order): " + linkedHashMap);
    }

    static void hashTableExample() {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("A", 10);
        hashtable.put("B", 20);
        hashtable.put("C", 30);
        System.out.println("Hashtable (synchronized): " + hashtable);
    }
}

// Simple AbstractMap subclass
class MySimpleMap<K, V> extends AbstractMap<K, V> {
    private HashMap<K, V> internalMap = new HashMap<>();

    @Override
    public Set<Entry<K, V>> entrySet() {
        return internalMap.entrySet();
    }

    @Override
    public V put(K key, V value) {
        return internalMap.put(key, value);
    }
}

