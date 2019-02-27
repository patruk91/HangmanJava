import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DataManager {


    private void readFile(File fileObject)  {
        Scanner reader;

        try {
            reader = new Scanner(fileObject);
        } catch (Exception error) {
            System.out.println("We couldn't read the file. Error: " + error.getMessage());
            return;
        }

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            System.out.println(line);
        }
        reader.close();
    }
    

}
