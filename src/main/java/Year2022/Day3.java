package Year2022;

public class Day3 {
    public String part1(String input) {
        int priority;
        char repeatedCharacter = input.charAt(0);
        if (Character.isLowerCase(repeatedCharacter)) {
            priority = 1 + offsetOfCharacter(repeatedCharacter, 'a');
        } else {
            priority = 27 + offsetOfCharacter(repeatedCharacter, 'A');
        }
        return String.valueOf(priority);
    }

    private int offsetOfCharacter(char to, char from) {
        return to - from;
    }
}
