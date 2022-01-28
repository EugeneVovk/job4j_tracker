package ru.job4j.stream;

import java.util.List;
import java.util.Optional;

/**
 * 4.6. Терминальные операции. Метод findFirst()
 * Для получения элемента из стрима можно использовать метод findFirst().
 * Этот метод возвращает Optional.
 * Если стрим пустой, то вернется пустой Optional,
 * а если не пустой, то вернется Optional из первого элемента стрима
 * Например,
 * Optinal<Integer> o1 = List.of().stream().findFirst();
 * - o1.isEmpty() == true
 * Optinal<Integer> o2 = List.of(1).stream().findFirst();
 * - o1.get() == 1
 *
 * Ваша задача получить первый элемент стрима списка
 */
public class FindFirstMethod {
    public static Optional<Integer> first(List<Integer> list) {
        return list.stream().findFirst();
    }
}
