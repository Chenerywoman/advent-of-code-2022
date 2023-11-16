package Year2022;

import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 implements Day {

    public static final int PRIORITY_OF_LOWER_A = 1;
    public static final int PRIORITY_OF_UPPER_A = 27;

    public String part1(String input) {
        int totalPriorities = 0;
        String[] rucksacks = input.split("\n");

        for (String rucksack : rucksacks) {
            int splitIndex = rucksack.length() / 2;
            String partOne = rucksack.substring(0, splitIndex);
            String partTwo = rucksack.substring(splitIndex);

            String potentialRepeatedCharacter = findOverlap(partOne, partTwo);

            totalPriorities += priority(potentialRepeatedCharacter);
        }

        return String.valueOf(totalPriorities);
    }

    @Override
    public String part2(String input) {
        Pattern threeLinePattern = Pattern.compile("([a-z]+)\\n([a-z]+)\\n([a-z]+)\\n");
        Matcher matcher = threeLinePattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }
        return null;
    }

    private static String findOverlap(String partOne, String partTwo) {
        Set<String> partOneSet = setOfStrings(partOne);
        Set<String> partTwoSet = setOfStrings(partTwo);

        partOneSet.retainAll(partTwoSet);
        return String.join("", partOneSet);
    }

    private static Set<String> setOfStrings(String characters) {
        return new HashSet<>(Arrays.asList(characters.split("")));
    }

    private int offsetOfCharacter(char to, char from) {
        return to - from;
    }

    private int priority(String repeatedCharacterString) {
        char repeatedCharacter = repeatedCharacterString.charAt(0);
        if (Character.isLowerCase(repeatedCharacter)) {
            return PRIORITY_OF_LOWER_A + offsetOfCharacter(repeatedCharacter, 'a');
        } else {
            return PRIORITY_OF_UPPER_A + offsetOfCharacter(repeatedCharacter, 'A');
        }
    }
}
