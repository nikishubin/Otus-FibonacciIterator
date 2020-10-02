package ru.otus.patterns.adapter;

import ru.otus.patterns.external.writer.FileWriter;
import ru.otus.patterns.iterator.port.FibonacciOutput;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

public class FibonacciToFile implements FibonacciOutput {
    private static final String ELEMENT_DELIMITER = "\n";

    private final FileWriter writer;

    public FibonacciToFile(FileWriter writer) {
        this.writer = writer;
    }

    @Override
    public void write(Collection<Long> source) throws IOException {
        byte[] converted = convertFibonacciToByteArray(source);
        writer.write(converted);
    }

    private byte[] convertFibonacciToByteArray(Collection<Long> source) {
        String beautified = source.stream().map(String::valueOf).collect(Collectors.joining(ELEMENT_DELIMITER));
        return beautified.getBytes();
    }
}
