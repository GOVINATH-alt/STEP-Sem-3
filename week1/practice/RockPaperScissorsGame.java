import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    public static String playRound(String playerMove, String computerMove) {
        String p = playerMove.trim().toLowerCase();
        String c = computerMove.trim().toLowerCase();

        if (p.equals(c)) {
            return "Draw";
        }
        if ((p.equals("rock") && c.equals("scissors")) ||
            (p.equals("paper") && c.equals("rock")) ||
            (p.equals("scissors") && c.equals("paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();

        // 5 Rounds simulation
        String[] predefinedPlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int rounds = 5;

        String[] playerHistory = new String[rounds];
        String[] computerHistory = new String[rounds];
        String[] resultHistory = new String[rounds];

        int wins = 0, losses = 0, draws = 0;

        System.out.println("=== Rock-Paper-Scissors Game Simulation ===");
        for (int i = 0; i < rounds; i++) {
            String pMove = predefinedPlayerMoves[i];
            String cMove = moves[random.nextInt(moves.length)];
            String res = playRound(pMove, cMove);

            playerHistory[i] = pMove;
            computerHistory[i] = cMove;
            resultHistory[i] = res;

            if (res.equals("Player Wins")) {
                wins++;
            } else if (res.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
            System.out.printf("Round %d — Player: %s, Computer: %s -> %s%n", (i + 1), pMove, cMove, res);
        }

        System.out.println("\n------------------------------------------------------------");
        System.out.printf("%-8s | %-12s | %-14s | %-14s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8d | %-12s | %-14s | %-14s%n", (i + 1), playerHistory[i], computerHistory[i], resultHistory[i]);
        }
        System.out.println("------------------------------------------------------------");

        double winPct = (wins * 100.0) / rounds;
        System.out.printf("Final Summary (after %d rounds) Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                rounds, wins, losses, draws, winPct);
    }
}
