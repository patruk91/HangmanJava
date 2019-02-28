import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Please, provide your name: ");
        String playerName = reader.nextLine();

        int GUESS_LIVES = 10;
        Player player = new Player(playerName, 0, GUESS_LIVES);

        Word word = new Word();
        System.out.println(word.toString());
        String chosenCapital = word.getRandomCapital();

        String userInput = "y";
        while (userInput.equals("y")){

            boolean gameWon = false;
            while (GUESS_LIVES > 0 && !gameWon) {
                System.out.print("Please, give me a word or letter: ");
                String userGuess = reader.nextLine();
                word.correctWrongLetter(chosenCapital, userGuess);
                System.out.println(word.hiddenWord(chosenCapital));
                System.out.println(word.toString1());



            }





            userInput = reader.nextLine();
        }
    }
}
