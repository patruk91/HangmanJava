import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private int guessTries;
    private int guessLives;
    private ArrayList<String> incorrectLetterOrWords = new ArrayList<>();


    public Player(String name, int guessTries, int guessLives) {
        this.name = name;
        this.guessTries = guessTries;
        this.guessLives = guessLives;
    }

    public String getName() {
        return name;
    }

    public int getGuessLives() {
        return this.guessLives;
    }

    public int getGuessTries() {
        return guessTries;
    }

    public void decreaseLives(int livesToDecrease) {
        this.guessLives -= livesToDecrease;
    }

    public void increaseTries() {
        guessTries++;
    }

    public long startTime() {
        return System.currentTimeMillis();
    }

    public long endTime() {
        return System.currentTimeMillis();
    }

    public ArrayList<String> badLettersOrWords(String letterOrWord) {
        incorrectLetterOrWords.add(letterOrWord);
        return incorrectLetterOrWords;
    }

    public void setGuessLives(int guessLives) {
        this.guessLives = guessLives;
    }

    public void setGuessTries(int guessTries) {
        this.guessTries = guessTries;
    }
}
