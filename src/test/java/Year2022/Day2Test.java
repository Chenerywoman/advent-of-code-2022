package Year2022;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class Day2Test {


// for commit

    @Test
    void partOneExample() {

        String input = "A Y\n" +
                "B X\n" +
                "C Z";
        String result = new Day2().part1(input);
        assertThat(result).isEqualTo("15");
    }


}