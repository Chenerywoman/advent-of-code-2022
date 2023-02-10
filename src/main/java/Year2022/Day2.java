package Year2022;

import java.util.Map;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

public class Day2 implements Day {

    //Rock - A, X
    // Paper - B, Y
    //Scissors  - C, Z

    //    Your total score is the sum of your scores for each round.
//    The score for a single round is the score for the shape you selected
//    (1 for Rock, 2 for Paper, and 3 for Scissors)
//    plus the score for the outcome of the round
//    (0 if you lost, 3 if the round was a draw, and 6 if you won).
    public String part1(String input) {
        // Go through each game and extract the letter for each player (A -> Rock etc)
        // Work out which one wins or if draw
        // Allocate score for game
        // Sum up your scores

        Move rock = new Move(1, "Rock");
        Move paper = new Move(2, "Paper");
        Move scissors = new Move(3, "Scissors");
        Map<String, Move> moveLetters = Map.of(
                "A", rock,
                "B", paper,
                "C", scissors,
                "X", rock,
                "Y", paper,
                "Z", scissors
        );

        int count = 0;

        String[] games = input.split("\n");
        for (String game : games) {

            Move player1Move = moveLetters.get(moveLetterForPlayer(1, game));
            Move player2Move = moveLetters.get(moveLetterForPlayer(2, game));

            if (player1Move.equals(player2Move)) {
                count += 3;
            } else if (playerTwoWins(player1Move, player2Move)) {
                count += 6;
            }
            count += player2Move.score;
        }
        return Integer.toString(count);
    }

    private String moveLetterForPlayer(int playerNumber, String game) {
        return game.split(" ")[playerNumber-1];
    }

    private boolean playerTwoWins(Move player1Move, Move player2Move) {
        return player2Move.name().equals("Rock") && player1Move.name().equals("Scissors") ||
                player2Move.name().equals("Paper") && player1Move.name().equals("Rock") ||
                player2Move.name().equals("Scissors") && player1Move.name().equals("Paper");
    }

    public String part2(String input) {
        return "";
    }

    private record Move(int score, String name) {
    }
}
