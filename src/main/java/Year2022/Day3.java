package Year2022;

import java.util.Optional;

public class Day3 {
    public String part1(String input) {
        int splitIndex = input.length() / 2;
        String partOne = input.substring(0, splitIndex);
        String partTwo = input.substring(splitIndex);

        Optional<Character> potentialRepeatedCharacter = findOverlap(partOne, partTwo);

        return String.valueOf(priority(potentialRepeatedCharacter.orElseThrow()));
    }

    private static Optional<Character> findOverlap(String partOne, String partTwo) {
        Optional<Character> potentialRepeatedCharacter = Optional.empty();

        for (char letter : partOne.toCharArray()) {
            if (partTwo.contains(String.valueOf(letter))) {
                potentialRepeatedCharacter = Optional.of(letter);
            }
        }
        return potentialRepeatedCharacter;
    }

    private int offsetOfCharacter(char to, char from) {
        return to - from;
    }

    private int priority(char repeatedCharacter) {
        if (Character.isLowerCase(repeatedCharacter)) {
            return 1 + offsetOfCharacter(repeatedCharacter, 'a');
        } else {
            return 27 + offsetOfCharacter(repeatedCharacter, 'A');
        }
    }
}
