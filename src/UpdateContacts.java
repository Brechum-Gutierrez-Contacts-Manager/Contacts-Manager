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

        Contact c1 = new Contact("Eva", "Brechum", "123456569");
        String c1String = c1.toString();
//        System.out.println(c1String);
        Contact c2 = new Contact("Aida", "Gutierrez", "5555555555");
        String c2String = c2.toString();
        Contact c3 = new Contact("Celine", "Diaon", "3333333333");
        String c3String = c3.toString();
        Contact c4 = new Contact("Carlos", "Santana", "4444444444");
        String c4String = c4.toString();
try{
if(Files.notExists(dataDirectory)){
    Files.createDirectory(dataDirectory);
}
    if(!Files.exists(dataFile)) {
         Files.createFile(dataFile);
    }

    if(Files.exists(dataFile)) {
        Files.write(dataFile, Arrays.asList(c1String, c2String, c3String, c4String));
//        Files.write(dataFile, Arrays.asList("Hades", "Deimos", "Apollo"), StandardOpenOption.APPEND);
    }
    }
    catch  (IOException e) {
    e.printStackTrace();
}
    }
}
