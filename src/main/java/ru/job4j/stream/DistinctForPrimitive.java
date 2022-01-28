package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 8.1. Промежуточные операции. Метод distinct(). Уникальные числа
 * Для того, чтобы получить стрим из уникальных элементов
 * мы можем использовать метод distinct().
 * Если мы используем стрим примитивов,
 * то сравнение элементов идет через ==,
 * если стрим объектов, то через метод equals.
 * Например,
 * Arrays.stream(new int[] {1, 2, 1}).distinct()
 * - в стриме останутся только 1, 2
 *
 * Ваша задача собрать уникальные числа массива в список
 */
public class DistinctForPrimitive {
    public static List<Integer> collect(int[] data) {
        return Arrays.stream(data)
                .distinct()
                .boxed()
                .collect(Collectors.toList());
    }
}
