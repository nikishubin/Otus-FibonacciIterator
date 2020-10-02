package ru.otus.patterns.factory.concrete;

import ru.otus.patterns.iterator.Iterator;
import ru.otus.patterns.iterator.fibonacci.BinetFibonacci;

public class BinetFlowFactory extends AbstractFlowFactory {

    public BinetFlowFactory(String outputPath) {
        super(outputPath);
    }

    @Override
    public Iterator<Long> getFibonacciIterator(int from, int to) {
        return new BinetFibonacci(from, to);
    }
}
