package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Часто бывает нужно собрать результат обработки через стримы в список.
 * Для этого мы можем использовать методы collect() и Collectors.toList().
 * Сборка идет в ArrayList
 * <p>
 * Например,
 * List<Integer> result = List.of(1, 2).stream().collect(Collectors.toList());
 * <p>
 * Ваша задача собрать, переданный стрим в список
 */
public class CollectToList {

    public static List<Integer> collect(Stream<Integer> data) {
        return data.collect(Collectors.toList());
    }
}
