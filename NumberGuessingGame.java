import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain;
        int totalAttempts = 0;
        int roundsWon = 0;
        
        do {
            int number_to_guess = generateRandomNumber(1, 100);
            int attempts = 0;
            boolean Right_answer = false;
            
            System.out.println("Guess the number between 1 and 100. You have 10 attempts.");
            
            while (attempts < 10) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                int user_guess = sc.nextInt();
                attempts++;
                
                if (user_guess < number_to_guess) {
                    System.out.println("Too low!");
                } else if (user_guess > number_to_guess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number " + number_to_guess + " correctly in " + attempts + " attempts.");
                    roundsWon++;
                    Right_answer = true;
                    break;
                }
            }
            
            if (!Right_answer) {
                System.out.println("Sorry, you've used all 10 attempts. The number was " + number_to_guess + ".");
            }
            
            totalAttempts += attempts;
            
            System.out.print("Do you want to play again? (yes/no): ");
            String response = sc.next();
            playAgain = response.equalsIgnoreCase("yes");
            
        } while (playAgain);
        
        System.out.println("Game Over! Your total rounds won: " + roundsWon);
        System.out.println("Your total attempts: " + totalAttempts);
        
        sc.close();
    }
    
    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
