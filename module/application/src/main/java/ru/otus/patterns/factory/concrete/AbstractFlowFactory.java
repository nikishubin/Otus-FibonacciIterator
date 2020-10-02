package ru.otus.patterns.factory.concrete;

import ru.otus.patterns.adapter.FibonacciToFile;
import ru.otus.patterns.external.writer.impl.OutputStreamWriter;
import ru.otus.patterns.factory.FibonacciFlowFactory;
import ru.otus.patterns.iterator.port.FibonacciOutput;

public abstract class AbstractFlowFactory implements FibonacciFlowFactory {

    private final String outputPath;

    public AbstractFlowFactory(String outputPath) {
        this.outputPath = outputPath;
    }

    @Override
    public FibonacciOutput getWriter() {
        return new FibonacciToFile(new OutputStreamWriter(outputPath));
    }
}
