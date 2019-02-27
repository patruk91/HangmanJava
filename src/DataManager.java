import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DataManager {


    private ArrayList<Country> readFile(File fileObject)  {
        Scanner reader;
        ArrayList<Country> dataList = new ArrayList<>();

        try {
            reader = new Scanner(fileObject);
        } catch (Exception error) {
            System.out.println("We couldn't read the file. Error: " + error.getMessage());
            return dataList;
        }

        while (reader.hasNextLine()) {
            String[] countryAndCapital = reader.nextLine().split("\\|");
            System.out.println(Arrays.toString(countryAndCapital));
            dataList.add(new Country(countryAndCapital));
//            System.out.println(dataList);
        }
        reader.close();
        return dataList;
    }

    public static void main(String[] args) {
        File fileName = new File("countries_and_capitals.txt");

        DataManager dataManager = new DataManager();


        System.out.println(dataManager.readFile(fileName));

    }

}
