package ru.otus.patterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.otus.patterns.factory.FibonacciFlowFactory;
import ru.otus.patterns.factory.concrete.BinetFlowFactory;
import ru.otus.patterns.factory.concrete.IterativeFlowFactory;
import ru.otus.patterns.iterator.Iterator;
import ru.otus.patterns.iterator.port.FibonacciOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) throws IOException {
        String outputPath = args[0];
        int from = Integer.parseInt(args[1]);
        int to = Integer.parseInt(args[2]);

        FibonacciFlowFactory flow = getFlowByDirection(from, to, outputPath);

        Iterator<Long> fibonacciIterator = flow.getFibonacciIterator(from, to);
        List<Long> result = new ArrayList<>();
        while (fibonacciIterator.hasNext()) {
            result.add(fibonacciIterator.next());
        }
        FibonacciOutput writer = flow.getWriter();
        writer.write(result);
    }

    private static FibonacciFlowFactory getFlowByDirection(int from, int to, String outputPath) {
        log.info("Output path: {} ; Fibonacci numbers from {} to {}", outputPath, from, to);
        return from > to ? new BinetFlowFactory(outputPath) : new IterativeFlowFactory(outputPath);
    }
}
