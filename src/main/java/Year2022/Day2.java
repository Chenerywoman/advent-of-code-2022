package Year2022;

import java.util.Map;

public class Day2 implements Day {

    /* Part1: total score is the sum of your scores for each round.
    The score for a single round is the score for the shape you selected
    (1 for Rock, 2 for Paper, and 3 for Scissors)
    plus the score for the outcome of the round
    (0 if you lost, 3 if the round was a draw, and 6 if you won).
    */

    /* Part2:
    Y = lose; Y = draw; Z = win
     */
        Move rock = new Move(1, "Rock", "Scissors");
        Move paper = new Move(2, "Paper", "Rock");
        Move scissors = new Move(3, "Scissors", "Paper");

    Map<String, Move> player1MoveLetters = Map.of(
            "A", rock,
            "B", paper,
            "C", scissors
    );

    public String part1(String input) {

        Map<String, Move> player2MoveLetters = Map.of(
                "X", rock,
                "Y", paper,
                "Z", scissors
        );

        int count = 0;

        String[] games = input.split("\n");
        for (String game : games) {

            Move player1Move = player1MoveLetters.get(moveLetterForPlayer(1, game));
            Move player2Move = player2MoveLetters.get(moveLetterForPlayer(2, game));

            if (player1Move.equals(player2Move)) {
                count += 3;
            } else if (player2Move.beats().equals(player1Move.name())) {
                count += 6;
            }
            count += player2Move.score;
        }
        return Integer.toString(count);
    }

    public String part2(String input) {
        return "";
    }

    private String moveLetterForPlayer(int playerNumber, String game) {
        return game.split(" ")[playerNumber-1];
    }

    private record Move(int score, String name, String beats) {
    }
}
