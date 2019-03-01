import java.io.File;
import java.lang.reflect.Array;
import java.util.*;

public class Highscore {


    public static void main(String[] args) {
        DataManager dataManager = new DataManager();

//        System.out.println(dataManager.readFile(new File("highscore.txt")));
        ArrayList<String> totalHighscore;
        totalHighscore = dataManager.readFile(new File("highscore.txt"));
        ArrayList<Score> sortedhighscore = new ArrayList<>();


        for (String line : totalHighscore) {
            String[] record = line.split(";");
            sortedhighscore.add(new Score(record));
        }

//        System.out.println(sortedhighscore.get(0).getTries());
//        System.out.println(Arrays.asList(sortedhighscore.toArray()));
//        sortedhighscore.sort(Comparator.comparing(Score::getTries));
//        System.out.println(sortedhighscore);
//
//        System.out.println();
//
//        for (Score item : sortedhighscore) {
//            System.out.println(item.toString());
//        }

        System.out.println(sortedhighscore.toString());


        System.out.println("\n\n\n");
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


