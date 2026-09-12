package java_arrays_and_methods.class_problems;

public class HackathonSeatingOptimizer {
    public static void main(String[] args) {
        int[][] seating = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        System.out.println(classifyRows(seating, 60));
    }

    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) return 0;
        int sum = 0;
        for (int score : row) {
            sum += score;
        }
        return (double) sum / row.length;
    }

    public static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            if (i > 0) result.append(" | ");
            result.append("Row ").append(i).append(": ");
            if (avg >= threshold) {
                result.append("Buzzing Zone");
            } else {
                result.append("Quiet Zone");
            }
        }
        return result.toString();
    }
}
