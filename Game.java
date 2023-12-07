import java.util.Random;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Game {
    private static final Logger LOGGER = Logger.getLogger(Game.class.getName());

    public static void main(String[] args) {
        NumberGuessingGame guessingGame = new NumberGuessingGame();
        guessingGame.play();
    }
}

class NumberGuessingGame {
    private static final Logger LOGGER = Logger.getLogger(NumberGuessingGame.class.getName());

    private int numberToGuess;
    private int attempts;
    private Scanner scanner;

    public NumberGuessingGame() {
        this.numberToGuess = new Random().nextInt(100) + 1;
        this.attempts = 0;
        this.scanner = new Scanner(System.in);

        // Configure logging
        try {
            FileHandler fileHandler = new FileHandler("game_log.txt");
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.INFO);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error configuring logging", e);
        }

        LOGGER.info("Number to guess: " + numberToGuess);
    }

    public void play() {
        LOGGER.info("Welcome to the Number Guessing Game");

        int userGuess;
        do {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < numberToGuess) {
                LOGGER.info("Higher. Try again.");
            } else if (userGuess > numberToGuess) {
                LOGGER.info("Lower. Try again.");
            } else {
                LOGGER.info("You guessed the number in " + attempts + " attempts.");
            }
        } while (userGuess != numberToGuess);

        scanner.close();
    }

    public int getNumberToGuess() {
        return numberToGuess;
    }

    public int getAttempts() {
        return attempts;
    }
}
