package programing_fundamentals.class_problems;

import java.util.Scanner;

public class GCDCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int number1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int number2 = scanner.nextInt();
        
        int orig1 = number1;
        int orig2 = number2;
        
        while (number2 != 0) {
            int remainder = number1 % number2;
            number1 = number2;
            number2 = remainder;
        }
        
        System.out.println("The GCD of " + orig1 + " and " + orig2 + " is " + number1);
        scanner.close();
    }
}
