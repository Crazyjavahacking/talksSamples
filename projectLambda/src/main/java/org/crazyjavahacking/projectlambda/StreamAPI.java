package org.crazyjavahacking.projectlambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Martin Skurla crazyjavahacking@gmail.com
 */
public class StreamAPI {
    public static void main(String... args) {
        streamAPIInAction();
        streamAPIOptimizationInAction();
    }
    
    private static void streamAPIInAction() {
        Collection<String> names =
                Arrays.asList("Anabell", "Barbara", "Bob", "Brian", "Martin");
        
        Map<Character, List<String>> namesGrouped = names.stream()
                                                         .filter(name -> name.length() >= 4)
                                                         .map(name -> name.toLowerCase())
                                                         .collect(Collectors.groupingBy(name -> name.charAt(0)));
        
        System.out.println(namesGrouped);
    }
    
    private static void streamAPIOptimizationInAction() {
        IntStream infiniteNumberStream = IntStream.iterate(1, i -> i + 1);
        
        Optional<String> first = infiniteNumberStream
                                        .filter(number -> number % 2 == 0)
                                        .mapToObj(number -> "number: " + number)
                                        .findFirst();
        
        System.out.println("first: " + first.get());
    }
}
