import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Please, provide your name: ");
        String playerName = reader.nextLine();

        Player player = new Player(playerName, 0, 10);

        String userInput = "y";
        while (userInput.equals("y")){
            Word word = new Word();
            String chosenCapital = word.getRandomCapital();
            player.setGuessLives(10);
            System.out.println(word.toString());
            long startTime = player.startTime();

            boolean gameWon = false;
            while (player.getGuessLives() > 0 && !gameWon) {
                System.out.println("\nLives: " + player.getGuessLives());
                System.out.println("Tries: " + player.getGuessTries());
                System.out.println("User fault letters/words: " + word.getUserFaultLetters());
//                System.out.println("User good letters/words: " + word.getUserGuessedLetters());

                System.out.println(word.hiddenWord(chosenCapital));


                if (chosenCapital.equals(word.secretWord)) {
                    gameWon = true;
                    // do winning screen
                    // show highscore
                } else {
                    System.out.print("Please, give me a word or letter: ");
                    String userGuess = reader.nextLine();
                    if (userGuess.length() > 1) {
                        if (userGuess.equals(chosenCapital)) {
                            gameWon = true;
                            // do winning screen
                            // show highscore
                        } else {

                            player.decreaseLives(2);
                            word.addUserFailure(userGuess);
                            player.increaseTries();
                        }
                    } else {
                        if (chosenCapital.contains(userGuess)) {
                            player.increaseTries();
                        } else {
                            player.increaseTries();
                            if (!word.getUserFaultLetters().contains(userGuess)){
                                player.decreaseLives(1);
                            }
                        }
                        word.correctWrongLetter(chosenCapital, userGuess);







                    }
                }

            }
            long totalTime = (player.endTime() - startTime) / 1000;
            System.out.println(totalTime);
            System.out.print("Do you want to continue?: ");
            userInput = reader.nextLine();
            player.setGuessLives(10);
            player.setGuessTries(0);
        }
    }
}
