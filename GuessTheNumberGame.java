import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random ran = new Random();
        
        int lb= 1;
        int ub= 100;
        int Attempts = 10;
        int score = 0;

        System.out.println("Welcome to Guess the Number Game!");

        do {
            int targetNumber = ran.nextInt(ub - lb + 1) + lb;
            System.out.println("\nI have generated a number between " + lb + " and " + ub + ". Try to guess!");

            for (int attempt = 1; attempt <= Attempts; attempt++) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");
                int userGuess = s.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempt + " attempts.");
                    score += Attempts - attempt + 1;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempt == Attempts) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
        } while (s.next().equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! Your total score is: " + score);
        s.close();
    }
}
