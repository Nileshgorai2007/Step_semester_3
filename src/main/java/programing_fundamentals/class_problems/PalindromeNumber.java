package programing_fundamentals.class_problems;

import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int origNumber = number;
        int reversedNumber = 0;
        int temp = number;
        
        while (temp > 0) {
            int digit = temp % 10;
            reversedNumber = reversedNumber * 10 + digit;
            temp = temp / 10;
        }
        
        boolean isPalindrome = (origNumber == reversedNumber);
        System.out.println("Is the number " + origNumber + " a Palindrome? " + isPalindrome);
        scanner.close();
    }
}
