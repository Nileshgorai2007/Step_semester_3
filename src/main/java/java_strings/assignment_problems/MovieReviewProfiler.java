package java_strings.assignment_problems;

public class MovieReviewProfiler {
    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }

    public static void classifyWordLengths(String review) {
        String[] words = review.split("\\s+");
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            // Remove punctuation for accurate counting if needed, but simple length suffices for this requirement
            int len = word.length();
            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }
}
