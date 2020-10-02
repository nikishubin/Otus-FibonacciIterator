package ru.otus.patterns.iterator.port;

import java.io.IOException;
import java.util.Collection;

public interface FibonacciOutput {

    void write(Collection<Long> source) throws IOException;
}
