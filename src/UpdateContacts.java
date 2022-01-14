import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class UpdateContacts {
    public static void main(String[] args) {


        String directory = "data";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        Contact contact = new Contact("Eva", "Brechum", "123456569");
        String contactString = contact.toString();
        System.out.println(contactString);
//
//try{
//if(Files.notExists(dataDirectory)){
//    Files.createDirectory(dataDirectory);
//}
//    if(!Files.exists(dataFile)) {
//         Files.createFile(dataFile);
//    }
//    if(Files.exists(dataFile)) {
//        Files.write(dataFile, Arrays.asList("Zeus", "Hercules", "Aphrodite", "Poseidon", "Hephaestus", "Athena"));
//        Files.write(dataFile, Arrays.asList("Hades", "Deimos", "Apollo"), StandardOpenOption.APPEND);
//    }
//    }
//    catch  (IOException e) {
//    e.printStackTrace();
//}
    }
}
