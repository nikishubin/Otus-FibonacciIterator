package ru.otus.patterns.iterator.fibonacci;

import ru.otus.patterns.iterator.Iterator;

public class IterativeFibonacci implements Iterator<Long> {

    private final int limit;
    private long previous = -1;
    private long current = 1;
    private int iteration;

    public IterativeFibonacci() {
        limit = Integer.MAX_VALUE;
    }

    public IterativeFibonacci(int from, int to) {
        this.limit = to;

        while (iteration < from) {
            next();
        }
    }

    @Override
    public boolean hasNext() {
        return iteration <= limit;
    }

    @Override
    public Long next() {
        iteration++;

        long temp = current;
        current = current + previous;
        previous = temp;
        return current;
    }
}
