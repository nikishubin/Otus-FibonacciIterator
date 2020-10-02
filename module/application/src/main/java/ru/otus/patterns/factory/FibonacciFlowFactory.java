package ru.otus.patterns.factory;

import ru.otus.patterns.iterator.Iterator;
import ru.otus.patterns.iterator.port.FibonacciOutput;

public interface FibonacciFlowFactory {

    FibonacciOutput getWriter();

    Iterator<Long> getFibonacciIterator(int from, int to);
}
