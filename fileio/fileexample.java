package fileio;

import java.io.*;
import java.util.*;

public class fileexample {
    public static void main(String[] args) {
        // Create a list to store valid Person objects
        List<Person> people = new ArrayList<>();

        // Define paths to input and output files
        String inputPath = "fileio/input.dat";   // Input CSV file
        String outputPath = "fileio/output.csv"; // Output CSV file

        // Try reading the input file using BufferedReader (efficient line-by-line reading)
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String line;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                try {
                    // Try parsing the line into a Person object
                    Person person = parseLine(line);

                    // If parsing is successful, add the person to the list
                    people.add(person);
                } catch (InvalidAgeException e) {
                    // If custom exception is thrown, skip that record and print a message
                    System.out.println("Skipping record: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            // If there's an error opening or reading the file
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Try writing the valid Person objects to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            // Write each Person object to the file in CSV format
            for (Person p : people) {
                writer.write(p.toCSV());  // Write line like: 101,John Doe,25
                writer.newLine();         // Move to the next line
            }

            // Confirm to the user that records were written successfully
            System.out.println("Valid records written to: " + outputPath);
        } catch (IOException e) {
            // Handle errors during writing
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Method to parse a line from the file into a Person object
    public static Person parseLine(String line) throws InvalidAgeException {
        // Split the line by commas (CSV format)
        String[] parts = line.split(",");

        // If the line doesn't have exactly 3 parts, throw exception
        if (parts.length != 3) {
            throw new InvalidAgeException("Invalid format: " + line);
        }

        // Parse the number
        int id = Integer.parseInt(parts[0].trim());

        // Get the name 
        String name = parts[1].trim();

        // Try to parse the age
        try {
            int age = Integer.parseInt(parts[2].trim());

            // If all values are valid, return a new Person object
            return new Person(id, name, age);
        } catch (NumberFormatException e) {
            // If age is not a number, throw custom exception
            throw new InvalidAgeException("Invalid age for ID " + id + ": " + parts[2]);
        }
    }
}

// Custom exception class to represent age format issues
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message); // Call parent class (Exception) constructor with the message
    }
}

// Person class to hold individual records
class Person {
    int id;
    String name;
    int age;

    // Constructor to initialize a Person object
    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Method to return the Person's data as a CSV string
    public String toCSV() {
        return id + "," + name + "," + age;
    }
}