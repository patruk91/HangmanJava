import java.util.ArrayList;
import java.util.Random;

public class Word {
    private DataManager dataManager = new DataManager();
    private ArrayList<Country> dataCountryCapital = dataManager.getCountriesAndCapitals();
    private int randomNumber = new Random().nextInt(dataCountryCapital.size());

    private String userGuessedLetters;
    private String userFaultLetters;


    public Word() {
        this.userGuessedLetters = "";
        this.userFaultLetters = "";
    }

    public String getRandomCountry() {
        return dataCountryCapital.get(randomNumber).getCountry();
    }

    public String getRandomCapital() {
        return dataCountryCapital.get(randomNumber).getCapital();
    }

    public String toString() {
        return dataCountryCapital.get(randomNumber).toString();
    }

    public void correctWrongLetter(String capital, String guessLetter) {
        if (capital.contains(guessLetter) || userGuessedLetters.contains(guessLetter)) {
            userGuessedLetters += guessLetter;
        } else {
//            number of faults++
            userFaultLetters += guessLetter;
        }
    }

    public String hiddenWord(String capital) {
        String secretWord = "";

        for (int i=0; i < capital.length(); i++) {
            String guessLetter = Character.toString(capital.charAt(i));

            if (userGuessedLetters.contains(guessLetter)) {
                secretWord += guessLetter;
            } else if (Character.toString(capital.charAt(i)).equals(" ")) {
                secretWord += "    ";
            } else {
                secretWord += " _ ";
            }
        }
        return secretWord;
    }

    public String toString1() {
        return "Word{" +
                "userGuessedLetters='" + userGuessedLetters + '\'' +
                ", userFaultLetters='" + userFaultLetters + '\'' +
                '}';
    }
}
