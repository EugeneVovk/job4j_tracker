package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 9.1. Промежуточные операции. Метод sorted()
 * Для того, чтобы получить отсортированный стрим,
 * можно использовать метод sorted().
 * Стоит учесть, что реализация этого метода без входных параметров
 * использует реализованный метод compareTo() интерфейса Comparable.
 * Поэтому если вы сортируете объекты, определенного класса,
 * нужно либо передавать Comparator, либо реализовывать Comparable
 * <p>
 * Например,
 * List.of(3, 2, 1).stream().sorted()
 * - получим стрим из 1, 2, 3
 * Ваша задача, получить список отсортированных строк
 */
public class SortedMethod {
    public static List<String> sorted(List<String> strings) {
        return strings.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
