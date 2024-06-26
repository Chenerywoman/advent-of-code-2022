package Year2022;

import org.junit.jupiter.api.Test;

import static Year2022.Day1Test.getList;
import static org.assertj.core.api.Assertions.*;

class Day2Test {


// for commit

    @Test
    void partOneExample() {
        String input = """
                A Y
                B X
                C Z""";
        String result = new Day2().part1(getList(input));
        assertThat(result).isEqualTo("15");
    }
    @Test
    void partOnePaperIsWorthTwo() {
        String input = "C Y";
        String result = new Day2().part1(getList(input));
        assertThat(result).isEqualTo("2");
    }

    @Test
    void partTwoLoseToPaper() {
        String input = "B X";
        String result = new Day2().part2(getList(input));
        assertThat(result).isEqualTo("1");
    }
    @Test
    void partTwoLoseToRock() {
        String input = "A X";
        String result = new Day2().part2(getList(input));
        assertThat(result).isEqualTo("3");
    }
    @Test
    void partTwoLoseToScissors() {
        String input = "C X";
        String result = new Day2().part2(getList(input));
        assertThat(result).isEqualTo("2");
    }

    @Test
    void partTwoDrawToPaper() {
        String input = "B Y";
        String result = new Day2().part2(getList(input));
        assertThat(result).isEqualTo("5");
    }
    @Test
    void partTwoDrawToRock() {
        String input = "A Y";
        String result = new Day2().part2(getList(input));
        assertThat(result).isEqualTo("4");
    }
    @Test
    void partTwoDrawToScissors() {
        String input = "C Y";
        String result = new Day2().part2(getList(input));
        assertThat(result).isEqualTo("6");
    }
    @Test
    void partTwoWinToPaper() {
        String input = "B Z";
        String result = new Day2().part2(getList(input));
        assertThat(result).isEqualTo("9");
    }
    @Test
    void partTwoWinToRock() {
        String input = "A Z";
        String result = new Day2().part2(getList(input));
        assertThat(result).isEqualTo("8");
    }
    @Test
    void partTwoWinToScissors() {
        String input = "C Z";
        String result = new Day2().part2(getList(input));
        assertThat(result).isEqualTo("7");
    }



}