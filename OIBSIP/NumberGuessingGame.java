import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    static int score = 0;

    public static void playGame() {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int numberToGuess = random.nextInt(100) + 1;
        int maxAttempts = 7;
        boolean hasWon = false;

        System.out.println("====================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("====================================");
        System.out.println("Guess the number between 1 and 100");
        System.out.println("You have " + maxAttempts + " attempts.");

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {

            System.out.print("\nAttempt " + attempt + ": Enter your guess: ");
            int userGuess = sc.nextInt();

            if (userGuess == numberToGuess) {
                System.out.println("Congratulations! You guessed the correct number.");
                score = score + (maxAttempts - attempt + 1) * 10;
                hasWon = true;
                break;
            }
            else if (userGuess < numberToGuess) {
                System.out.println("Too Low! Try a bigger number.");
            }
            else {
                System.out.println("Too High! Try a smaller number.");
            }
        }

        if (!hasWon) {
            System.out.println("\nGame Over!");
            System.out.println("The correct number was: " + numberToGuess);
        }

        System.out.println("Your Score: " + score);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            playGame();

            System.out.print("\nDo you want to play again? (Y/N): ");
            choice = sc.next().charAt(0);

        } while (choice == 'Y' || choice == 'y');

        System.out.println("\nThank you for playing!");
    }
}