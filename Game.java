import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        NumberGuessingGame guessingGame = new NumberGuessingGame();
        guessingGame.play();
    }
}

class NumberGuessingGame {
    private int numberToGuess;
    private int attempts;
    private Scanner scanner;

    public NumberGuessingGame() {
        this.numberToGuess = new Random().nextInt(100) + 1;
        this.attempts = 0;
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("Welcome to the Number Guessing Game");
        
        int userGuess;
        do {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Higher. Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Lower. Try again.");
            } else {
                System.out.println("You guessed the number in " + attempts + " attempts.");
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
