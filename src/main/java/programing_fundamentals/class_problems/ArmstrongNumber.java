package programing_fundamentals.class_problems;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int origNumber = number;
        int sum = 0;
        int temp = number;
        
        while (temp > 0) {
            int digit = temp % 10;
            sum += (digit * digit * digit);
            temp = temp / 10;
        }
        
        boolean isArmstrong = (origNumber == sum);
        System.out.println("Is the number " + origNumber + " an Armstrong number? " + isArmstrong);
        scanner.close();
    }
}
