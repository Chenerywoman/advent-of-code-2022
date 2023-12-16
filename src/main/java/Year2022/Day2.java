package Year2022;

import java.util.List;
import java.util.Map;

public class Day2 extends Day {
    
    static {
        currentDay = new Day2();
    }
    public Day2() {
        super(2);
    }


    /* Part1: total score is the sum of your scores for each round.
    The score for a single round is the score for the shape you selected
    (1 for Rock, 2 for Paper, and 3 for Scissors)
    plus the score for the outcome of the round
    (0 if you lost, 3 if the round was a draw, and 6 if you won).
    */

    /* Part2:
    X = lose; Y = draw; Z = win
     */

    Map <String, Move> moves = Map.of(
            "Rock", new Move(1, "Scissors", "Paper"),
            "Paper", new Move(2, "Rock", "Scissors"),
            "Scissors", new Move(3, "Paper", "Rock"));

    Map<String, Move> player1MoveLetters = Map.of(
            "A", moves.get("Rock"),
            "B", moves.get("Paper"),
            "C", moves.get("Scissors")
    );

    public String part1(List<String> inputLines) {
        String input = String.join("\n", inputLines);

        Map<String, Move> player2MoveLetters = Map.of(
                "X", moves.get("Rock"),
                "Y", moves.get("Paper"),
                "Z", moves.get("Scissors")
        );

        int count = 0;

        String[] games = input.split("\n");
        for (String game : games) {

            Move player1Move = player1MoveLetters.get(moveLetterForPlayer(1, game));
            Move player2Move = player2MoveLetters.get(moveLetterForPlayer(2, game));

            if (player1Move.equals(player2Move)) {
                count += 3;
            } else if (moves.get(player2Move.beats()).equals(player1Move)) {
                count += 6;
            }
            count += player2Move.score;
        }
        return Integer.toString(count);
    }

    public String part2(List<String> inputLines) {
        String input = String.join("\n", inputLines);
        int count = 0;
        String[] games = input.split("\n");
        for (String game : games) {
            Move player1Move = player1MoveLetters.get(moveLetterForPlayer(1, game));
            String requiredOutcomeLetter = moveLetterForPlayer(2, game);
            Move player2Move;

            // if lose - player2 move is player1 beats transformed into a Move
            if (requiredOutcomeLetter.equals("X")) {
                player2Move = moves.get(player1Move.beats());
            } else if (requiredOutcomeLetter.equals("Y")) {
            // if draw - player2 Move is a player1 Move - same
                player2Move = player1Move;
                count+= 3;
            } else {
                // win here
                player2Move = moves.get(player1Move.losesTo());
                count+= 6;
            }

            count += player2Move.score();
        }

        return Integer.toString(count);
    }

    private String moveLetterForPlayer(int playerNumber, String game) {
        return game.split(" ")[playerNumber - 1];
    }

    private record Move(int score, String beats, String losesTo) {
    }
}
