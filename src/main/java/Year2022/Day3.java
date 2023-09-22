package Year2022;

import java.util.*;

public class Day3 implements Day {
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
        Character[] partOneChars = partOne.chars().mapToObj(i -> (char) i).toArray(Character[]::new);
        Set<Character> partOneSet = new HashSet<>(Arrays.asList(partOneChars));
        Character[] partTwoChars = partTwo.chars().mapToObj(i -> (char) i).toArray(Character[]::new);
        Set<Character> partTwoSet = new HashSet<>(Arrays.asList(partTwoChars));

        partOneSet.retainAll(partTwoSet);
        return Optional.of(partOneSet.toArray(new Character[]{})[0]);
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
