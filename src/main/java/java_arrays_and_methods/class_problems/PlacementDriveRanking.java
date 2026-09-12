package java_arrays_and_methods.class_problems;

import java.util.Arrays;

public class PlacementDriveRanking {
    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        int eligibleCount = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                eligibleCount++;
            }
        }
        
        Candidate[] shortlisted = new Candidate[eligibleCount];
        int index = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlisted[index++] = c;
            }
        }
        
        Arrays.sort(shortlisted);
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) result.append(" | ");
            result.append(i + 1).append(". ").append(shortlisted[i].name)
                  .append(" (").append(shortlisted[i].getCompositeScore()).append(")");
        }
        
        return result.toString();
    }

    public static class Candidate implements Comparable<Candidate> {
        String name;
        double cgpa;
        int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }
        
        public double getCompositeScore() {
            return (cgpa * 10) + codingScore;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }
    }
}
