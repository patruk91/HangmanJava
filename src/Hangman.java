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

            boolean gameWon = false;
            while (player.getGuessLives() > 0 && !gameWon) {
                System.out.println("\nLives: " + player.getGuessLives());
                System.out.println("Tries: " + player.getGuessTries());
                System.out.println("User fault letters/words: " + word.getUserFaultLetters());
                System.out.println("User good letters/words: " + word.getUserGuessedLetters());

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
                        }
                    } else {
                        word.correctWrongLetter(chosenCapital, userGuess);
                        if (chosenCapital.contains(userGuess)) {
                        } else {
                            player.decreaseLives(1);
                        }
                    }
                }

            }



            System.out.print("Do you want to continue?: ");
            userInput = reader.nextLine();
        }
    }
}
