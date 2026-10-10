package encapsulation.class_problems;

public class Scorecard {
    private final int totalQuestions;
    private final boolean[] answers;
    private int recorded;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.answers = new boolean[totalQuestions];
        this.recorded = 0;
    }

    public void recordAnswer(boolean correct) {
        if (recorded < totalQuestions) {
            answers[recorded++] = correct;
        }
    }

    public int getScore() {
        int score = 0;
        for (boolean ans : answers) {
            if (ans) score++;
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println(sc.getScore()); // 3
    }
}
