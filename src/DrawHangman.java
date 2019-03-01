import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DrawHangman {
    DataManager dataManager = new DataManager();
    File fileName = new File("draw_hangman.txt");
    ArrayList<String> record = dataManager.readFile(fileName);

    public DrawHangman() {
    }


    public void draw(int lives) {
        int value = record.size();

        for (int i=0; i < value; i++) {
            if (lives >= 8) {
                value = 10;
                System.out.println(record.get(i));
            } else if (lives >= 6) {
                value = 10;
                System.out.println(record.get(i + 10));
            } else if (lives >= 4) {
                value = 10;
                System.out.println(record.get(i + 20));
            }else if (lives >= 2) {
                value = 10;
                System.out.println(record.get(i + 30));
            } else if (lives > 0){
                value = 10;
                System.out.println(record.get(i + 40));
            } else if (lives <= 0) {
                value = 10;
                System.out.println(record.get(i + 50));
            }
        }
    }

}





