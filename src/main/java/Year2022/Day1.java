package Year2022;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.reverseOrder;

public class Day1 extends Day {

    static {
        currentDay = new Day1();
    }
    public Day1() {
        super(1);
    }

    public String part1(List<String> inputLines) {
        String input = String.join("\n", inputLines);
        return descendingElves(input).get(0).toString();
    }

    public String part2(List<String> inputLines) {
        String input = String.join("\n", inputLines);

        List<Integer> elvesCalories = descendingElves(input);

        List<Integer> greediestThreeElves = elvesCalories.subList(0, 3);
        return greediestThreeElves.stream().reduce(Integer::sum).orElseThrow(() -> new RuntimeException("Where is the input?")).toString();
    }

    private static List<Integer> descendingElves(String testString) {
        return Arrays.stream(testString.split("\n\n"))
                .map(elf -> elf.split("\n"))
//                .map(elfCalories -> sumStrings(elfCalories))
                .map(Day1::sumStrings)
                .sorted(reverseOrder())
                .toList();
    }

    private static int sumStrings(String[] strings) {
        return Arrays.stream(strings).mapToInt(Integer::parseInt).sum();
    }
}