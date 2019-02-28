import java.util.Scanner;

public class Player {
    private String name;
    private int guessTries;
    private int guessLives;


    public Player(String name, int guessTries, int guessLives) {
        this.name = name;
        this.guessTries = guessTries;
        this.guessLives = guessLives;
    }

    public String askForUserName() {
        Scanner reader = new Scanner(System.in);
        System.out.print("Input your name: ");
        return reader.nextLine();
    }

    public String getName() {
        return name;
    }

    public int getGuessLives() {
        return guessLives;
    }

    public int getGuessTries() {
        return guessTries;
    }

    public int decreaseLives(int livesToDecrease) {
        return guessLives - livesToDecrease;
    }

    public int increaseTries() {
        return guessTries++;
    }

    public long startTime() {
        return System.currentTimeMillis();
    }

    public long endTime() {
        return System.currentTimeMillis();
    }
}
