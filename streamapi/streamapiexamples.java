package streamapi;

import java.util.*;
import java.util.stream.*;

public class streamapiexamples {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank");

        // 1. forEach(): Print all elements
        System.out.println("All names:");
        names.stream().forEach(System.out::println);

        // 2. filter(): Find names that start with 'C'
        System.out.println("\nNames that start with 'C':");
        names.stream()
             .filter(name -> name.startsWith("C"))
             .forEach(System.out::println);

        // 3. map(): Convert names to uppercase
        System.out.println("\nNames in uppercase:");
        names.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);

        // 4. sorted(): Sort names alphabetically
        System.out.println("\nSorted names:");
        names.stream()
             .sorted()
             .forEach(System.out::println);

        // 5. collect(): Collect results into a List
        List<String> shortNames = names.stream()
                                       .filter(name -> name.length() <= 4)
                                       .collect(Collectors.toList());
        System.out.println("\nShort names (<= 4 chars): " + shortNames);

        // 6. reduce(): Combine elements into a single result
        Optional<String> combined = names.stream()
                                         .reduce((a, b) -> a + ", " + b);
        combined.ifPresent(result -> System.out.println("\nCombined names: " + result));

        // 7. count(): Count number of elements
        long count = names.stream()
                          .filter(name -> name.length() > 3)
                          .count();
        System.out.println("\nNumber of names longer than 3 characters: " + count);

        // 8. anyMatch(): Check if any name starts with "A"
        boolean hasA = names.stream()
                            .anyMatch(name -> name.startsWith("A"));
        System.out.println("\nAny name starts with 'A'? " + hasA);

        // 9. distinct(): Remove duplicate entries
        List<String> namesWithDupes = Arrays.asList("Alice", "Bob", "Alice", "Eve", "Eve");
        System.out.println("\nUnique names:");
        namesWithDupes.stream()
                      .distinct()
                      .forEach(System.out::println);

        // 10. limit() and skip(): Control the stream flow
        System.out.println("\nFirst 3 names:");
        names.stream().limit(3).forEach(System.out::println);

        System.out.println("\nSkipping first 3 names:");
        names.stream().skip(3).forEach(System.out::println);
    }
}