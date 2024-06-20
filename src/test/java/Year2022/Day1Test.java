package Year2022;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class Day1Test {

    @Test
    void singleNumber() {
        //given
        String testString = "1";

        //when
        String calorieCount = new Day1().part1(getList(testString));

        //then
        assertThat(calorieCount).isEqualTo("1");
    }

    @Test
    void multipleNumber() {
        //given
        String testString = "1\n2\n3\n";

        //when
        String calorieCount = new Day1().part1(getList(testString));

        //then
        assertThat(calorieCount).isEqualTo("6");
    }

    @ParameterizedTest
    @MethodSource(value = "numberBlockgenerator")
    void blocksOfMultipleNumbers(String numbers, String greediest) {
        //given
        //when
        String calorieCount = new Day1().part1(getList(numbers));

        //then
        assertThat(calorieCount).isEqualTo(greediest);
    }

    public static List<String> getList(String numbers) {
        return Arrays.asList(numbers.split("\n"));
    }

    public static Stream<Arguments> numberBlockgenerator() {
        return Stream.of(
                Arguments.of("1\n2\n3\n\n5\n6\n7", "18"),
                Arguments.of("4056\n5122\n11426\n\n5529\n3659\n9592\n10257", "29037")
        );
    }

    @Test
    void threeGreediestElves() {
        assertThat(new Day1().part2(getList(
                // this is a text block!
                """
                        1000
                        2000
                        3000

                        4000

                        5000
                        6000

                        7000
                        8000
                        9000

                        10000"""))).isEqualTo("45000");
    }
}