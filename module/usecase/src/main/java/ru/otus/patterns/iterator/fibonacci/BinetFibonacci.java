package ru.otus.patterns.iterator.fibonacci;

import ru.otus.patterns.iterator.Iterator;

public class BinetFibonacci implements Iterator<Long> {

    private final int limit;
    private final int direction;
    private int current;
    private int iteration;

    public BinetFibonacci() {
        this.current = 0;
        this.limit = Integer.MAX_VALUE;

        this.direction = 1;
    }

    public BinetFibonacci(int from, int to) {
        this.current = from;
        this.limit = Math.abs(Math.abs(from) - Math.abs(to));

        this.direction = from > to ? -1 : 1;
    }

    @Override
    public boolean hasNext() {
        return iteration <= limit;
    }

    @Override
    public Long next() {
        iteration++;

        double fiveSquare = Math.sqrt(5);
        double phi = (1 + fiveSquare) / 2;
        long element = (long) ((Math.pow(phi, current) - Math.pow(-phi, -current)) / fiveSquare);

        current = current + direction;
        return element;
    }
}
