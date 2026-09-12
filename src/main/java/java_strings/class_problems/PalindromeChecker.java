package java_strings.class_problems;

public class PalindromeChecker {
    public static void main(String[] args) {
        String[] testCases = {"madam", "hello"};
        for (String text : testCases) {
            boolean iterative = isPalindromeIterative(text);
            boolean recursive = isPalindromeRecursive(text);
            boolean arrayRev = isPalindromeArrayReversal(text);
            
            System.out.printf("Input: \"%s\" -> Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                    text, 
                    iterative ? "Palindrome" : "Not Palindrome", 
                    recursive ? "Palindrome" : "Not Palindrome", 
                    arrayRev ? "Palindrome" : "Not Palindrome");
        }
    }

    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
        String reversed = new String(arr);
        return text.equals(reversed);
    }
}
