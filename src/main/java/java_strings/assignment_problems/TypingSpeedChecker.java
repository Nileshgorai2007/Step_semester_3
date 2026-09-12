package java_strings.assignment_problems;

public class TypingSpeedChecker {
    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }

    public static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Lengths do not match!");
            return;
        }

        int matches = 0;
        int firstMismatchIndex = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matches++;
            } else if (firstMismatchIndex == -1) {
                firstMismatchIndex = i;
            }
        }

        double accuracy = ((double) matches / original.length()) * 100;
        
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ", matches, original.length(), accuracy);
        if (firstMismatchIndex == -1) {
            System.out.println("No Mismatches");
        } else {
            System.out.printf("First Mismatch at position %d ('%c' vs '%c')%n", 
                    firstMismatchIndex + 1, original.charAt(firstMismatchIndex), typed.charAt(firstMismatchIndex));
        }
    }
}
