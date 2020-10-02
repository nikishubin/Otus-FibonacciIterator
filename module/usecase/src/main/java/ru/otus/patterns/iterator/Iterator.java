package ru.otus.patterns.iterator;

public interface Iterator<T> {

    boolean hasNext();

    T next();
}
