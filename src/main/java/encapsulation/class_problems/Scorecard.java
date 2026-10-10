package encapsulation.class_problems;

public class Scorecard {
    private final boolean[] results;
    private int count;

    public Scorecard(int numQuestions) {
        if (numQuestions <= 0) throw new IllegalArgumentException("Number of questions must be positive");
        this.results = new boolean[numQuestions];
        this.count = 0;
    }

    public void recordAnswer(boolean correct) {
        if (this.count < this.results.length) {
            this.results[this.count++] = correct;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < this.count; i++) {
            if (this.results[i]) {
                score++;
            }
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
