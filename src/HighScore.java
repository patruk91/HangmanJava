import java.io.File;
import java.util.*;

public class HighScore {
    private ArrayList<String> totalHighScore;
    private ArrayList<Score> sortedHighScore;

    public HighScore() {
        DataManager dataManager = new DataManager();
        this.totalHighScore = dataManager.readFile(new File("HighScore.txt"));
        this.sortedHighScore = new ArrayList<>();
    }

    public void displayHighScore() {
        sortHighScoreByTries();
        Integer[] columnsWidth = getColumnsWidth();
        createTable(columnsWidth);

        }


    private void sortHighScoreByTries() {
        for (String userScore : totalHighScore) {
            String[] row = userScore.split(";");
            sortedHighScore.add(new Score(row));
        }
        sortedHighScore.sort(Comparator.comparing(Score::getTries));
        //https://dzone.com/articles/java-8-comparator-how-to-sort-a-list
        //https://www.callicoder.com/java-comparable-comparator/
    }

    private Integer[] getColumnsWidth() {
        Integer[] columnsWidth = {0, 0, 0, 0, 0};
        for (String userScore : this.totalHighScore) {
            String[] row = userScore.split(";");

            for (int i = 0; i < row.length; i++) {
                if (row[i].length() > columnsWidth[i]) {
                    columnsWidth[i] = row[i].length();
                }
            }
        }
        return columnsWidth;
    }

    private void createTable(Integer[] columnsWidth) {
        String format = "";
        int extraSpaces = 3;
        for (int columnWidth : columnsWidth) {
            format += "%-" + (columnWidth + extraSpaces) + "s ";
        }
        format += "%n";

        for (Score line : sortedHighScore) {
            System.out.printf(format, line.getName(),
                    line.getDate(), line.getTime(), line.getTries(), line.getTown());
        }
    }
}


