package Year2022;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day3Test {

    @Test
    void partOneSingleRucksackTwoAs() {
        String input = "aa";
        String result = new Day3().part1(input );
        assertThat(result).isEqualTo("1");
    }

    @Test
    void partOneTwoRucksacksEachWithTwoAs() {
        String input = "aa\naa";
        String result = new Day3().part1(input );
        assertThat(result).isEqualTo("2");
    }
    @Test
    void partOneSingleRucksackTwoAsOneBOneC() {
        String input = "abac";
        String result = new Day3().part1(input );
        assertThat(result).isEqualTo("1");
    }

    @Test
    void partOneSingleRucksackTwoBs() {
        String input = "bb";
        String result = new Day3().part1(input );
        assertThat(result).isEqualTo("2");
    }

    @Test
    void partOneSingleRucksackTwoZs() {
        String input = "zz";
        String result = new Day3().part1(input );
        assertThat(result).isEqualTo("26");
    }

    @Test
    void partOneSingleRucksackTwoUpperCaseAs() {
        String input = "AA";
        String result = new Day3().part1(input);
        assertThat(result).isEqualTo("27");
    }

    @Test
    void partOneSingleRucksackMultipleItemsEachSide() {
        String input = "baca";
        String result = new Day3().part1(input);
        assertThat(result).isEqualTo("1");
    }

    @Test
    void partOneExample() {
        String input = """
                vJrwpWtwJgWrhcsFMMfFFhFp
                jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
                PmmdzqPrVvPwwTWBwg
                wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
                ttgJtRGJQctTZtZT
                CrZsJsPPZsGzwwsLwLmpwMDw""";

        String result = new Day3().part1(input);
        assertThat(result).isEqualTo("157");
    }
}
