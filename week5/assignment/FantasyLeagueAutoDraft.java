import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FantasyLeagueAutoDraft {

    public static class Player implements Comparable<Player> {
        String name;
        int matchesPlayed;
        int fitnessScore;
        double fantasyPoints;

        public Player(String name, int matchesPlayed, int fitnessScore, double fantasyPoints) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.fitnessScore = fitnessScore;
            this.fantasyPoints = fantasyPoints;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.fantasyPoints, this.fantasyPoints);
        }
    }

    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 50;
    }

    public static boolean isDraftable(int matchesPlayed, int fitnessScore) {
        return isDraftable(matchesPlayed) || (matchesPlayed >= 20 && fitnessScore >= 80);
    }

    public static String rankDraftablePlayers(Player[] roster) {
        List<Player> draftable = new ArrayList<>();
        for (Player p : roster) {
            if (isDraftable(p.matchesPlayed, p.fitnessScore)) {
                draftable.add(p);
            }
        }

        Collections.sort(draftable);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.size(); i++) {
            Player p = draftable.get(i);
            sb.append(String.format("%d. %s (%.1f pts)", (i + 1), p.name, p.fantasyPoints));
            if (i < draftable.size() - 1) sb.append(" | ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 5: Fantasy League Auto-Draft Ranking Engine ===");
        Player[] players = {
            new Player("Rahul", 60, 70, 85.5),
            new Player("Virat", 80, 90, 110.0),
            new Player("Rookie", 10, 60, 40.0),
            new Player("Dev", 25, 85, 78.0)
        };

        String result = rankDraftablePlayers(players);
        System.out.println("Draftable Players Ranked: " + result);
    }
}
