package Year2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// Borrowed from https://github.com/dave-burke/advent-of-code-java-starter/blob/master/src/main/java/aoc/App.java
public class App {

    private static final Map<Integer, Day> DAYS;

    static {
        DAYS = new HashMap<>();
        DAYS.put(1, new Day1());
        DAYS.put(2, new Day2());
    }

    private static String loadInput(int day){
        String paddedDay = String.valueOf(day);
        if(day < 10) {
            paddedDay = "0" + day;
        }
        String fileName = "day" + paddedDay + ".txt";

        try(BufferedReader r = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))) {
            return r.lines().collect(Collectors.joining("\n"));
        } catch(NullPointerException npe) {
            throw new IllegalArgumentException("Can’t find data for day using filename: " + fileName + ". Did you forget to put the file in the resources directory?", npe);
        } catch(IOException e){
            throw new UncheckedIOException(e);
        }
//        try(BufferedReader r = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))){
//            return r.lines().collect(toList());
//        } catch(IOException e){
//            throw new UncheckedIOException(e);
//        }
    }

    public static void main(String[] unused) {
        for (Map.Entry<Integer, Day> dayEntry : DAYS.entrySet()) {
            Day day = dayEntry.getValue();
            Integer dayNum = dayEntry.getKey();
            String input = loadInput(dayNum);
            System.out.println("Day " + dayNum + ", Part 1: " + day.part1(input));
            System.out.println("Day " + dayNum + ", Part 2: " + day.part2(input));
        }
    }
}
