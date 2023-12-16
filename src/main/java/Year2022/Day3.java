package Year2022;

import java.util.*;

public class Day3 extends Day {

    static {
        currentDay = new Day3();
    }

    public Day3() {
        super(3);
    }
    public String part1(List<String> inputLines) {
        String input = String.join("\n", inputLines);
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
    public String part2(List<String> input) {
        return null;
    }

    private static Optional<Character> findOverlap(String partOne, String partTwo) {
        Set<Character> partOneSet = setOfCharacters(partOne);
        Set<Character> partTwoSet = setOfCharacters(partTwo);

        partOneSet.retainAll(partTwoSet);
        return Optional.of(partOneSet.toArray(new Character[]{})[0]);
    }

    private static Set<Character> setOfCharacters(String characters) {
        Character[] characterArray = characters.chars().mapToObj(i -> (char) i).toArray(Character[]::new);
        return new HashSet<>(Arrays.asList(characterArray));
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
