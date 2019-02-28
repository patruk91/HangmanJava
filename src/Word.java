import java.util.ArrayList;
import java.util.Random;

public class Word {
    private DataManager dataManager = new DataManager();
    private ArrayList<Country> dataCountryCapital = dataManager.getCountriesAndCapitals();
    private int randomNumber;

    private String userGuessedLetters;
    private String userFaultLetters;
    String secretWord;



    public Word() {
        this.userGuessedLetters = "";
        this.userFaultLetters = "";
        this.randomNumber = new Random().nextInt(dataCountryCapital.size());
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
            userFaultLetters += guessLetter + ", ";
        }
    }

    public String hiddenWord(String capital) {
        secretWord = "";

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

    public String getUserGuessedLetters() {
        return userGuessedLetters;
    }

    public String getUserFaultLetters() {
        return userFaultLetters;
    }

    public void addUserFailure(String word) {
        userFaultLetters +=  ", " + word;
    }

    public String getSecretWord() {
        return secretWord;
    }
}
