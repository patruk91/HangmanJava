import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Highscore {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();

        System.out.println(dataManager.readFile(new File("highscore.txt")));
        ArrayList<String> totalHighscore = new ArrayList<>();
        totalHighscore = dataManager.readFile(new File("highscore.txt"));

        ArrayList<String> results = new ArrayList<>();
























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
        System.out.println(Arrays.toString(columnsWidth));


        //dynamic printing
        String format ="";

        for (int x:columnsWidth)
            format += "%-" + (x + 3) + "s ";

        format += "%n";

        for (String line : totalHighscore) {
            String[] record = line.split(";");

                System.out.printf(format, record);
            }

    }
}


