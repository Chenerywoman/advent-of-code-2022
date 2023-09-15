package Year2022;

import java.util.Optional;

public class Day3 implements Day{
    public String part1(String input) {
        int totalPriorities = 0;
        String[] rucksacks = input.split("\n");

        for (String rucksack : rucksacks) {
            int splitIndex = rucksack.length() / 2;
            String partOne = rucksack.substring(0, splitIndex);
            String partTwo = rucksack.substring(splitIndex);

            Optional<Character> potentialRepeatedCharacter = findOverlap(partOne, partTwo);

            totalPriorities += priority(potentialRepeatedCharacter.orElseThrow());
        }

        return String.valueOf(totalPriorities);
    }

    @Override
    public String part2(String input) {
        return null;
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
