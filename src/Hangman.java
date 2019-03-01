import java.io.File;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        DataManager dataManager = new DataManager();

        System.out.print("Please, provide your name: ");
        String playerName = reader.nextLine();

        Player player = new Player(playerName, 0, 10);
        DrawHangman draw = new DrawHangman();

        String userInput = "y";
        while (userInput.equals("y")){
            Word word = new Word();
            String chosenCapital = word.getRandomCapital().toUpperCase();
            player.setGuessLives(10);
            long startTime = player.startTime();

            boolean gameWon = false;
            while (player.getGuessLives() > 0 && !gameWon) {
                clearScreen();
                draw.drawHangman(player.getGuessLives());
                if (args.length > 0 && args[0].equals("-demo")){
                    System.out.println("Secret word: " + word.toString());
                }
                System.out.println("Lives: " + player.getGuessLives());
                System.out.println("Tries: " + player.getGuessTries());
                System.out.println("User fault letters/words: " + word.getUserFaultLetters());

                System.out.println(word.hiddenWord(chosenCapital));


                if (chosenCapital.equals(word.secretWord)) {
                    gameWon = true;

                } else {
                    if (player.getGuessLives() <= 1) {
                        System.out.println("HINT: The capital of: " + word.getRandomCountry());
                    }
                    System.out.print("Please, give me a word or letter: ");
                    String userGuess = reader.nextLine().toUpperCase();
                    if (userGuess.length() > 1) {
                        if (userGuess.equals(chosenCapital)) {
                            gameWon = true;

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
            if (gameWon) {
                clearScreen();
                System.out.printf("%s you guessed after %s tries. It took you %d seconds.\n\n"
                        ,playerName, player.getGuessTries(), totalTime);
                dataManager.fileHandler(new File("HighScore.txt"),
                        player.playerHighScore("" + totalTime, chosenCapital));
                HighScore score = new HighScore();
                score.displayHighScore();
            } else if (player.getGuessLives() <= 0) {
                draw.drawHangman(player.getGuessLives());
            }
            System.out.print("Do you want to continue?: ");
            userInput = reader.nextLine();
            player.setGuessLives(10);
            player.setGuessTries(0);
        }
    }


    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
