public class Score {
    private String name;
    private String date;
    private String time;
    private String tries;
    private String town;

    public Score(String[] score) {
        this.name = score[0];
        this.date = score[1];
        this.time = score[2];
        this.tries = score[3];
        this.town = score[4];

    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getTries() {
        return Integer.parseInt(tries);
    }

    public String getTown() {
        return town;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s",name,date,time,tries,town);
    }
}




