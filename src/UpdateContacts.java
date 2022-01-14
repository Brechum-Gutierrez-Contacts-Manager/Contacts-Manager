import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UpdateContacts {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String directory = "data";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        Contact c1 = new Contact("Eva", "Brechum", "123456569");
        String c1String = c1.toString();
//        System.out.println(c1String);
        Contact c2 = new Contact("Aida", "Gutierrez", "5555555555");
        String c2String = c2.toString();
        Contact c3 = new Contact("Celine", "Diaon", "3333333333");
        String c3String = c3.toString();
        Contact c4 = new Contact("Carlos", "Santana", "4444444444");
        String c4String = c4.toString();
        try {
            if (Files.notExists(dataDirectory)) {
                Files.createDirectory(dataDirectory);
            }
            if (!Files.exists(dataFile)) {
                Files.createFile(dataFile);
            }

            if (Files.exists(dataFile)) {
                Files.write(dataFile, Arrays.asList(c1String, c2String, c3String, c4String));
//        Files.write(dataFile, Arrays.asList("Hades", "Deimos", "Apollo"), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // Reading Files
            // Create a List of strings that represents the file data.

            List<String> contacts = Files.readAllLines(dataFile);
            for (String contact : contacts) {
                System.out.println(contacts);
            }
            System.out.println("  Name   | Phone Number\n      |           |");
            System.out.println("-----------------------");
            System.out.println(contacts);
//public static addContact() {Scanner myScanner = new Scanner(System.in);
//            System.out.println(" 1. Add a New Person ");
//            System.out.print("  First Name: ");
//            String firstName = myScanner.nextLine();
//            System.out.print("  Last Name : ");
//            String lastName = myScanner.nextLine();
//            System.out.print("  Phone Number : ");
//            String phoneNumber = myScanner.nextLine();
        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }
}
