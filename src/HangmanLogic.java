import java.io.File;
import java.util.Scanner;

public class HangmanLogic {
    private Player player;
    private Scanner reader;
    private Word word;
    private DataManager dataManager;


    public HangmanLogic() {
        this.player = new Player(0, 10);
        this.reader = new Scanner(System.in);
        this.word = new Word();
        this.dataManager = new DataManager();
    }

    public void getNameFromUser() {
        System.out.print("Please, provide your name: ");
        String playerName = reader.nextLine();
        player.setName(playerName);
    }

    public void showHangman() {
        DrawHangman draw = new DrawHangman();
        draw.drawHangman(player.getGuessLives());
    }

    public String getUserInput() {
        return reader.nextLine();
    }

    public String chosenCapital() {
        return word.getRandomCapital().toUpperCase();
    }

    public void setPlayerLives(int lives) {
        player.setGuessLives(lives);
    }

    public long startGameTime() {
        return System.currentTimeMillis();
    }

    public long endGameTime() {
        return System.currentTimeMillis();
    }

    public int playerLives() {
        return player.getGuessLives();
    }

    public void displaySecrectWordInDemo(String[] args) {
        if (args.length > 0 && args[0].equals("-demo")){
            System.out.println("Secret word: " + word.toString());
        }
    }

    public void displayPlayerInformation() {
        System.out.println("Lives: " + player.getGuessLives());
        System.out.println("Tries: " + player.getGuessTries());
        System.out.println("User fault letters/words: " + word.getUserFaultLetters());
        System.out.println(word.hiddenWord(chosenCapital()));
    }

    public boolean checkIfThisIsACorrectWord() {
        return chosenCapital().equals(word.secretWord);
    }

    public void getHint() {
        if (player.getGuessLives() <= 1) {
            System.out.println("HINT: The capital of: " + word.getRandomCountry());
        }
    }

    public boolean checkUserWord(String userGuess) {
        return  userGuess.length() > 1 && userGuess.toUpperCase().equals(chosenCapital());
    }

    public void decreaseStatsByIncorrectWord(String userGuess) {
        player.decreaseLives(2);
        word.addUserFailure(userGuess);
        player.increaseTries();
    }

    public void handleUserInputLetter(String userGuess) {
        userGuess = userGuess.toUpperCase();
        if (chosenCapital().contains(userGuess)) {
            player.increaseTries();
        } else {
            player.increaseTries();
            if (!word.getUserFaultLetters().contains(userGuess)){
                player.decreaseLives(1);
            }
        }
        word.correctWrongLetter(chosenCapital(), userGuess);
    }


    public void playerWonTheGame(long totalTime) {
        System.out.printf("%s you guessed after %s tries. It took you %d seconds.\n\n"
                ,player.getName(), player.getGuessTries(), totalTime);
        dataManager.fileHandler(new File("HighScore.txt"),
                player.playerHighScore("" + totalTime, chosenCapital()));
        HighScore score = new HighScore();
        score.displayHighScore();
    }

    public boolean playerLoseTheGame() {
        return player.getGuessLives() <= 0;
    }

    public boolean playAgain(String userGuess) {
        if (userGuess.equals("y")) {
            player.setGuessLives(10);
            player.setGuessTries(0);
            word.setUserFaultLetters("");
            return false;
        }
        return true;
    }











}
