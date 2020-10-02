package ru.otus.patterns.factory.concrete;

import ru.otus.patterns.iterator.Iterator;
import ru.otus.patterns.iterator.fibonacci.IterativeFibonacci;

public class IterativeFlowFactory extends AbstractFlowFactory {

    public IterativeFlowFactory(String outputPath) {
        super(outputPath);
    }

    @Override
    public Iterator<Long> getFibonacciIterator(int from, int to) {
        return new IterativeFibonacci(from, to);
    }
}
