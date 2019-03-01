import java.lang.reflect.Array;
import java.util.Arrays;

public class Score {
    private String name;
    private String date;
    private String time;
    private String tries;
    private String town;
    private String[] score;

    public Score(String[] score) {
        this.name = score[0];
        this.date = score[1];
        this.time = score[2];
        this.tries = score[3];
        this.town = score[4];
        this.score = score;

    }

    public int getTries() {
        return Integer.parseInt(tries);
    }

    public String getTime() {
        return time;
    }

    public String getTown() {
        return town;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s",name,date,time,tries,town);
    }

    public String toName() {
        return name;
    }

    public String toDate() {
        return date;
    }

    public String toTime() {
        return time;
    }

    public String toTries() {
        return tries;
    }

    public String toTown() {
        return town;
    }

}




