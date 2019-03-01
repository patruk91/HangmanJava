import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Player {
    private String name;
    private int guessTries;
    private int guessLives;


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


    public void setGuessLives(int guessLives) {
        this.guessLives = guessLives;
    }

    public void setGuessTries(int guessTries) {
        this.guessTries = guessTries;
    }

    public String playerHighscore(String totalTime, String capital) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:MM");
        Calendar calendar = Calendar.getInstance();
        return String.format("%s;%s;%s;%s;%s\n", this.name,dateFormat.format(calendar.getTime()),
                totalTime, this.guessTries, capital);
    }
}
