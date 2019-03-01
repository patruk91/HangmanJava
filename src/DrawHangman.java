import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;


public class DrawHangman {

    public DrawHangman() {
    }

    public void drawHangman(int lives) {
        DataManager dataManager = new DataManager();
        File fileName = new File("draw_hangman.txt");
        ArrayList<String> record = dataManager.readFile(fileName);
        
        HashMap<Integer, Integer> drawOfHangman = getLivesLineNumberMap();
        int sizeOfHangmanASCII = 10;
        for (int i=0; i < sizeOfHangmanASCII; i++) {
                int line = drawOfHangman.get(lives);
                System.out.println(record.get(i + line));
        }
    }

    private HashMap<Integer, Integer> getLivesLineNumberMap() {
        int lineNumber = 0;

        HashMap<Integer, Integer> drawOfHangman = new HashMap<>();
        for (int userLives=10; userLives >= 0; userLives--) {
            if (lineNumber % 2 == 0) {
                drawOfHangman.put(userLives, lineNumber);
            } else {
                drawOfHangman.put(userLives, lineNumber - 5);
            }
            lineNumber += 5;
        }
        return drawOfHangman;
    }

}





