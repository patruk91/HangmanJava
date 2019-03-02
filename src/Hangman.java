public class Hangman {
    public static void main(String[] args) {
        HangmanLogic hangmanLogic = new HangmanLogic();

        clearScreen();
        hangmanLogic.getNameFromUser();

        boolean gameWon = false;
        String userInput = "y";
        while (userInput.equals("y")){
            long startTime = hangmanLogic.startGameTime();


            while (hangmanLogic.playerLives() > 0 && !gameWon) {
                clearScreen();
                hangmanLogic.showHangman();
                hangmanLogic.displaySecrectWordInDemo(args);
                hangmanLogic.displayPlayerInformation();

                if (hangmanLogic.checkIfThisIsACorrectWord()) {
                    gameWon = true;

                } else {
                    hangmanLogic.getHint();
                    System.out.print("Please, give me a word or letter: ");
                    String userGuess = hangmanLogic.getUserInput();

                    if (hangmanLogic.checkUserWord(userGuess)) {
                            gameWon = true;
                    } else if (userGuess.length() > 1) {

                        hangmanLogic.decreaseStatsByIncorrectWord(userGuess);
                    } else {
                        hangmanLogic.handleUserInputLetter(userGuess);
                    }
                }
            }

            if (gameWon) {
                clearScreen();
                long totalTime = (hangmanLogic.endGameTime() - startTime) / 1000;
                hangmanLogic.playerWonTheGame(totalTime);

            } else if (hangmanLogic.playerLoseTheGame()) {
                clearScreen();
                System.out.println("YOU LOSE!");
                hangmanLogic.showHangman();
            }
            System.out.print("Do you want to continue?: ");
            userInput = hangmanLogic.getUserInput();
            gameWon = hangmanLogic.playAgain(userInput);
            hangmanLogic = new HangmanLogic();
        }
    }


    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
