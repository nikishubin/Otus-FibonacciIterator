package ru.otus.patterns.iterator.args;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

public class FibonacciTestArgs {

    public static Stream<Arguments> fibonacciNumbers() {
        return Stream.of(
                Arguments.arguments(
                        Arrays.asList(
                                0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L
                        )
                ),
                Arguments.arguments(
                        Arrays.asList(
                                0L, 1L
                        )
                ),
                Arguments.arguments(
                        Arrays.asList(
                                0L, 1L, 1L, 2L, 3L
                        )
                )
        );
    }

    public static Stream<Arguments> fibonacciNumbersWithBorders() {
        return Stream.of(
                Arguments.arguments(
                        Arrays.asList(
                                0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L
                        ), 2, 6
                ),
                Arguments.arguments(
                        Arrays.asList(
                                0L, 1L
                        ), 0, 1
                ),
                Arguments.arguments(
                        Arrays.asList(
                                0L, 1L, 1L, 2L, 3L
                        ), 3, 3
                )
        );
    }

    public static Stream<Arguments> fibonacciNumbersWithRevertBorders() {
        return Stream.of(
                Arguments.arguments(
                        Arrays.asList(
                                0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L
                        ), 6, 2
                ),
                Arguments.arguments(
                        Arrays.asList(
                                0L, 1L
                        ), 1, 0
                ),
                Arguments.arguments(
                        Arrays.asList(
                                0L, 1L, 1L, 2L, 3L
                        ), 3, 3
                )
        );
    }
}
