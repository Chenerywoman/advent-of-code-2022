/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Year2022;

import Year2022.Day;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.toSet;

public class App {
    public static void main(String[] args) {

        Reflections reflections = new Reflections(Day.class.getPackageName());
        Set<Day> daysToPrint = reflections.getSubTypesOf(Day.class).stream().map(initialiseInstance()).collect(toSet());
        int specifiedPart = 1;
        boolean dayWasSpecified = args.length != 0;
        if (dayWasSpecified) {
            int specifiedDay = Integer.parseInt(args[0]);
            daysToPrint = daysToPrint.stream().filter(d -> d.dayNumber() == specifiedDay).collect(toSet());
            if (args.length > 1) {
                specifiedPart = Integer.parseInt(args[1]);
            }
        }

        for (Day currentDay : daysToPrint) {
            if (dayWasSpecified) {
                if (specifiedPart == 1) {
                    currentDay.printPart1();
                } else {
                    currentDay.printPart2();
                }
            } else {
                currentDay.printPart1();
                currentDay.printPart2();
            }
        }
    }

    private static Function<Class<? extends Day>, ? extends Day> initialiseInstance() {
        return d -> {
            try {
                return d.getDeclaredConstructor().newInstance();
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException e) {
                throw new RuntimeException("Encountered an issue attempting to create an instance of the current day class for child class: " + d.getName(), e);
            }
        };
    }
}
