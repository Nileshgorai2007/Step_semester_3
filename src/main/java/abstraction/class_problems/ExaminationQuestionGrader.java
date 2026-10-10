package abstraction.class_problems;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;
    
    public Question(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }
    
    public abstract double grade();
}

class MCQQuestion extends Question {
    public MCQQuestion(String q, String c, String s, double p) { super(q, c, s, p); }
    @Override public double grade() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0;
    }
}

class TFQuestion extends Question {
    public TFQuestion(String q, String c, String s, double p) { super(q, c, s, p); }
    @Override public double grade() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String q, String c, String s, double p) { super(q, c, s, p); }
    @Override public double grade() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String saLower = studentAnswer.toLowerCase();
        for (String kw : keywords) {
            if (saLower.contains(kw.trim().toLowerCase())) {
                matchCount++;
            }
        }
        if (matchCount >= 2) return points * 0.75;
        if (matchCount == 1) return points * 0.50;
        return 0;
    }
}

public class ExaminationQuestionGrader {
    public static void main(String[] args) {
        Question[] questions = {
            new MCQQuestion("What is the capital of France?", "Paris", "Paris", 10),
            new TFQuestion("The Earth is flat?", "False", "True", 5),
            new EssayQuestion("Name two primary OOP principles.", "Inheritance, Polymorphism, Encapsulation", "Polymorphism is one.", 20),
            new EssayQuestion("Describe abstraction and composition.", "Abstraction, Composition", "I talked about abstraction.", 15)
        };
        
        String[] types = {"MCQ", "TF", "ESSAY", "ESSAY"};
        double totalScore = 0;
        
        for (int i = 0; i < questions.length; i++) {
            double score = questions[i].grade();
            System.out.println(types[i] + ": " + String.format("%.2f", score));
            totalScore += score;
        }
        System.out.println("Total Score: " + String.format("%.2f", totalScore));
    }
}
