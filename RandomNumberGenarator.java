import java.util.Scanner;

public class RandomNumberGenarator {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("Choose difficulty:");
      System.out.println("1. Easy (1-50)");
      System.out.println("2. Medium (1-100)");
      System.out.println("3. Hard (1-1000)");
      int difficulty = sc.nextInt();

      int min = 1;
      int max = 100;
      int maxAttempts = 10;
      int attempts = 0;

      switch (difficulty) {
        case 1:
          max = 50;
          maxAttempts = 7;
          break;
        case 3:
          max = 1000;
          maxAttempts = 15;
          break;
      }

      int secretNumber = (int) (Math.random() * (max - min + 1)) + min;
      System.out.println("I've generated a random number between " + min + " and " + max + ".");
      System.out.println("You have " + maxAttempts + " attempts to guess it correctly.");

      for (int i = 1; i <= maxAttempts; i++) {
        System.out.print("Enter your guess: ");
        int userGuess = sc.nextInt();

        if (userGuess == secretNumber) {
          System.out.println("Congratulations! You guessed the number in " + i + " attempts.");
          break;
        } else if (userGuess < secretNumber) {
          System.out.println("Your guess is too low. Try again.");
        } else {
          System.out.println("Your guess is too high. Try again.");
        }
        attempts++;
      }

      if (attempts > maxAttempts) {
        System.out.println("Sorry, you didn't guess the number in " + maxAttempts + " attempts. The correct number was "
            + secretNumber + ".");
      }

      System.out.print("Do you want to play another round? (yes/no): ");
      String playAgain = sc.next().toLowerCase();

      if (!playAgain.equals("yes")) {
        System.out.println("Thanks for playing! Goodbye.");
        break;
      }
    }
    sc.close();
  }
}