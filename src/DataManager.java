import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataManager {


    public ArrayList<String> readFile(File fileObject) {

        Scanner reader;
        ArrayList<String> dataList = new ArrayList<>();

        try {
            reader = new Scanner(fileObject);
        } catch (FileNotFoundException error) {
            System.out.println("We couldn't read the file. Error: " + error.getMessage());
//            error.printStackTrace();
            // or throw exception??????????
            return dataList;
        }

        while (reader.hasNextLine()) {
            String dataFile = reader.nextLine();
            dataList.add(dataFile);
        }
        reader.close();
        return dataList;
    }

    public ArrayList<Country> getCountriesAndCapitals() {
        DataManager dataManager = new DataManager();
        File fileName = new File("countries_and_capitals.txt");
        ArrayList<String> record = dataManager.readFile(fileName);
        ArrayList<Country> dataList = new ArrayList<>();

        for (int i=0; i < record.size(); i++) {
            String[] countryAndCapital = record.get(i).split(" \\| ");
            dataList.add(new Country(countryAndCapital));

        }
        return dataList;
    }

    public FileWriter fileHandler(File fileObject, String text) {
        FileWriter writer=null;

        try {
            writer = new FileWriter(fileObject, true);
            writer.write(text);
            writer.close();
        } catch (Exception error) {
            System.out.println("We couldn't append to the file. Error: " + error.getMessage());
        }
        return writer;
    }

}
