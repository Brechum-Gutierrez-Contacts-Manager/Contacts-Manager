import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UpdateContacts {

    public static List<Contact> ContactList=  new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String directory = "data";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        //create contacts - manually
        Contact c1 = new Contact("Eva", "Brechum", "123456569");
        String c1String = c1.toString();
//        System.out.println(c1String);
        Contact c2 = new Contact("Aida", "Gutierrez", "5555555555");
        String c2String = c2.toString();
        Contact c3 = new Contact("Celine", "Dion", "3333333333");
        String c3String = c3.toString();
        Contact c4 = new Contact("Carlos", "Santana", "4444444444");
        String c4String = c4.toString();

       // add contacts to data file
        try {
            if (Files.notExists(dataDirectory)) {
                Files.createDirectory(dataDirectory);
            }
            if (!Files.exists(dataFile)) {
                Files.createFile(dataFile);
            }

            if (Files.exists(dataFile)) {
//                Files.write(dataFile, Arrays.asList(c1String, c2String, c3String, c4String));



            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // loop to run the menu
        while (true) {
                    int userChoice = UpdateContacts.mainMenu();
                    if (userChoice == 1)
                        UpdateContacts.printContactList();
                    else if (userChoice == 2)
                        UpdateContacts.addContacts();
                    else if (userChoice == 3)
                        UpdateContacts.searchContacts();
                    else if (userChoice == 4) {
                        UpdateContacts.deleteContacts();
                    } else if (userChoice == 5) {
                        UpdateContacts.exit();
                    } else
                        System.out.println("Invalid input.");
                }

    }

//
    //print contacts - 1
    public static void printContactList() {
   List<String> ContactList = null;
        Path ContactsPath = Paths.get("data", "contacts.txt");
        try {
           ContactList = Files.readAllLines(ContactsPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("  Name   | Phone Number");
        System.out.println("-----------------------");
        for (int i = 0; i < ContactList.size(); i += 1) {
            System.out.println(ContactList.get(i));
        }
    }
 // add contacts - 2
    public static void addContacts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("2. Add a New Contact.");
        System.out.println("First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        try {
            Files.write(Paths.get("data", "contacts.txt"), Arrays.asList(firstName + " " + lastName + " | " +phoneNumber) , StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ContactList.add(new Contact(firstName, lastName , phoneNumber));
    }

    // search contact -3

    public static void searchContacts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search for a Contact.");
        System.out.println("Name or Number : ");
        String searchedContact = scanner.nextLine();
        Path ContactsPath = Paths.get("data", "contacts.txt");
        List<String> ContactList;
        try {
            // Reading Files
            // Create a List of strings that represents the file data.

            ContactList = Files.readAllLines(ContactsPath);
            for (String contact : ContactList) {
                if (contact.toLowerCase().contains(searchedContact))
                    System.out.println(contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// Deleting existing Contact -4
        public static void deleteContacts(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("4. Delete a Contact.");
            System.out.println(" Enter Name or Number : ");
            String deleteContacts = scanner.nextLine();
            Path ContactsPath = Paths.get("data", "contacts.txt");
            List<String>ContactList;
            try {
                ContactList= Files.readAllLines(ContactsPath);
                List<String> newList = new ArrayList<>();
                for (String contact : ContactList) {
                    if (contact.toLowerCase().contains(deleteContacts)) {
                        continue; // skips over the user input
                    }
                    newList.add(contact); // adds remaining items
                }
                for (String name : newList) {
                    System.out.println(name);
                }
                Files.write(Paths.get("data", "contacts.txt"), newList);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Exit the menu
        public static void exit() {
            System.out.println("Goodbye");
            System.exit(0);
        }

        // NOTE !!! We need to create  a new class with a main menu to call this method...
    // we probably need to separate actions with methods, like search, delete,add, etc... REFACTOR ABOVE CODE
    //  and create new methods.


    // ask for user input
    public static int mainMenu() {

        System.out.println("\nWhat would you like to do?");
        System.out.println("  1. View contacts");
        System.out.println("  2. Add a new contact");
        System.out.println("  3. Search a contact by name and/or phone number.");
        System.out.println("  4. Delete an existing contact.");
        System.out.println("  5. Exit");
        System.out.print("\nEnter an option (1, 2, 3, 4 or 5): ");

        Scanner myScanner = new Scanner(System.in);
        int userChoice = myScanner.nextInt();
        System.out.println("-----------------------------");
        return userChoice;
    }

}
