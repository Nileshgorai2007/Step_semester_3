package java_strings.class_problems;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String[] testCases = {"swiss", "aabbcc"};
        for (String text : testCases) {
            char result = findFirstNonRepeatingChar(text);
            if (result != '\0') {
                System.out.println("Input: \"" + text + "\" -> First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("Input: \"" + text + "\" -> No Non-Repeating Character Found");
            }
        }
    }

    public static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256];
        for (char c : text.toCharArray()) {
            freq[c]++;
        }
        for (char c : text.toCharArray()) {
            if (freq[c] == 1) return c;
        }
        return '\0';
    }
}
