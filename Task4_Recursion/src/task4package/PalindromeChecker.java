package task4package;//Source citation from ChatGPT for recursive and iterative boolean methods
import java.util.Scanner;

public class PalindromeChecker {

    // Recursive method to check if a string is a palindrome
    public static boolean isPalindromeRecursive(String str) {  // Part C
        // Base case: if the length of the string is 1 or less, it's a palindrome
        if (str.length() <= 1) {
            //returns true if the if statement is true
            return true;
        }

        // Converts to lowercase and removes non-alphabetic characters
        str = str.toLowerCase().replaceAll("[^a-z]", "");

        // Checks if the first and last characters are the same
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            // Recursively checks the substring excluding the first and last characters
            return isPalindromeRecursive(str.substring(1, str.length() - 1));
        } else {
            // Returns false if the first and last characters are different, it's not a palindrome
            return false;
        }
    }

    // Iterative method to check if a string is a palindrome
    public static boolean isPalindromeIterative(String str) {  //Part D
        // Converts to lowercase and removes non-alphabetic characters
        str = str.toLowerCase().replaceAll("[^a-z]", "");

        // Initializes left and right pointers
        int left = 0;
        int right = str.length() - 1;

        // Iterates until the left pointer is less than the right pointer
        while (left < right) {
            // If characters at the left and right pointers are different, it's not a palindrome
            if (str.charAt(left) != str.charAt(right)) {
                //Returns false if the if statement is true
                return false;
            }
            // Move the pointers towards the center
            left++;
            right--;
        }

        // Returns true if the loop completes without returning false, the string is a palindrome
        return true;
    }

    public void palindromeChecker() {
        Scanner scnr = new Scanner(System.in);

        //Loop for asking the user to enter a string or type exit to quit program
        while (true) {
            System.out.print("Enter a string (or 'exit' to quit): ");
            String input = scnr.nextLine();

            //If user types exit the program concludes
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            //If else statements to check if the input is palindrome using recursive and iterative methods
            if (isPalindromeRecursive(input)) {
                System.out.println("The string is a palindrome (recursive).");
            } else {
                System.out.println("The string is not a palindrome (recursive).");
            }

            if (isPalindromeIterative(input)) {
                System.out.println("The string is a palindrome (iterative).");
            } else {
                System.out.println("The string is not a palindrome (iterative).");
            }
        }

        scnr.close();
    }
}
