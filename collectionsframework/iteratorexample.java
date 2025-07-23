package collectionsframework;

import java.util.*;


public class iteratorexample {
    public static void main(String[] args) {
        listIteratorExample();
        setIteratorExample();
        mapIteratorExample();
    }

    static void listIteratorExample() {
        System.out.println("=== List Iterator Example ===");
        List<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange"));
        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            String fruit = it.next();
            System.out.println(fruit);
            if (fruit.equals("Banana")) {
                it.remove(); 
            }
        }
        System.out.println("After removal: " + list);
        System.out.println();
    }

    static void setIteratorExample() {
        System.out.println("=== Set Iterator Example ===");
        Set<Integer> set = new HashSet<>(Arrays.asList(10, 20, 30));
        Iterator<Integer> it = set.iterator();

        while (it.hasNext()) {
            Integer num = it.next();
            System.out.println(num);
            if (num == 20) {
                it.remove();
            }
        }
        System.out.println("After removal: " + set);
        System.out.println();
    }

    static void mapIteratorExample() {
        System.out.println("=== Map Iterator Example ===");
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Iterate over keys
        Iterator<String> keyIterator = map.keySet().iterator();
        System.out.println("Keys:");
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            System.out.println(key);
            if (key.equals("B")) {
                keyIterator.remove();  
            }
        }

        System.out.println("Map after removal: " + map);
        System.out.println();

        // Iterate over entries
        Iterator<Map.Entry<String, Integer>> entryIterator = map.entrySet().iterator();
        System.out.println("Entries:");
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
        System.out.println();
    }
}