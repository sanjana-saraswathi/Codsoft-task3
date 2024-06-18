import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 6;

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int rounds = 0;

        while (true) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean won = false;

            System.out.println("Welcome to the number guessing game!");
            System.out.println("I'm thinking of a number between 1 and 100.");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                if (scanner.hasNextInt()) {
                    int guess = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    attempts++;
                    if (guess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else if (guess > numberToGuess) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Congratulations! You won in " + attempts + " attempts.");
                        won = true;
                        break;
                    }
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.nextLine(); // Consume invalid input
                }
            }

            if (!won) {
                System.out.println("Sorry, you didn't guess the number. It was " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();

            if (response.equalsIgnoreCase("no")) {
                break;
            }

            rounds++;
            if (won) {
                score++;
            }
        }

        System.out.println("You played " + rounds + " rounds and won " + score + " times.");
    }
}
