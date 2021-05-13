package com.hvillanueva.tarea.utils;

import java.util.Enumeration;
import java.util.stream.Stream;

import static java.util.Spliterator.IMMUTABLE;
import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.StreamSupport.stream;
import static org.springframework.util.CollectionUtils.toIterator;

public class CollectionUtils {

    public static <T> Stream<T> streamOf(Enumeration<T> enumeration) {
        return stream(
                spliteratorUnknownSize(toIterator(enumeration), IMMUTABLE), false);
    }
    private CollectionUtils() {}
}
