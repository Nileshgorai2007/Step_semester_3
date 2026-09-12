package java_strings.class_problems;

import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        // Driver code
        String[] moves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int wins = 0, losses = 0, draws = 0;
        
        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < 5; i++) {
            String[] options = {"Rock", "Paper", "Scissors"};
            String computerMove = options[new Random().nextInt(3)];
            String result = playRound(moves[i], computerMove);
            
            System.out.printf("Round %d | Player: %s | Computer: %s | Result: %s%n", 
                              i + 1, moves[i], computerMove, result);
                              
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }
        
        double winPercentage = (double) wins / 5 * 100;
        System.out.printf("Final Summary: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", 
                          wins, losses, draws, winPercentage);
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) return "Draw";
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
}
