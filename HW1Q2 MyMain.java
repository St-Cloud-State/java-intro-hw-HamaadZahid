import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class MyMain {

    public static void store(Scanner input, LinkedList<Person> list) {
        while (input.hasNextLine()) {
            String[] data = input.nextLine().split(",");
            if (data.length == 3) {
                list.add(new Person(data[0].trim(), data[1].trim(), data[2].trim()));
            }
        }
    }

    public static void display(PrintStream output, LinkedList<Person> list) {
        for (Person p : list) {
            output.println(p);
        }
    }

    public static int find(String sid, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedList<Person> list = new LinkedList<>();
        try {
            Scanner input = new Scanner(new File("persons.txt"));
            store(input, list);
            display(System.out, list);

            // Example find operation
            String searchId = "102";
            int index = find(searchId, list);
            System.out.println("Index of person with ID " + searchId + ": " + index);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
} 
