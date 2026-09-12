package java_arrays_and_methods.assignment_problems;

public class MatchDayGridAnalyzer {
    public static void main(String[] args) {
        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        System.out.println(classifyMatches(runsPerOver, 8));
    }

    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) return 0;
        int sum = 0;
        for (int score : row) {
            sum += score;
        }
        return (double) sum / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            if (i > 0) result.append(" | ");
            result.append("Match ").append(i).append(": ");
            if (avg >= threshold) {
                result.append("Power Surge");
            } else {
                result.append("Normal");
            }
        }
        return result.toString();
    }
}
