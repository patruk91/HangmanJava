import java.io.File;
import java.lang.reflect.Array;
import java.util.*;

public class Highscore {
    public Highscore() {
    }



    public void showHighscore() {
        DataManager dataManager = new DataManager();

//        System.out.println(dataManager.readFile(new File("highscore.txt")));
        ArrayList<String> totalHighscore;
        totalHighscore = dataManager.readFile(new File("highscore.txt"));
        ArrayList<Score> sortedhighscore = new ArrayList<>();


        for (String line : totalHighscore) {
            String[] record = line.split(";");
            sortedhighscore.add(new Score(record));
        }

        sortedhighscore.sort(Comparator.comparing(Score::getTries));

        // width colums
        Integer[] columnsWidth = {0, 0, 0, 0, 0};
        for (String line : totalHighscore) {
            String[] record = line.split(";");

            for (int i = 0; i < record.length; i++) {
                if (record[i].length() > columnsWidth[i]) {
                    columnsWidth[i] = record[i].length();
                }
            }

        }

        String format ="";
        for (int x:columnsWidth)
            format += "%-" + (x + 3) + "s ";
        format += "%n";

        for (Score line : sortedhighscore) {
            System.out.printf(format, line.toName(),
                    line.toDate(), line.toTime(), line.getTries(), line.toTown());
        }
    }
}


