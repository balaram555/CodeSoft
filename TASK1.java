import java.util.*;

class TASK1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int totalRounds = 0;
        int roundsWon = 0;

        while (true) {
            boolean correctGuess = false;
            int attempts = 5;  

            for (int i = 0; i < attempts; i++) {
                int random = r.nextInt(100) + 1;  
                System.out.println("Guess the number between 1 and 100:");
                System.out.println("Enter your guess:");
                int guess = sc.nextInt();
                
                if (guess == random) {
                    System.out.println("Guess is correct!");
                    correctGuess = true;
                    roundsWon++;
                    break;
                } else if (guess > random) {
                    System.out.println("Guess is too high, try again.");
                } else {
                    System.out.println("Guess is too low, try again.");
                }
            }

            if (!correctGuess) {
                System.out.println("You've run out of attempts.");
            }

            totalRounds++;
            System.out.println("Rounds played: " + totalRounds + ", Rounds won: " + roundsWon);
            System.out.println("Do you want to play again? (yes/no)");

            String response = sc.next();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        sc.close();
        System.out.println("Thank you for playing! Final score: Rounds played: " + totalRounds + ", Rounds won: " + roundsWon);
    }
}
