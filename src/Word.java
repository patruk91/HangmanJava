import java.util.ArrayList;
import java.util.Random;

public class Word {
    private DataManager dataManager = new DataManager();
    private ArrayList<Country> dataCountryCapital = dataManager.getCountriesAndCapitals();
    private int randomNumber = new Random().nextInt(dataCountryCapital.size());

    public String getRandomCountry() {
        return dataCountryCapital.get(randomNumber).getCountry();
    }

    public String getRandomCapital() {
        return dataCountryCapital.get(randomNumber).getCapital();
    }

    public String toString() {
        return dataCountryCapital.get(randomNumber).toString();
    }
}
