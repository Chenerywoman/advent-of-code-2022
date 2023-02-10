package Year2022;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class Day2Test {


// for commit

    @Test
    void partOneExample() {
        String input = """
                A Y
                B X
                C Z""";
        String result = new Day2().part1(input);
        assertThat(result).isEqualTo("15");
    }
    @Test
    void partOnePaperIsWorthTwo() {
        String input = "C Y";
        String result = new Day2().part1(input);
        assertThat(result).isEqualTo("2");
    }

    @Test
    void partTwoLoseToPaper() {
        String input = "B X";
        String result = new Day2().part2(input);
        assertThat(result).isEqualTo("1");
    }
    @Test
    void partTwoLoseToRock() {
        String input = "A X";
        String result = new Day2().part2(input);
        assertThat(result).isEqualTo("3");
    }
    @Test
    void partTwoLoseToScissors() {
        String input = "C X";
        String result = new Day2().part2(input);
        assertThat(result).isEqualTo("2");
    }

}