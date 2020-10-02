package ru.otus.patterns.iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.otus.patterns.iterator.fibonacci.BinetFibonacci;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class BinetFibonacciTest {

    @ParameterizedTest
    @MethodSource("ru.otus.patterns.iterator.args.FibonacciTestArgs#fibonacciNumbers")
    void whenInfiniteFibonacciThenExpectedSequence(Collection<Long> fibonacciNumbers) {
        Iterator<Long> fibonacci = new BinetFibonacci();

        fibonacciNumbers.forEach(next -> {
            long generated = fibonacci.next();
            Assertions.assertEquals(generated, next);
        });
    }

    @ParameterizedTest
    @MethodSource("ru.otus.patterns.iterator.args.FibonacciTestArgs#fibonacciNumbersWithBorders")
    void whenLimitedFibonacciThenExpectedSequence(List<Long> fibonacciNumbers, int from, int to) {
        Iterator<Long> fibonacci = new BinetFibonacci(from, to);

        List<Long> actual = new ArrayList<>();
        while (fibonacci.hasNext()) {
            actual.add(fibonacci.next());
        }

        List<Long> expected = new ArrayList<>();
        for (int i = from; i <= to; i++) {
            expected.add(fibonacciNumbers.get(i));
        }

        Assertions.assertArrayEquals(actual.toArray(Long[]::new), expected.toArray(Long[]::new));
    }

    @ParameterizedTest
    @MethodSource("ru.otus.patterns.iterator.args.FibonacciTestArgs#fibonacciNumbersWithRevertBorders")
    void whenRevertedLimitedFibonacciThenExpectedSequence(List<Long> fibonacciNumbers, int from, int to) {
        Iterator<Long> fibonacci = new BinetFibonacci(from, to);

        List<Long> actual = new ArrayList<>();
        while (fibonacci.hasNext()) {
            actual.add(fibonacci.next());
        }

        List<Long> expected = new ArrayList<>();
        for (int i = from; i >= to; i--) {
            expected.add(fibonacciNumbers.get(i));
        }

        Assertions.assertArrayEquals(actual.toArray(Long[]::new), expected.toArray(Long[]::new));
    }
}
