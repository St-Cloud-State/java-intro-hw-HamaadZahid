import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MyMain {

    public static void main(String[] args) {
        PersonList persons = new PersonList(); // Create an instance of PersonList

        try {
            Scanner input = new Scanner(new File("persons.txt"));
            persons.store(input);  // Store data in the PersonList
            persons.display(System.out); // Display all persons

            // Example find operation
            String searchId = "102";
            int index = persons.find(searchId);
            if (index != -1) {
                System.out.println("Person with ID " + searchId + " found at index: " + index);
            } else {
                System.out.println("Person with ID " + searchId + " not found.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}
